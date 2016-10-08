package convertR;

public class BinaryNumber extends NumberSystem {

	private final int binaryBase = 2;
	private String binaryNumber;
	
	//========== Constructors =========================================================================================
	
	BinaryNumber(){
		super.setNumberBase(binaryBase);

	}
	
	BinaryNumber(String number){
		super.setNumberBase(binaryBase);
		super.setNumberString(number);
		setBinaryNumber(number);
	}
	
	//========== Setters / Getters ====================================================================================
	
	/**
	 * Throws NumberFormatException if any number is not a 0 or 1
	 * @param binaryNumber
	 * @throws NumberFormatException if any number in parameter is less than 0 or greater than 1.
	 */
	public void setBinaryNumber(String binaryNumber) throws NumberFormatException{
		
		String num = super.getNumberString();
		
		// NumberFormatException if any number in parameter 
		// is less than 0 (ascii 48) or greater than 1 (ascii 49)
		for(int i = 0; i < num.length(); i++){
			int check = num.charAt(i);
			if( check < 48 || check > 49  ) throw new NumberFormatException();
		}
		
		this.binaryNumber = num;
	}

	public String getBinaryNumber() {
		return binaryNumber;
	}
}