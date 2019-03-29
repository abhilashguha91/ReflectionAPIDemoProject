package javaprep.reflection.demo;

public class UFOEnemyShip extends EnemyShip implements IAttackShip {
	
	// Private Variable
	private String idCode = "1001";
	private EnemyShip enemyShip;
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
	public UFOEnemyShip(int thisNumber, String thatString) {
		System.out.println("Inside Constructor with thisNumber: "+ thisNumber + " " + thatString); 
	}
	// Parameterized Constructor
	public UFOEnemyShip(EnemyShip enemyShip) {
		System.out.println("Inside Constructor with EnemyShip: With Name:"+ enemyShip.getShipName() + " & With Type: " + enemyShip.getShipType()); 
		this.enemyShip = enemyShip; 
	}
	
	
}
