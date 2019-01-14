
public class HashTableTest {
	public static void main(String[] args) {
		HashTable hashtable = new HashTable(10);
		
		hashtable.add(1);
		hashtable.add(11);
		hashtable.add(21);
		hashtable.remove(11);
		
		System.out.println("size " + hashtable.size());
		System.out.println("contains 1: " +hashtable.contains(1));
		System.out.println("contains 11: " +hashtable.contains(11));
		System.out.println("contains 21: " +hashtable.contains(21));
		System.out.println("remove 11 " + hashtable.remove(11));
		System.out.println("add 21: " + hashtable.add(21));
	}
}
