package main.java.TypewiseAlert.Alerter;

import main.java.TypewiseAlert.BreachType;

public class EmailAlerter implements IAlerter
{
	String recepient = "a.b@c.com";
	
	@Override
	public void sendAlert(BreachType breachType) {
		AlertMessage.alertMessage(String.format("To: %s%n %s", recepient,breachType));
	}
	
	
}
