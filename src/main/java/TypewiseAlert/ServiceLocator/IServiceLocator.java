package ServiceLocator;


public interface IServiceLocator {
	public <T> T getAleterService(String targetName) throws InstantiationException, IllegalAccessException, ClassNotFoundException;
}
