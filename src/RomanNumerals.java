
public class RomanNumerals {
	
	public String convertToRoman(int value) {
		
		String roman = "";
		
		int singles   = value % 10;
		int tens      = ((value / 10)   % 10);
		int hundreds  = ((value / 100)  % 10);
		int thousands = ((value / 1000) % 10);
		
		while (thousands > 0) {
			roman += "M";
			thousands--;
		}
		
		if      (hundreds == 9) roman += "CM"; 
		else if (hundreds == 8) roman += "DCCC"; 
		else if (hundreds == 7) roman += "DCC"; 
		else if (hundreds == 6) roman += "DC"; 
		else if (hundreds == 5) roman += "D"; 
		else if (hundreds == 4) roman += "CD"; 
		else if (hundreds == 3) roman += "CCC"; 
		else if (hundreds == 2) roman += "CC";
		else if (hundreds == 1) roman += "C";
		
		if      (tens == 9) roman += "XC"; 
		else if (tens == 8) roman += "LXXX"; 
		else if (tens == 7) roman += "LXX"; 
		else if (tens == 6) roman += "LX"; 
		else if (tens == 5) roman += "L"; 
		else if (tens == 4) roman += "XL"; 
		else if (tens == 3) roman += "XXX"; 
		else if (tens == 2) roman += "XX";
		else if (tens == 1) roman += "X";
		
		if      (singles == 9) roman += "IX"; 
		else if (singles == 8) roman += "VIII"; 
		else if (singles == 7) roman += "VII"; 
		else if (singles == 6) roman += "VI"; 
		else if (singles == 5) roman += "V"; 
		else if (singles == 4) roman += "IV"; 
		else if (singles == 3) roman += "III"; 
		else if (singles == 2) roman += "II";
		else if (singles == 1) roman += "I";
		
		return roman;
		
	}
	
	public int convertToInteger(String romanNum) throws RomanNumeralException {
		
		if (isValidRomanNumeral(romanNum)) {
			return converter(romanNum);
		} else {
			throw new RomanNumeralException();
		}
	}
	
	public int converter(String roman) {
		
		int value = 0;
		
		for (int i=0; i<roman.length(); ++i) {
			char c = roman.charAt(i);
			int cValue = romanValueOfCharacter(c);
			int nextValue = 0;
			
			if (i != roman.length()-1) {
				char nextC = roman.charAt(i+1);
				nextValue  = romanValueOfCharacter(nextC);
			}
			
			if (cValue < nextValue) {
				value += nextValue - cValue;
				i++;
			} else {
				value += cValue;
			}
		}
		
		return value;
		
	}
	
	public int romanValueOfCharacter(char c) {
		switch (c) {
		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000;
		default:  return 0;
		}
	}
	
	public boolean isValidRomanNumeral(String roman) {
		
		if (!hasValidCharacters(roman))    return false;
		if (!hasValidRepetition(roman))    return false;
		if (!hasValidSubstractions(roman)) return false;
		
		return true;
		
	}
	
	public boolean hasValidCharacters(String roman) {
		String regex = "[IVXLCDM]+";
		return roman.matches(regex);
	}
	
	public boolean hasValidRepetition(String roman) {

		if (roman.contains("IIII")) return false;
		if (roman.contains("VV"))   return false;
		if (roman.contains("XXXX")) return false;
		if (roman.contains("LL"))   return false;
		if (roman.contains("CCCC")) return false;
		if (roman.contains("DD"))   return false;
		if (roman.contains("MMMM")) return false;
		
		return true;
	}
	
	public boolean hasValidSubstractions(String roman) {
		
		if (roman.contains("IIV")) return false;
		if (roman.contains("IIX")) return false;
		if (roman.contains("IL"))  return false;
		if (roman.contains("IC"))  return false;
		if (roman.contains("ID"))  return false;
		if (roman.contains("IM"))  return false;
		if (roman.contains("VX"))  return false;
		if (roman.contains("VL"))  return false;
		if (roman.contains("VC"))  return false;
		if (roman.contains("VD"))  return false;
		if (roman.contains("VM"))  return false;
		if (roman.contains("XXL")) return false;
		if (roman.contains("XXC")) return false;
		if (roman.contains("XD"))  return false;
		if (roman.contains("XM"))  return false;
		if (roman.contains("LC"))  return false;
		if (roman.contains("LD"))  return false;
		if (roman.contains("LM"))  return false;
		if (roman.contains("CCM")) return false;
		if (roman.contains("DM"))  return false;
		
		return true;
	}
	
	
	public int characterCountInString(String str, char c) {
		
		int count = 0;
		
		for (int i=0; i<str.length(); ++i) {
			char ci = str.charAt(i);
			if (ci == c) {
				count++;
			}
		}
		
		return count;
		
	}
}
