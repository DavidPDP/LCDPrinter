/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DigitConverter.java 2017-04-22$
 *
 * PSLTest: ImpresorLCD
 * Author: Johan David Ballesteros - Abr 22, 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.com.psl.lcdrefactor.logic.printer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.com.psl.lcdrefactor.logic.constants.ExceptionConstants;
import co.com.psl.lcdrefactor.logic.constants.LCDConstants;
import co.com.psl.lcdrefactor.logic.converter.DigitConverter;
import co.com.psl.lcdrefactor.logic.converter.IDigitConverter;
import co.com.psl.lcdrefactor.logic.exceptions.ParamsException;

/**
 * Class that represents the 
 */
public class LCDPrinter {
	
	/**
	 * Class Logger
	 */
	private static final Logger LOGGER = Logger.getLogger(LCDPrinter.class.getName());
	
	/**
	 * This method execute the program.
	 * @param args
	 */
	public static void main(String[] args){
		LCDPrinter executable = new LCDPrinter();
		List<String> commandList = new ArrayList<>();
		String comando;
		int spaceSize = -1;
		try (Scanner lector = new Scanner(System.in)) {
            System.out.print("Espacio entre Digitos (0 a 5): ");
            comando = lector.next();
            spaceSize = executable.validateAndConvertSpaceSize(comando);
            do
            {
                System.out.print("Entrada: ");
                comando = lector.next();
                if(!comando.equalsIgnoreCase(LCDConstants.FINAL_STRING))
                {
                    commandList.add(comando);
                }
            }while (!comando.equalsIgnoreCase(LCDConstants.FINAL_STRING)); 
            executable.printInConsole(commandList, spaceSize);
        }catch(ParamsException e){
        	LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }
	
	/**
	 * Validate the spaceSize and convert it in Integer type.
	 * @param spaceSize
	 * @return spaceSize validated and converted.
	 * @throws ParamsException 
	 */
	public int validateAndConvertSpaceSize(String spaceSize) throws ParamsException {
		int size = -1;
		if (spaceSize == null || spaceSize.equals("")) {
			throw new ParamsException(ExceptionConstants.INVALID_INPUT);
		}
		try {
			size = Integer.parseInt(spaceSize);
		} catch (NumberFormatException e) {
			throw new ParamsException(ExceptionConstants.INVALID_CONVERTED_NUMBER);
		}
		if (size < 0 || size > 5) {
			throw new ParamsException(ExceptionConstants.INVALID_RANGE_NUMBER);
		}
		return size;
	}
	
	
	/**
	 * Generate the pre-prints of all inputs that the user specified in console.
	 * @param commandList, user all inputs 
	 * @param spaceSize
	 * @return String list with the final print.
	 */
	public void printInConsole(List<String> commandList, int spaceSize){
		IDigitConverter digitConverter = new DigitConverter();
		ILCDGenerator lcdPrinter = new LCDGenerator(digitConverter);
        Iterator<String> iterator = commandList.iterator();
        while (iterator.hasNext()) {
            try {	
            	System.out.println(lcdPrinter.generateLCDDigits(iterator.next(), spaceSize));
            } catch (ParamsException e) {
            	LOGGER.log(Level.SEVERE, e.getMessage());
            }
        }
	}
}
