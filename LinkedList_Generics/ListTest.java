
/**
 * 
 * Simple test for {@link List}
 *
 */

public class ListTest
{
	public static void main( String args[] )
	{
		List<Integer> list = new List<Integer>(); // create the List container

		// insert integers in list
		list.insertAtFront( Integer.valueOf(5) );
		list.print();
		list.insertAtFront( Integer.valueOf(4) );
		list.print();
		
		//java automatically casts int to Integer
		list.insertAtBack( 1 );		
		list.print();
		list.insertAtBack( 6 );
		list.print();
		list.insertAtBack(3 );
		list.print();

		// remove objects from list; print after each removal
		try
		{
			Integer removedObject = list.removeFromFront();
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

	} // end main
} // end class ListTest



