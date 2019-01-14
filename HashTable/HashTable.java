/**
 * Simple implementation of a HashTable. It uses a static map and Chaining for
 * resolving hash collisions
 * 
 */
public class HashTable {

	/**
	 * the hash table array
	 */
	private List[] array;
	
	/**
	 * keeps the number of items currently inserted
	 */
	private int size;

	public HashTable(int arraySize) {
		array = new List[arraySize];
		size = 0;
	}

	/**
	 * Adds an object to the hash table
	 * @param data the item to be inserted
	 * @return true if the item was inserted, false if the item was already present in the hash table
	 */
	public boolean add(Object data) {
		// hash data
		// compress address
		// check if list is initialized		
		// add data if not present in list
	}

	/**
	 * Removes an item from the hash table
	 * @param data the item to be removed
	 * @return true if the item was found and removed, false if the item was not found at all
	 */
	public boolean remove(Object data) {
		// hash data
		// compress address
		// check if data is in list
		//remove data from list
	}

	/**
	 * Checks if a item is present in the hash table
	 * @param data the searched item
	 * @return true in the item is found
	 */
	public boolean contains(Object data) {
		// hash data
		// compress address
		// check if data is in list
	}

	/**
	 * Get the number of items inserted into the hash table
	 * @return the number of inserted items  
	 */
	public int size() {
		return size;
	}
}
