package main.java.TypewiseAlert;

public class BatteryCharacter 
{
	private CoolingType coolingType;
	private String brand;

	public CoolingType getCoolingType() {
		return coolingType;
	}

	public BatteryCharacter setCoolingType(CoolingType coolingType) {
		this.coolingType = coolingType;
		return this;
	}

	public String getBrand() {
		return brand;
	}

	public BatteryCharacter setBrand(String brand) {
		this.brand = brand;
		return this;
	}
}