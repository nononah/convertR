package convertR;

public class HexNumber extends NumberSystem {

	private final int base = 16;
	private String number;
	private final char[] validChars = { 'A' , 'B', 'C', 'D', 'E', 'F','a', 'b', 'c', 'd', 'e', 'f'};

	//========== Constructors =========================================================================================
	
	HexNumber(){
		super.setNumberBase(base);
		
	}
	
	HexNumber(String number){
		super.setNumberBase(base);
		super.setNumberString(number);
		this.setHexNumber(number);
	}
	
	//========== Setters / Getters ====================================================================================

	public String getHexNumber() {
		return this.number;
	}

	/**
	 * Valid hexadecimal number must be a number between 0-9 or a char from either A-F or a-f.
	 * Throws NumberFormatException  
	 * @param number
	 */
	public void setHexNumber(String number) {
		
		StringBuilder str = new StringBuilder();
		boolean invalid = false;
		String num = super.getNumberString();
		char[] chararray = num.toCharArray();
		
		// verify if each char is valid or is a digit 
		for(char c: chararray){
			
			if(Character.isLetter(c)){
				invalid = true;
				for(char d: this.validChars){
					if( c == d){
						invalid = false;
						str.append(c);
						break;
					}
				}
				
			}
			if(invalid) throw new NumberFormatException();
			else if( c > 57 && c < 48) throw new NumberFormatException();
			else str.append(c);	
		}
		
		String strnum = str.toString();
		this.number = strnum;

	}	
}