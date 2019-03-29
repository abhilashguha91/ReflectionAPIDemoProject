package javaprep.reflection.demo;

public class EnemyShip implements IShip{
	
	private String shipName;
	private String shipType;
	public EnemyShip() {;
	}
	public EnemyShip(String shipName, String shipType) {
		this.shipName = shipName;
		this.shipType = shipType;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public String getShipType() {
		return shipType;
	}
	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

}
