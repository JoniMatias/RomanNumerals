import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {
	
	@Test
	public void testConvertToRoman_999() {
		RomanNumerals roman = new RomanNumerals();
		
		String str = roman.convertToRoman(999);
		
		assertEquals("Numeral converted wrong", "CMXCIX", str);
	}
	
	@Test
	public void testConvertToRoman_3888() {
		RomanNumerals roman = new RomanNumerals();
		
		String str = roman.convertToRoman(3888);
		
		assertEquals("Numeral converted wrong", "MMMDCCCLXXXVIII", str);
	}
	
	@Test
	public void testConvertToInt_allValidValues() throws RomanNumeralException {
		
		RomanNumerals roman = new RomanNumerals();
		
		for (int i=1; i<4000; ++i) {
			String str = roman.convertToRoman(i);
			int value = roman.convertToInteger(str);
			
			assertEquals("Valid numeral discarded " + str + " " + i, i, value);
		}
		
	}
	
	@Test (expected = RomanNumeralException.class)
	public void testConvertToInt_throwsOnInvalid() throws RomanNumeralException {
		
		RomanNumerals roman = new RomanNumerals();
		
		String str = "ASDSAV";
		roman.convertToInteger(str);
		
	}
	
	@Test
	public void testIsValidNumeral_allValidValues() {
		
		RomanNumerals roman = new RomanNumerals();
		
		for (int i=1; i<4000; ++i) {
			String str = roman.convertToRoman(i);
			boolean value = roman.isValidRomanNumeral(str);
			
			assertEquals("Valid numeral discarded " + str + " " + i, true, value);
		}
		
	}
	
	@Test
	public void testCharacterCount_threeIs() {
		
		RomanNumerals roman = new RomanNumerals();
		
		String str = "IIFASI";
		
		int count = roman.characterCountInString(str, 'I');
		
		assertEquals("Invalid character count", 3, count);
		
	}
	
	@Test
	public void testCharacterCount_fourXs() {
		
		RomanNumerals roman = new RomanNumerals();
		
		String str = "XGSACXZHEXX";
		
		int count = roman.characterCountInString(str, 'X');
		
		assertEquals("Invalid character count", 4, count);
		
	}
	
	@Test
	public void testHasValidCharacters_allValidValues() {
		RomanNumerals roman = new RomanNumerals();
		
		for (int i=1; i<4000; ++i) {
			String str = roman.convertToRoman(i);
			boolean value = roman.hasValidCharacters(str);
			
			assertEquals("Invalid character count " + str + " " + i, true, value);
		}
	}
	
	@Test
	public void testHasValidCharacters_ASDSAV() {
		RomanNumerals roman = new RomanNumerals();
		
		String str = "ASDSAV";
		
		boolean value = roman.hasValidCharacters(str);
		
		assertEquals("Invalid characters passed the test", false, value);
	}

	@Test
	public void testHasValidRepetition_allValidValues() {

		RomanNumerals roman = new RomanNumerals();
		
		for (int i=1; i<4000; ++i) {
			String str = roman.convertToRoman(i);
			boolean value = roman.hasValidRepetition(str);
			
			assertEquals("Valid numeral discarded due to repetition " + str + " " + i, true, value);
		}

	}
	
	@Test
	public void testHasValidRepetition_tooManyXs() {
		RomanNumerals roman = new RomanNumerals();
		
		String str = "LXXXXVII";
		
		boolean value = roman.hasValidRepetition(str);
		
		assertEquals("Invalid repetitions passed", false, value);
	}
	
	@Test
	public void testHasValidRepetition_tooManyLs() {
		RomanNumerals roman = new RomanNumerals();
		
		String str = "MLLIX";
		
		boolean value = roman.hasValidRepetition(str);
		
		assertEquals("Invalid repetitions passed", false, value);
	}
	
	@Test
	public void testHasValidRepetition_tooManyEverything() {
		RomanNumerals roman = new RomanNumerals();
		
		String str = "MMMMDDCCCCLLXXXXVVIIII";
		
		boolean value = roman.hasValidRepetition(str);
		
		assertEquals("Invalid repetitions passed", false, value);
	}
	
	@Test
	public void testHasValidSubstractions_allValidValues() {
		RomanNumerals roman = new RomanNumerals();
		
		for (int i=1; i<4000; ++i) {
			String str = roman.convertToRoman(i);
			boolean value = roman.hasValidSubstractions(str);
			
			assertEquals("Valid numeral discarded due to substractions " + str + " " + i, true, value);
		}
	}
	
	@Test
	public void testHasValidSubstractions_IC() {
		RomanNumerals roman = new RomanNumerals();
		
		String str = "IC";
		
		boolean value = roman.hasValidSubstractions(str);
			
		assertEquals("Invalid numeral passed by substractions", false, value);
	}
	
	@Test
	public void testHasValidSubstractions_XM() {
		RomanNumerals roman = new RomanNumerals();
		
		String str = "XM";
		
		boolean value = roman.hasValidSubstractions(str);
			
		assertEquals("Invalid numeral passed by substractions", false, value);
	}
	
	@Test
	public void testHasValidSubstractions_VVX() {
		RomanNumerals roman = new RomanNumerals();
		
		String str = "VVX";
		
		boolean value = roman.hasValidSubstractions(str);
			
		assertEquals("Invalid numeral passed by substractions", false, value);
	}
	
}
