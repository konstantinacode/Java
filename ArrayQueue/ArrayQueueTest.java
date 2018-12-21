

public class ArrayQueueTest 
{
   public static void main( String args[] )
   {
 
 	ArrayQueue arrayQueue = new ArrayQueue();
 	
 	Queue queue = arrayQueue; //arrayQueue instance is also a Queue
        
 	arrayQueue.enqueue(1);
 	arrayQueue.print();
 	
 	//I now call the queue by its interface
 	queue.enqueue(2);
 	
 	//I cannot say queue.print(), Queue interface doesn't have a print method
 	arrayQueue.print(); 
 	
 	queue.enqueue(3);
 	arrayQueue.print();
 	
 	arrayQueue.enqueue(4);
 	arrayQueue.print(); 
        
        //use dequeue method
        try {
            Object removedObject = null;
            while (true) {
                removedObject = arrayQueue.dequeue();
                System.out.printf("%s removed\n", removedObject);
                arrayQueue.print();            
            } //end while
        }
        catch (EmptyQueueException e) {
            e.printStackTrace();
        }
 
   } // end main
} // end class QueueTest


