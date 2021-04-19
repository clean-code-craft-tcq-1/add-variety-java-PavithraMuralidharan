package test.java.TypewiseAlert;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import ServiceLocator.AlertServiceLocator;
import main.java.TypewiseAlert.BatteryCharacter;
import main.java.TypewiseAlert.BreachType;
import main.java.TypewiseAlert.CoolingType;
import main.java.TypewiseAlert.TypewiseAlert;
import main.java.TypewiseAlert.Alerter.FakeAlerter;

@RunWith(Parameterized.class)
public class TypewiseAlertTest 
{
	CoolingType type;
	double temperature;
	BatteryCharacter batteryCharacter;
	BreachType expectedResult;
	TypewiseAlert typewiseAlert;
	FakeAlerter fakeAlerter = new FakeAlerter();
	
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
	         {CoolingType.HI_ACTIVE_COOLING, 44, BreachType.NORMAL},
	         {CoolingType.PASSIVE_COOLING,-32,BreachType.TOO_LOW}
	       });
	}
	
	@Before
	public void initialize()
	{
		batteryCharacter = new BatteryCharacter().setCoolingType(type);
		typewiseAlert = new TypewiseAlert(new AlertServiceLocator(fakeAlerter));
	}
	
    @Test
    public void infersBreachAsPerLimits()
    {
      assertEquals(BreachType.TOO_LOW, TypewiseAlert.inferBreach(12, 20, 30));
    }
    
    @Test
    public void classifyTemperatureBreachAsPerCoolingType()
    {
      assertEquals(expectedResult,TypewiseAlert.classifyTemperatureBreach(type, temperature));
    }
    
    @Test
    public  void checkAndAlertAsPerAlertTarget() {
    	
		try 
		{
			typewiseAlert.checkAndAlert("Fake", batteryCharacter, temperature);
			assertEquals(expectedResult.getMessage(),fakeAlerter.getMessage());
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    }

}
