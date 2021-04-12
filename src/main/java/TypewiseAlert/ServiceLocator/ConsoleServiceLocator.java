package ServiceLocator;

import main.java.TypewiseAlert.Alerter.ConsoleAlerter;
import main.java.TypewiseAlert.Alerter.IAlerter;

public class ConsoleServiceLocator implements IServiceLocator {
	ConsoleAlerter consolealerter;
	public ConsoleServiceLocator(ConsoleAlerter alerter){
		consolealerter = alerter;
	}

	@Override
	public IAlerter getAleterService(String targetName) throws ClassNotFoundException
	{
		if(targetName.equals("Console"))
			return consolealerter;
		else
			throw new ClassNotFoundException();
	}

}
