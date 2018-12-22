/**
 * 
 * interface Queue of T items. Declares the basic methods a queue must support, i.e.
 * 1. enqueue
 * 2. dequeue
 * 3. isEmpty
 *
 */

public interface Queue<T> {
		
	/**
	* Insert a new item into the queue.
	* @param x the item to insert.
	*/	
	public void enqueue( T x );
	
	/**
	* Return and remove the least recently inserted item
	* from the queue.
	* @return the least recently inserted item in the queue.
	* @throws UnderflowException if the queue is empty.
	*/
	public T dequeue( ) throws EmtpyQueueException;
	
	/**
	* Test if the queue is logically empty.
	* @return true if empty, false otherwise.
	*/	
	public boolean isEmpty( );

}
