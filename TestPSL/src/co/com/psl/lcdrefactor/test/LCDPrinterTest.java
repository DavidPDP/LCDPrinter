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
	public void printLCDDigitsParamsExceptionTest(){
		String input = "asdfg";
		int spaceSize = -1;
		try {
			lCDGenerator.generateLCDDigits(input, spaceSize);
		} catch (ParamsException e) {
			assertEquals("The input doesn't have valid format",e.getMessage());
		}
	}

}
