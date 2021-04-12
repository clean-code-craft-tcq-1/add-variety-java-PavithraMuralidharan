package main.java.TypewiseAlert;

import ServiceLocator.IServiceLocator;
import main.java.TypewiseAlert.Alerter.IAlerter;

public class TypewiseAlert 
{
	IServiceLocator locator;
	public TypewiseAlert(IServiceLocator locator)
	{
		this.locator = locator;
	}
	
	public static BreachType inferBreach(double value, double lowerLimit, double upperLimit) {
		if (value < lowerLimit) {
			return BreachType.TOO_LOW;
		}
		if (value > upperLimit) {
			return BreachType.TOO_HIGH;
		}
		return BreachType.NORMAL;
	}

	public static BreachType classifyTemperatureBreach(CoolingType coolingType, double temperatureInC) 
	{
		return inferBreach(temperatureInC, coolingType.lowerLimit, coolingType.upperLimit);
	}

	public void checkAndAlert(String alertTarget, BatteryCharacter batteryChar, double temperatureInC) throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		BreachType breachType = classifyTemperatureBreach(batteryChar.getCoolingType(), temperatureInC);
		((IAlerter) locator.getAleterService(alertTarget)).sendAlert(breachType);
	}

}
