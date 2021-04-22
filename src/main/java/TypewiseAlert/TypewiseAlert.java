package main.java.TypewiseAlert;

import main.java.TypewiseAlert.Alerter.IAlerter;

public class TypewiseAlert 
{
	public static Boolean isNormal = true;
	public static BreachType inferBreach(double value, double lowerLimit, double upperLimit) 
	{
		if (value < lowerLimit) {
			isNormal = false;
			return BreachType.TOO_LOW;
		}
		if (value > upperLimit) {
			isNormal = false;
			return BreachType.TOO_HIGH;
		}
		return BreachType.NORMAL;
	}

	public static BreachType classifyTemperatureBreach(CoolingType coolingType, double temperatureInC) 
	{
		return inferBreach(temperatureInC, coolingType.lowerLimit, coolingType.upperLimit);
	}

	public void checkAndAlert(IAlerter alertTarget, BatteryCharacter batteryChar, double temperatureInC)
	{
		BreachType breachType = classifyTemperatureBreach(batteryChar.getCoolingType(), temperatureInC);
		alertTarget.sendAlert(breachType);
	}

}
