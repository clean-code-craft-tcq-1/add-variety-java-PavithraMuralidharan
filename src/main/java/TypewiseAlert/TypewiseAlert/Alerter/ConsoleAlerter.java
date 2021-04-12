package main.java.TypewiseAlert.Alerter;

import main.java.TypewiseAlert.BreachType;

public class ConsoleAlerter implements IAlerter {
	@Override
	public void sendAlert(BreachType breachType) {
		AlertMessage.alertMessage(String.format("%s%n",breachType.getMessage()));
	}
}
