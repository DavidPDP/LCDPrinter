package co.com.psl.lcdrefactor.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.com.psl.lcdrefactor.logic.converter.DigitConverter;
import co.com.psl.lcdrefactor.logic.converter.IDigitConverter;
import co.com.psl.lcdrefactor.logic.exceptions.ParamsException;
import co.com.psl.lcdrefactor.logic.printer.ILCDGenerator;
import co.com.psl.lcdrefactor.logic.printer.LCDGenerator;

public class LCDPrinterTest {
	
	private ILCDGenerator lCDGenerator;
	private IDigitConverter digitConverter;
	
	@Before
	public void setUp(){
		digitConverter = new DigitConverter();
		lCDGenerator = new LCDGenerator(digitConverter);
	}
	
	@Test
	public void printLCDDigitsInvalidInputTest(){
		String input = "";
		int spaceSize = 2;
		try {
			lCDGenerator.generateLCDDigits(input, spaceSize);
		} catch (ParamsException e) {
			assertEquals("The param is null or empty",e.getMessage());
		}
	}
	
	@Test
	public void printLCDDigitsInvalidFormatInputTest(){
		String input = "112";
		int spaceSize = 2;
		try {
			lCDGenerator.generateLCDDigits(input, spaceSize);
		} catch (ParamsException e) {
			assertEquals("The input doesn't have valid format",e.getMessage());
		}
	}
	
	@Test
	public void printLCDDigitsInvalidRangeNumberTest(){
		String input = "1,1a2";
		int spaceSize = 2;
		try {
			lCDGenerator.generateLCDDigits(input, spaceSize);
		} catch (ParamsException e) {
			assertEquals("The param contains some char that doesn't number",e.getMessage());
		}
	}
	
	@Test
	public void printLCDDigitsInvalidFormatTest1(){
		String input = "1,1234";
		int spaceSize = -1;
		try {
			lCDGenerator.generateLCDDigits(input, spaceSize);
		} catch (ParamsException e) {
			assertEquals("The param doesn't satisfy the interval",e.getMessage());
		}
	}
	@Test
	public void printLCDDigitsInvalidFormatTest2(){
		String input = "1,1234";
		int spaceSize = 6;
		try {
			lCDGenerator.generateLCDDigits(input, spaceSize);
		} catch (ParamsException e) {
			assertEquals("The param doesn't satisfy the interval",e.getMessage());
		}
	}
	
	@Test
	public void printLCDDigitsInIntervalTest(){
		String input = "1,1234";
		int spaceSize = 5;
		try {
			String digits = lCDGenerator.generateLCDDigits(input, spaceSize);
			assertEquals("         -       -              \n"+
						 "  |       |       |     | |     \n"+
						 "         -       -       -      \n"+
						 "  |     |         |       |     \n"+
						 "         -       -              \n", digits);
		} catch(ParamsException e){
			
		}
	}
	
	
}
