/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DigitConverter.java 2017-04-22$
 *
 * PSLTest: ImpresorLCD
 * Author: Johan David Ballesteros - Abr 22, 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.com.psl.lcdrefactor.logic.converter;

import java.util.ArrayList;
import java.util.List;

import co.com.psl.lcdrefactor.logic.constants.LCDConstants;

/**
 * Class that represents the Digit Converter.
 */
public class DigitConverter implements IDigitConverter{
	
	/**
	 * Get the digit base representation and converts in a increased/zoom representation
	 * according to size.
	 * <b>pre: </b> The size is a positive integer greater than zero(0) and
	 * the digitRepresentation doesn't null or empty. 
	 * @param size, increase/zoom that will have the digit. 
	 * @param digitRepresentation, digit base representation to convert.
	 * @return String list with the digit increased representation.
	 */
	public List<String> convertDigit(int size, final String[] digitRepresentation){
		List<String> digitConverted = new ArrayList<>();
		for(String partRepresatation:digitRepresentation){
			if(size == 1){
				digitConverted.add(partRepresatation);
			}
			else{
				String conversion = "";
				if(partRepresatation.contains(LCDConstants.VERTICAL_CHAR)){
					conversion = addCharsInRepresatationBySize(size, 
							partRepresatation,LCDConstants.SPACE_CHAR);
					for(int i=0; i < size; i++){
						digitConverted.add(conversion);
					}
				}
				else if(partRepresatation.contains(LCDConstants.HORIZONTAL_CHAR)){
					conversion = addCharsInRepresatationBySize(size,
							partRepresatation, LCDConstants.HORIZONTAL_CHAR);
					digitConverted.add(conversion);
				}
				else if(partRepresatation.contains(LCDConstants.SPACE_CHAR)){
					conversion = addCharsInRepresatationBySize(size,
							partRepresatation, LCDConstants.SPACE_CHAR);
					digitConverted.add(conversion);
				}
			}	
		}
		return digitConverted;
	}
	
	/**
	 * Get a part of digit representation and adds a specified type char,
	 * this execute a n number times.
	 * <b>pre: </b> The size is a positive integer greater than zero(0),
	 * the initialPartRepresatation doesn't null or empty, also the type char.
	 * @param size, increase/zoom that will have the digit.
	 * @param basePartRepresatation, a part of digit base representation that adds the char.
	 * @return String with the part of digit base representation with the char.
	 */
	private String addCharsInRepresatationBySize(int size, final String basePartRepresatation,
			final String typeChar){
		StringBuilder stringBuilder = new StringBuilder(basePartRepresatation);
		for(int i=0; i < size-1; i++){
			stringBuilder.insert(1, typeChar);
		}
		return stringBuilder.toString();
	}
}
