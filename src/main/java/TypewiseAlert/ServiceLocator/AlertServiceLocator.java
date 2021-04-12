package ServiceLocator;

import java.util.ArrayList;
import java.util.List;

import main.java.TypewiseAlert.Alerter.IAlerter;

public class AlertServiceLocator implements IServiceLocator 
{
	private List<IAlerter> services = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	@Override
	public IAlerter getAleterService(String targetName)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	 	String serviceName = targetName + "Alerter";
    	IAlerter service = findAlerter(serviceName);

        if (service != null) {
            return service;
        }

        IAlerter alertRef = new CreateInstance().createInstance(serviceName);
        services.add(alertRef);
        return alertRef;
	}
	
	IAlerter findAlerter(String alerter) {
		return services.stream().filter(service -> service.getClass().getName().equalsIgnoreCase(alerter)).findFirst()
				.orElse(null);
	}

}
