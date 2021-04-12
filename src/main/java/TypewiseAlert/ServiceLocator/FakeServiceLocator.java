package ServiceLocator;

import main.java.TypewiseAlert.Alerter.FakeAlerter;
import main.java.TypewiseAlert.Alerter.IAlerter;

public class FakeServiceLocator implements IServiceLocator {
	FakeAlerter fakealerter;
	public FakeServiceLocator(FakeAlerter alerter){
		fakealerter = alerter;
	}

	@Override
	public IAlerter getAleterService(String targetName)
			throws ClassNotFoundException {
		if(targetName.equals("Fake"))
			return fakealerter;
		else
			throw new ClassNotFoundException();
	}

}
