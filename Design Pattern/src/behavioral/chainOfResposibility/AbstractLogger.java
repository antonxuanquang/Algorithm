package behavioral.chainOfResposibility;

public abstract class AbstractLogger {
	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;
	
	protected int level;
	
	//next element in chain or resposibility
	protected AbstractLogger next;
	
	public void setNextLogger(AbstractLogger nextLogger) {
		next = nextLogger;
	}
	
	public void logMessage(int level, String message) {
		if (this.level <= level) {
			write(message);
		} 
		if (next != null) {
			next.logMessage(level, message);
		}
	}
	
	abstract protected void write(String message);
}
