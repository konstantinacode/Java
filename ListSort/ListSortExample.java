import java.util.Scanner;

public class ListSortExample{ 
    
    static class Node{ 
        int val; 
        Node next;
        
        Node(int v, Node t) { 
            val = v; next = t; 
        } 
    }

    static Node create(){ 
        Node head = new Node(0, null);
        Scanner input = new Scanner(System.in);
		//input example: 1 4 2 9 5 3 0 11 q
        while (input.hasNextInt()){
            Node node = new Node(input.nextInt(), null);
            node.next = head.next;
            head.next = node;
            //or head.next = new Node(input.nextInt(), head.next);
        }
		input.close();
        return head;
    }
    
    static Node sort(Node head){ 
        Node t, u, x, b = new Node(0, null);
        while (head.next != null){
            t = head.next; u = t.next; head.next = u;
            for (x = b; x.next != null; x = x.next)
              if (x.next.val > t.val) break;
            t.next = x.next; x.next = t;
        }
        return b;
    }
    
    static void print(Node h){ 
        for (Node t = h.next; t != null; t = t.next)
          System.out.print(t.val + " "); 
        System.out.println();
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
