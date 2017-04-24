/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DigitConverter.java 2017-04-22$
 *
 * PruebaPSL: ImpresorLCD
 * Autor: Johan David Ballesteros - Abr 22, 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.com.psl.lcdrefactor.logic.printer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.com.psl.lcdrefactor.logic.constants.DigitsConstants;
import co.com.psl.lcdrefactor.logic.constants.ExceptionConstants;
import co.com.psl.lcdrefactor.logic.constants.LCDConstants;
import co.com.psl.lcdrefactor.logic.converter.IDigitConverter;
import co.com.psl.lcdrefactor.logic.exceptions.ParamsException;

/**
 * Class that represent the LCD Printer.
 */
public class LCDGenerator implements ILCDGenerator{
	
	/**
	 * Digit Converter Implementation.
	 */
	private IDigitConverter digitConverter;
	
	/**
	 * Map that stores the unique converted digits.
	 * Key: Digit, Value: Converted digit representation. 
	 */
	private Map<String,List<String>> convertedDigits;
	
	/**
	 * Constructor LCDPrinter.
	 * @param digitConverter, Digit Converter Implementation.
	 */
	public LCDGenerator(IDigitConverter digitConverter) {
		this.digitConverter = digitConverter;
		convertedDigits = new HashMap<>();
	}
	
	/**
	 * Get the input and converts each digit according to specified size.
	 * @param input, Data input with size and digits to convert.
	 * format: "size,digitsToConvert".
	 * @param spaceSize, The space size between digits.
	 * @throws ParamsException 
	 */
	public String generateLCDDigits(String input, int spaceSize) throws ParamsException{
		StringBuilder result = new StringBuilder();
		validateInput(input);
		String[] parameters = input.split(",");
		int size = validateAndConvertionSize(parameters[0]);
		validateDigits(parameters[1]);
		String[] digits = parameters[1].split("");
		String[] uniqueDigits = Arrays.stream(digits).distinct().toArray(String[]::new);
		for(String digit:uniqueDigits){
			convertedDigits.put(digit, 
					digitConverter.convertDigit(size, DigitsConstants.LCDrepresatation(digit)));
		}
		int rowSize = (size*LCDConstants.VERTICAL_SEGMENTS)+LCDConstants.HORIZONTAL_SEGMENTS;
		String space = generateSpaces(spaceSize);
		for(int i=0; i < rowSize; i++){
			StringBuilder stringBuilder = new StringBuilder("");
			for(String digit:digits){
				List<String> value = convertedDigits.get(digit);
				stringBuilder.append(value.get(i)+space);
			}
			stringBuilder.append("\n");
			result.append(stringBuilder.toString());
		}
		return result.toString();
	}
	
	/**
	 * Validate that the input will be correct (don't null, empty and contains ",")
	 * @param input, the data input.
	 * @throws ParamsException 
	 */
	private void validateInput(String input) throws ParamsException{
		if(input == null || input.equals("")){
			throw new ParamsException(ExceptionConstants.INVALID_INPUT);
		}
		if(!input.contains(",")){
			throw new ParamsException(ExceptionConstants.INVALID_FORMAT_INPUT);
		}
	}
	
	/**
	 * Validate that the increase/zoom is correct and converts to Integer type.  
	 * @param size, increase/zoom.
	 * @return Size converted to Integer.
	 * @throws ParamsException 
	 */
	private int validateAndConvertionSize(String size) throws ParamsException{
		int convertion = -1;
		try{
			convertion = Integer.parseInt(size);
		}
		catch(NumberFormatException e){
			throw new ParamsException(ExceptionConstants.INVALID_CONVERTED_NUMBER);
		}
		if(convertion < 1 || convertion > 10){
			throw new ParamsException(ExceptionConstants.INVALID_RANGE_NUMBER);
		}
		return convertion;
	}
	
	/**
	 * Validate that the digits are be between 0 to 9.
	 * @param digits, digits to validate.
	 * @throws ParamsException 
	 */
	private void validateDigits(String digits) throws ParamsException{
		if(!(digits.matches("\\d+"))){
			throw new ParamsException(ExceptionConstants.INVALID_CONVERTED_NUMBER);
		}
	}
	
	/**
	 * Generate a string with the specified spaces number.
	 * @param sizeSpaces, spaces number to generate.
	 * @return String with the specified spaces number.
	 */
	private String generateSpaces(int sizeSpaces){
		if(sizeSpaces == 0){
			return "";
		}else{
			return String.format("%"+sizeSpaces+"s", "");
		}
	}
}
