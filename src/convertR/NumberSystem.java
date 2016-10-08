package convertR;

public abstract class NumberSystem {

	private int numberBase;
	private String numberString;
	
	
	//========== Setters / Getters ====================================================================================	
	
	public int getNumberBase() {
		return numberBase;
	}



	public void setNumberBase(int numberBase) {
		this.numberBase = numberBase;
	}



	public String getNumberString() {
		return numberString;
	}



	public void setNumberString(String number2) {
		this.numberString = number2;
	}
	
	//========== Methods ==============================================================================================
	
	/**
	 * 
	 * @param number must be a DecimalNumber object.
	 * @param type must be an object from a subclass of NumberSystem.
	 * @return a String conversion of a Decimal to specified NumberSystem.
	 */
	public String convertFromDecimalTo(DecimalNumber object, NumberSystem type){
		
		int base = type.getNumberBase();
		long num = object.getDecimalNumber();
		int remainder = 0;
		
		StringBuilder str = new StringBuilder("");
			
		// return if number is already a decimal
		if(base == 10) return this.numberString;
		
		// The method of conversion is dividing the quotient by the base
		// and appending the remainder to a StringBuilder. When division
		// is finished the final conversion is reversing the chars to
		// the reverse order they were appended (last to first).
		while(num >= 1){
			
			if(num < base){
				if( (base == 16) && (num > 9) ){ 
					int num2 = (int) num;
					char c = this.hexIntToChar(num2);
					str.append(c);
					break;
				}
				else{
					str.append(num); 
					break;
				}
			}
			else{
				remainder = (int) (num % base);
				if(base == 16 && remainder > 9 ) str.append(hexIntToChar(remainder));
				else str.append(remainder);
				num = num / base;
			}
		} 
		
		String ans = str.reverse().toString();
		return ans;
		
	}

	/**
	 * Converts a number to the Decimal (base 10) equivalent.
	 * Supports conversion from Binary, Octal or Hexadecimal formats.
	 * @throws NumberFormatException
	 */
	public String convertToDecimal() throws NumberFormatException{
			
		int base = this.numberBase;
		String number = this.numberString;
		final long maxLong = 9223372036854775807L;
		
		// return if number is already a decimal
		if(base == 10) return number;
		
		char[] chararray = number.toCharArray();
		int num = 0; 
		int power = chararray.length - 1;
		long result = 0;
		
		for(char c: chararray){
			if(Character.isLetter(c))	num = validateHexChars(c);	
			if(Character.isDigit(c)) 	num = Character.getNumericValue(c);
									
			result += (long) ((num * Math.pow(base, power)));
			if ( (result > maxLong) || result < 0) throw new NumberFormatException();
			power--;
			
		}
		String decimal = Long.toString(result);
		return decimal;
	}

	/**
	 * 
	 * @param c char
	 * @return The integer equivalent of a Hex char.
	 * @throws NumberFormatException
	 */
	private int validateHexChars(char c) throws NumberFormatException{
		
		int num;
		
		switch(c){
		case 'A':
			num = 10;
			break;
		case 'a':
			num = 10;
			break;
		case 'B':
			num = 11;
			break;
		case 'b':
			num = 11;
			break;
		case 'C':
			num = 12;
			break;
		case 'c':
			num = 12;
			break;
		case 'D':
			num = 13;
			break;
		case 'd':
			num = 13;
			break;
		case 'E':
			num = 14;
			break;
		case 'e':
			num = 14;
			break;
		case 'F':
			num = 15;
			break;
		case 'f':
			num = 15;
			break;
		default:
			throw new NumberFormatException();
		}
		return num;
	}
		
	/**
	 * 
	 * @param number integer
	 * @return the char representing the decimal equivalents 11,12,13,14,15.
	 */
	private char hexIntToChar(int number) {
		
		char c = '0';
		
		switch(number){
		case 10:
			c = 'A';
			break;
		case 11:
			c = 'B';
			break;
		case 12:
			c = 'C';
			break;
		case 13:
			c = 'D';
			break;
		case 14:
			c = 'E';
			break;
		case 15:
			c = 'F';
			break;
		}
		return c;
	}	
}
