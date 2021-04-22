package main.java.TypewiseAlert.Alerter;

import main.java.TypewiseAlert.BreachType;

public interface IAlerter {
	public void sendAlert(BreachType breachType);
}
