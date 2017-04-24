/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DigitConverter.java 2017-04-22$
 *
 * PSLTest: ImpresorLCD
 * Author: Johan David Ballesteros - Abr 22, 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package co.com.psl.lcdrefactor.logic.converter;

import java.util.List;

/**
 * Interface that contains the Digit Converter services.
 */
public interface IDigitConverter {
	
	/**
	 * Get the digit base representation and converts in a increased/zoom representation
	 * according to size.
	 * <b>pre: </b> The size is a positive integer greater than zero(0) and
	 * the digitRepresentation doesn't null or empty. 
	 * @param size, increase/zoom that will have the digit. 
	 * @param digitRepresentation, digit base representation to convert.
	 * @return String list with the digit increased representation.
	 */
	public List<String> convertDigit(int size, final String[] digitRepresatation);
	
}
