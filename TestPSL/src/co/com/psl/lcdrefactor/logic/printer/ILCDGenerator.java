/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DigitConverter.java 2017-04-22$
 *
 * PruebaPSL: ImpresorLCD
 * Autor: Johan David Ballesteros - Abr 22, 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.com.psl.lcdrefactor.logic.printer;

import co.com.psl.lcdrefactor.logic.exceptions.ParamsException;

/**
 * Interface that contains the LCD Printer services.
 */
public interface ILCDGenerator {
	
	/**
	 * Get the input and converts each digit according to specified size.
	 * @param input, Data input with size and digits to convert.
	 * format: "size,digitsToConvert".
	 * @param spaceSize, The space size between digits.
	 * @throws ParamsException 
	 */
	public String generateLCDDigits(String input, int spaceSize) throws ParamsException;
	
}
