/*
 * ListTest.java
 *
 */
// ListTest class to demonstrate List capabilities.

public class ListTest 
{
   public static void main( String args[] )
   {
      List list = new List(); // create the List container

      // insert integers in list
      list.insertAtFront( 5 );
      list.print();
      list.insertAtFront( 4 );
      list.print();
      list.insertAtBack( 1 );
      list.print();
      list.insertAtBack( 6 );
      list.print();
      list.insertAtBack(3 );
      list.print();

      // remove objects from list; print after each removal
      try 
      { 
         Object removedObject = list.removeFromFront();
         System.out.printf( "%s removed\n", removedObject );
         list.print();

         removedObject = list.removeFromFront();
         System.out.printf( "%s removed\n", removedObject );
         list.print();

         removedObject = list.removeFromBack();
         System.out.printf( "%s removed\n", removedObject );
         list.print();

         removedObject = list.removeFromBack();
         System.out.printf( "%s removed\n", removedObject );
         list.print();

         removedObject = list.removeFromBack();
         System.out.printf( "%s removed\n", removedObject );
         list.print();         
      } // end try
      catch ( EmptyListException emptyListException ) 
      {
         emptyListException.printStackTrace();
      } // end catch

      list.insertAtFront( 5 );
      list.print();
      list.insertAtFront( 4 );
      list.print();
      list.insertAtBack( 1 );
      list.print();
      list.insertAtBack( 6 );
      list.print();
      list.insertAtBack(3 );
      list.print();
      list.sort();
      list.print();
      
   } // end main
} // end class ListTest



