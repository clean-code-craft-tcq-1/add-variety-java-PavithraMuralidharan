package ServiceLocator;

import java.util.ArrayList;
import java.util.List;

import main.java.TypewiseAlert.Alerter.IAlerter;

public class AlertServiceLocator implements IServiceLocator 
{
	private List<IAlerter> services = new ArrayList<>();
	
	IAlerter _alertRef;
	
	public AlertServiceLocator(IAlerter alertRef) 
	{
		this._alertRef = alertRef;
	}

	@SuppressWarnings("unchecked")
	@Override
	public IAlerter getAleterService(String targetName)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	 	String serviceName = targetName + "Alerter";
    	IAlerter service = findAlerter(serviceName);

        if (service != null) {
            return service;
        }
       
        IAlerter alertRef = new CreateInstance().createNewInstance(getQualifiedClassName(serviceName));
        services.add(alertRef);
        return alertRef;
	}
	
	private String getQualifiedClassName(String serviceName) {
		return  "main.java.TypewiseAlert.Alerter.".concat(serviceName);
	}

	IAlerter findAlerter(String alerter) {
		return services.stream().filter(service -> service.getClass().getName().equalsIgnoreCase(alerter)).findFirst()
				.orElse(null);
	}

}
