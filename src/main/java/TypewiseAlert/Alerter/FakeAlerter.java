package main.java.TypewiseAlert.Alerter;

import main.java.TypewiseAlert.BreachType;

public class FakeAlerter implements IAlerter {
	String  message;

	public String getMessage() {
		return message;
	}
	
	@Override
	public void sendAlert(BreachType breachType) {
		message = breachType.getMessage();
		AlertMessage.alertMessage(message);
		
	}

}
