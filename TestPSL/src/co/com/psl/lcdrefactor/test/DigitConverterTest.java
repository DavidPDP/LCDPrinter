package co.com.psl.lcdrefactor.test;

import org.junit.Before;
import org.junit.Test;

import co.com.psl.lcdrefactor.logic.constants.DigitsConstants;
import co.com.psl.lcdrefactor.logic.converter.DigitConverter;
import co.com.psl.lcdrefactor.logic.converter.IDigitConverter;

import static org.junit.Assert.*;

import java.util.List;

public class DigitConverterTest {
	
	private IDigitConverter digitConverter;
	
	@Before
	public void setUp(){
		digitConverter = new DigitConverter();
	}
	
	public String appendList(List<String> digit){
		StringBuilder stringBuilder = new StringBuilder();
		digit.forEach(stringBuilder::append);
		return stringBuilder.toString();
	}
	
	@Test
	public void convertDigitZero(){
		List<String> digit = digitConverter.convertDigit(1, DigitsConstants.LCDrepresatation("0"));
		String actual = appendList(digit);
		assertEquals(" - | |   | | - ",actual);
	}
	
	@Test
	public void convertDigitNine(){
		List<String> digit = digitConverter.convertDigit(10, DigitsConstants.LCDrepresatation("9"));
		String actual = appendList(digit);
		System.out.println(actual);
		assertEquals(" ---------- |          ||          ||          ||          ||"
				+ "          ||          ||          ||          ||          ||"
				+ "          | ----------            |           |           |           |"
				+ "           |           |           |           |           |           |"
				+ " ---------- ",actual);
	}
	
}
