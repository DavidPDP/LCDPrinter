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
	public void printLCDDigitsTest() {
		String input = "1,123456789";
		int spaceSize = 5;
		try {
			String result = lCDGenerator.generateLCDDigits(input, spaceSize);
			System.out.println(result);
			assertEquals("         -       -               -       -       -       -       -       \n"+
					     "  |       |       |     | |     |       |         |     | |     | |      \n"+
					     "         -       -       -       -       -               -       -       \n"+
					     "  |     |         |       |       |     | |       |     | |       |      \n"+
					     "         -       -               -       -               -       -       \n", result);
		} catch (ParamsException e) {
			
		}
	}
	
	@Test(expected=ParamsException.class)
	public void printLCDDigitsParamsExceptionTest(){
		String input = "asdfg";
		int spaceSize = -1;
		try {
			lCDGenerator.generateLCDDigits(input, spaceSize);
		} catch (ParamsException e) {
			
		}
	}

}
