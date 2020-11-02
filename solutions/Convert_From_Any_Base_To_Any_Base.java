class Solution {
  
public String changeBase(String numAsString, int b1, int b2) {
		boolean isNegative = numAsString.startsWith("-");
		int start = isNegative ? 1 : 0;
		int maxPower = numAsString.length() - 1;
		int numBase10 = 0;

		for (int i = start; i < numAsString.length(); i++) {
			boolean isPlaceDigit = Character.isDigit(numAsString.charAt(i));
			// need debug
			int currDigit;
			if (isPlaceDigit) {
				currDigit = numAsString.charAt(i) - '0';
			} else {
				currDigit = numAsString.charAt(i) - 'A' + 10;
			}

			numBase10 += currDigit * Math.pow(b1, maxPower - i);
		}

		if (numBase10 == 0) {
			return "0";
		} else {
			return (isNegative ? "-" : "") + base10ToNewBase(numBase10, b2);
		}
	}

	private String base10ToNewBase(int numBase10, int b2) {
		if(numBase10 == 0) return ""; // base case
		char lsdAsChar;
		int lsdUnderFinalBase = numBase10 % b2;
		boolean needsHexConversion = (lsdUnderFinalBase >= 10);
		
		if(needsHexConversion) {
			lsdAsChar = (char) ('A' + lsdUnderFinalBase - 10);
		}else {
			lsdAsChar = (char) ('0' + lsdUnderFinalBase);
		}
		
		
		int base10WithoutLsd = numBase10 / b2;
		String left = base10ToNewBase(base10WithoutLsd, b2);
		return left + lsdAsChar;
	}
}