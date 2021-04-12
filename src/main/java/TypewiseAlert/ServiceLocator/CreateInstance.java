package ServiceLocator;

import main.java.TypewiseAlert.Alerter.IAlerter;

public class CreateInstance
{
	IAlerter createInstance(String targetname)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		 return (IAlerter) Class.forName(targetname).newInstance();
	}


}
