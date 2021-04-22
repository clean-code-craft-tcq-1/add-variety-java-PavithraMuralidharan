package test.java.TypewiseAlert;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import main.java.TypewiseAlert.BatteryCharacter;
import main.java.TypewiseAlert.BreachType;
import main.java.TypewiseAlert.CoolingType;
import main.java.TypewiseAlert.TypewiseAlert;
import main.java.TypewiseAlert.Alerter.ConsoleAlerter;
import main.java.TypewiseAlert.Alerter.ControllerAlerter;
import main.java.TypewiseAlert.Alerter.EmailAlerter;
import main.java.TypewiseAlert.Alerter.FakeAlerter;
import main.java.TypewiseAlert.Alerter.IAlerter;
import main.java.TypewiseAlert.Alerter.INotifyAlerter;

@RunWith(Parameterized.class)
public class TypewiseAlertTest 
{
	CoolingType type;
	double temperature;
	BatteryCharacter batteryCharacter;
	BreachType expectedResult;
	TypewiseAlert typewiseAlert;
	FakeAlerter fakeAlerter = new FakeAlerter();
	double upperLimit = 30;
	double lowerLimit = 20;
	
	
	public TypewiseAlertTest(CoolingType type, double temperature, BreachType expectedResult) {
	      this.type = type;
	      this.temperature = temperature;
	      this.expectedResult = expectedResult;
	  }
	
	@Parameterized.Parameters
	public static Collection input()
	{
		return Arrays.asList(new Object[][]{
	         {CoolingType.MED_ACTIVE_COOLING, 50, BreachType.TOO_HIGH},
	         {CoolingType.HI_ACTIVE_COOLING, 25, BreachType.NORMAL},
	         {CoolingType.PASSIVE_COOLING,-32,BreachType.TOO_LOW}
	       });
	}
	
	@Before
	public void initialize()
	{
		batteryCharacter = new BatteryCharacter().setCoolingType(type);
		typewiseAlert = new TypewiseAlert();
	}
	
    @Test
    public void infersBreachAsPerLimits()
    {
      assertEquals(expectedResult.getMessage(),TypewiseAlert.inferBreach(temperature,lowerLimit,upperLimit).getMessage());
    }
    
    @Test
    public void classifyTemperatureBreachAsPerCoolingType()
    {
      assertEquals(expectedResult,TypewiseAlert.classifyTemperatureBreach(type, temperature));
    }
    
    @Test
    public  void checkAndAlertAsPerAlertTarget() 
    {
    		typewiseAlert.checkAndAlert(fakeAlerter, batteryCharacter, temperature);
			assertEquals(expectedResult.getMessage(),fakeAlerter.message);
    }
    
    public void checkAndAlertAllTarget()
    {
    	INotifyAlerter alertReference = new INotifyAlerter();
    	alertReference.add(new EmailAlerter());
    	alertReference.add(new ConsoleAlerter());
    	alertReference.add(new ControllerAlerter());
		IAlerter alertTargets = alertReference;
		typewiseAlert.checkAndAlert(alertTargets,batteryCharacter, temperature);
	}

}
