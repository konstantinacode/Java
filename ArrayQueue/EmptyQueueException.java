/**
 * Exception class for accessing emtpy queues
 *
 */
public class EmptyQueueException extends RuntimeException {
	public EmptyQueueException(String mesg) {
		super(mesg);
	}
	
	public EmptyQueueException(Throwable t) {
		super(t);
	}
	
	public EmptyQueueException(String mesg, Throwable t) {
		super(mesg, t);
	}
}
