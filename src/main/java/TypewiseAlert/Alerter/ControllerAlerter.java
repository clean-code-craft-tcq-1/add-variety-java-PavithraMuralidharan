package main.java.TypewiseAlert.Alerter;

import main.java.TypewiseAlert.BreachType;

public class ControllerAlerter implements IAlerter
{
	int header = 0xfeed;

	@Override
	public void sendAlert(BreachType breachType) {
		AlertMessage.alertMessage(String.format("%i : %i", header, breachType));
	}
}
