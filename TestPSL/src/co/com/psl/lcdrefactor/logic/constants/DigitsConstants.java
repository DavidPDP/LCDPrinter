/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DigitConverter.java 2017-04-22$
 *
 * PSLTest: ImpresorLCD
 * Author: Johan David Ballesteros - Abr 22, 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.com.psl.lcdrefactor.logic.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Digits to use 
 */
public enum DigitsConstants {
	/**
	 * ZERO
	 */
	 // Representación Base Digito CERO:
	 //  - 
	 // | |
	 //    
	 // | | 
	 //  -   
	DIGIT_ZERO("0"," - ","| |","   ","| |"," - "), 
	/**
	 * ONE
	 */
	 // Representación Base Digito UNO:
	 //    
	 //   |   
	 //    
	 //   |     
	 //
	DIGIT_ONE("1","   ","  |","   ","  |","   "), 
	/**
	 * TWO
	 */
	 //Representación Base Digito DOS:
	 //  - 
	 //   |
	 //  - 
	 // |  
	 //  -     
	DIGIT_TWO("2"," - ","  |"," - ","|  "," - "), 
	/**
	 * THREE
	 */
	DIGIT_THREE("3"," - ","  |"," - ","  |"," - "), 
	/**
	 * FOUR
	 */
	DIGIT_FOUR("4","   ","| |"," - ","  |","   "), 
	/**
	 * FIVE
	 */
	DIGIT_FIVE("5"," - ","|  "," - ","  |"," - "), 
	/**
	 * SIX
	 */
	DIGIT_SIX("6"," - ","|  "," - ","| |"," - "), 
	/**
	 * SEVEN
	 */
	DIGIT_SEVEN("7"," - ","  |","   ","  |","   "), 
	/**
	 * EIGTH
	 */
	DIGIT_EIGHT("8"," - ","| |"," - ","| |"," - "), 
	/**
	 * NINE
	 */
	DIGIT_NINE("9"," - ","| |"," - ","  |"," - ");
	
	/**
	 *  Digit.
	 */
	private final String value;
	/**
	 * Digit base representation in LCD format
	 */
	private final String[] LCDrepresatation;
	
	/**
	 * Map that stores all digits and its representations
	 * Key: Digit, Value: Digit base representation in LCD format.
	 */
	private static Map<String, String[]> map = new HashMap<>();
	
	/**
	 * Constructor DigitsConstants. 
	 * @param value, Digit.
	 * @param LCDrepresatation, Digit base representation in LCD format.
	 */
	DigitsConstants(String value, String... LCDrepresatation) {
		this.value = value;
		this.LCDrepresatation = LCDrepresatation;
	}
	
	/**
	 * Is responsible to adds all digits with its representations in the map.
	 */
	static {
        for (DigitsConstants digitConstants : DigitsConstants.values()) {
            map.put(digitConstants.value, digitConstants.LCDrepresatation);
        }
    }
	
	/**
	 * Is responsible to obtain the digit LCD representation through digit.
	 * @param value, Digit.
	 * @return Digit LCD representation.
	 */
	public static String[] LCDrepresatation(String value){
		return map.get(value);
	}
}
