/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DigitConverter.java 2017-04-22$
 *
 * PSLTest: ImpresorLCD
 * Author: Johan David Ballesteros - Abr 22, 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.com.psl.lcdrefactor.logic.exceptions;

/**
 * Class that represent Params Exception.
 */
public class ParamsException extends Exception{
	
	/**
	 * Version Indicator for Serialization
	 */
	private static final long serialVersionUID = 5034412749543540201L;
	
	/**
	 * Construct the exception with the message that pass as parameter
	 * @param cause
	 */
	public ParamsException(String cause){
		super(cause);
	}
}
