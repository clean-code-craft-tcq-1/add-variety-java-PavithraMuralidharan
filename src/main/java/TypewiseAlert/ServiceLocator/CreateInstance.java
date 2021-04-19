package ServiceLocator;

import main.java.TypewiseAlert.Alerter.IAlerter;

public class CreateInstance
{
	IAlerter createNewInstance(String targetname)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		System.out.println(targetname);
		 return (IAlerter) Class.forName(targetname).newInstance();
	}
	
}
