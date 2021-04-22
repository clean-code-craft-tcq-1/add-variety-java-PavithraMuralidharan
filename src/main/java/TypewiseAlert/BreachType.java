package main.java.TypewiseAlert;

public enum BreachType 
{
	NORMAL("normal"), 
	TOO_LOW("too low"), 
	TOO_HIGH("too high");

	String message;

	BreachType(String message) {
		this.message = String.format("Hi, the temperature is %s",message);
	}

	public String getMessage() {
		return message;
	}
}
	
	
