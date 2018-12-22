/**
* Array-based implementation of the queue.
* @author Mark Allen Weiss
*/
public class ArrayQueue<T> implements Queue<T>
{

	/**
	 * the array to store items
	 */
	private T [] theArray;

	/**
	 * stores the number of items currently inserted
	 */
	private int currentSize;

	/**
	 * position of the queue head
	 */
	private int front;

	/**
	 * position of the queue rear
	 */
	private int back;

	private static final int DEFAULT_CAPACITY = 10;

	/**
	* Construct the queue.
	*/
	public ArrayQueue()
	{		
		theArray = (T []) new Object[DEFAULT_CAPACITY];
		currentSize = 0;
		front = 0;
		back = -1;
	}

	/**
	* Test if the queue is logically empty.
	* @return true if empty, false otherwise.
	*/
	public boolean isEmpty( )
	{
		return currentSize == 0;
	}

	/**
	* Return and remove the least recently inserted item
	* from the queue.
	* @return the least recently inserted item in the queue.
	* @throws EmtpyQueueException if the queue is empty.
	*/
	public T dequeue( ) throws EmtpyQueueException
	{
		if (isEmpty())
			throw new EmtpyQueueException("ArrayQueue dequeue error");
		T returnValue = theArray[front];
                front = increment(front);
		currentSize--;
                return returnValue;
	}

	/**
	* Insert a new item into the queue.
	* @param x the item to insert.
	*/
	public void enqueue( T x )
	{
		if (currentSize == theArray.length)
			doubleQueue();
		back = increment(back);
		theArray[back] = x;
		currentSize++;
        }

	/**
	* Internal method to increment with wraparound.
	* @param x any index in theArray's range.
	* @return x+1, or 0 if x is at the end of theArray.
	*/
	private int increment( int x )
	{
		if( ++x == theArray.length )
			x = 0;
		return x;
	}

	/**
	* Internal method to expand theArray.
	*/
	private void doubleQueue( )
	{
		T[]  newArray;
		newArray = (T[]) new Object[theArray.length*2];
		// copy elements that are logically in the Queue
		for (int i=0; i<currentSize; i++, front = increment(front))
			newArray[i] = theArray[front];
		theArray = newArray;
		front = 0;
		back = currentSize-1;
	}

	public void print() {
		if (isEmpty()) {
			System.out.printf("Empty queue\n");
			return;
		} // end if

		System.out.printf("The queue is: ");
		for (int i = front; i != back; i = increment(i)) {
			System.out.print(theArray[i] + " ");
		}
		System.out.print(theArray[back] + "\n");
	}
	
}

