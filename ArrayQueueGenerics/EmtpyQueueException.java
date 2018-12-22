
/**
 * Exception class for accessing emtpy queues
 *
 */
public class EmtpyQueueException extends RuntimeException {
	public EmtpyQueueException(String mesg) {
		super(mesg);
	}
	
	public EmtpyQueueException(Throwable t) {
		super(t);
	}
	
	public EmtpyQueueException(String mesg, Throwable t) {
		super(mesg, t);
	}
}
