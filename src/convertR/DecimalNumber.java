package convertR;

public class DecimalNumber extends NumberSystem{

	private final int decimalBase = 10; 
	
	private long decimalNumber;

	//========== Constructors =========================================================================================
	
	DecimalNumber(String number){
		super.setNumberBase(decimalBase);
		super.setNumberString(number);
		this.setDecimalNumber(number);
	}

	//========== Setters / Getters ====================================================================================
	
	public void setDecimalNumber(String decimal){
		
		this.decimalNumber = Long.parseLong(decimal);
		super.setNumberString(decimal);	
	}

	/**
	 * @return the decimalNumber
	 */
	public long getDecimalNumber() {
		return decimalNumber;
	}
	
	//========== Methods ==============================================================================================	

	@Override
	public String toString(){
		String str = Long.toString(decimalNumber);
		return str;
	}
}