package main.java.TypewiseAlert.Alerter;

import main.java.TypewiseAlert.BreachType;

public class FakeAlerter implements IAlerter {
	public String message = "";
	
	@Override
	public void sendAlert(BreachType breachType) {
		this.message = breachType.getMessage();
		AlertMessage.alertMessage(message);
		
	}

}
