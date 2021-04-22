package main.java.TypewiseAlert.Alerter;

import java.util.ArrayList;
import java.util.List;

import main.java.TypewiseAlert.BreachType;

public class INotifyAlerter implements IAlerter 
{
	 List<IAlerter> alerters = new ArrayList<>();
	    public void add(IAlerter observer)
	    {
	    	alerters.add(observer);
	    }
	    
	    void notifyAlerter(BreachType breachType){
	    	for(IAlerter alertType: alerters) {
				alertType.sendAlert(breachType);
			}
	    }

		@Override
		public void sendAlert(BreachType breachType) {
			this.notifyAlerter(breachType);
			
		}
}
