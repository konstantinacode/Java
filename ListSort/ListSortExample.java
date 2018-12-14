//import java.util.Scanner;

public class ListSortExample{ 
    	
    static class Node{ 
        int val; 
        Node next;
        
        Node(int v, Node t) { 
            val = v; next = t; 
        } 
    }

    static Node create(){ 
		Node head = null;
	
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()){
			int in = input.nextInt();
			if (head == null)
				head = new Node (in, null);
			else
				head = new Node (in, head);
		}
		
		in.close();
		
		return head;
    }
    
    static Node sort(Node head){ 
		

    }
    
    static void print(Node h){ 


    }
    
    public static void main(String[] args){ 
        Node head = create();
        System.out.print("Unsorted list: ");
        print(head);
        Node newhead=sort(head);
        System.out.print("Sorted list: ");
        print(newhead);
        //or print(sort(create())); 
    }
}
