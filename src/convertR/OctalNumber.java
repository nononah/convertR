package convertR;

public class OctalNumber extends NumberSystem {
	
	private final int octalBase = 8;
	private long octalNumber;
	
	
	//========== Constructors =========================================================================================
	
	OctalNumber(){
		super.setNumberBase(octalBase);
		
	}
	
	OctalNumber(String number){
		super.setNumberBase(octalBase);
		super.setNumberString(number);
		this.setOctalNumber(number);
	}

	//========== Setters / Getters ====================================================================================
	

	public long getOctalNumber() {
		return octalNumber;
	}


	/**
	 * Throws NumberFormatException if any number is less than 0 or greater than 8.
	 * @param number
	 * @throws NumberFormatException if any number in parameter is less than 0 or greater than 8. 
	 */
	public void setOctalNumber(String number) throws NumberFormatException {
		
		String num = super.getNumberString();
			
		// NumberFormatException if any number in parameter 
		// is less than 0 (ascii 48) or greater than 7 (ascii 55)
		for(int i = 0; i < num.length(); i++){
			int check = num.charAt(i);
			if( check < 48 || check > 55) throw new NumberFormatException();
		}
		
		this.octalNumber = Long.parseLong(number);
	}	
}
