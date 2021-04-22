package main.java.TypewiseAlert.Alerter;

import main.java.TypewiseAlert.BreachType;
import main.java.TypewiseAlert.TypewiseAlert;

public class EmailAlerter implements IAlerter
{
	String recepient = "a.b@c.com";
	
	@Override
	public void sendAlert(BreachType breachType) {
		if(Boolean.FALSE.equals(TypewiseAlert.isNormal))
			AlertMessage.alertMessage(String.format("To: %s%n %s", recepient,breachType));
	}
}
