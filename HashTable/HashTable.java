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
		int hash = data.hashCode();

		// compress address
		int address = hash % array.length;

		List chain = array[address];
		
		// check if list is initialized		
		if (chain == null) {
			chain = new List();
			array[address] = chain;
		}

		// add data if not present in list
		if (!chain.contains(data)) {
			chain.insertAtFront(data);
			size++;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Removes an item from the hash table
	 * @param data the item to be removed
	 * @return true if the item was found and removed, false if the item was not found at all
	 */
	public boolean remove(Object data) {
		// hash data
		int hash = data.hashCode();

		// compress address
		int address = hash % array.length;

		List chain = array[address];
		// check if data is in list
		if (chain == null) {
			return false;
		}
		
		//remove data from list
		boolean removed = chain.remove(data); 
		if(removed){
			size--;
		}

		return removed;
	}

	/**
	 * Checks if a item is present in the hash table
	 * @param data the searched item
	 * @return true in the item is found
	 */
	public boolean contains(Object data) {
		// hash data
		int hash = data.hashCode();

		// compress address
		int address = hash % array.length;

		// check if data is in list
		List chain = array[address];
		if (chain == null) {
			return false;
		} else {
			return chain.contains(data);
		}
	}

	/**
	 * Get the number of items inserted into the hash table
	 * @return the number of inserted items  
	 */
	public int size() {
		return size;
	}
}
