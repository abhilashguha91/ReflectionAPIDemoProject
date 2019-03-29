package javaprep.reflection.demo;

public class UFOEnemyShip extends EnemyShip implements IAttackShip {
	
	// Private Variable
	private String idCode = "1001";
	// public method
	public String getPublicMethod(String s) {return "How did u get this?";}
	// protected method
	protected String getProtectedMethod() {return "How did u get this?";}
	// Default method
	String getDefaultMethod() {return "How did u get this?";}
	// Private Method
	private String getPrivateMethod() {return "How did u get this?";}
	// Private Methods with arguments
	private String getParameterizedPrivateMethod(int thisNumber, String thatString) {
		return "Inside getParameterizedPrivateMethod() with thisNumber: "+ thisNumber + " " + thatString;
	}
	// Parameterized Constructor
	UFOEnemyShip(int thisNumber, String thatString) {
		System.out.println("Inside Constructor with thisNumber: "+ thisNumber + " " + thatString); 
	}
	
	
	
}
