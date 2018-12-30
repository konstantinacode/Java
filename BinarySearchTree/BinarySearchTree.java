import java.util.Comparator;

public class BinarySearchTree{
    /**
     * Each node holds four references: left, right, parent and element.
     */
    static class Node {
        public Node left, parent, right;
        public Object element;
        
        protected Node(Object element) {
            if (element == null) throw new IllegalArgumentException();
            this.element = element;
        }
        
        protected void unlink() {
            element = null;
            parent = left = right = null;
        }
    }
    
    /**
     * The root of the tree.
     */
    protected Node root;
    /**
     * The number of nodes in the tree.
     */
    protected int size;
    /**
     * The comparison function.
     */
    protected Comparator cmp;
    /**
     * Default constructor.
     */
    public BinarySearchTree() {
        this(new DefaultComparator());
    }
    /**
     * Parametrized constructor that uses a given comparison function.
     * @param cmp The comparison function to use.
     */
    public BinarySearchTree(Comparator cmp) {
        this.size = 0;
        this.cmp = cmp;
    }
    /**
     * size of the tree
     */
    public int size() {
        return size;
    }
    /**
     * Finds the node a given element is stored at.
     * @param element The element to search for.
     * @return The node that hosts element, or null if element wasn’t found.
     */
    public Node find(Object element) {
        Node p = root;
        while (p != null) {
            // Compare element with the element in the current subtree
            int result = cmp.compare(element, p.element);
            if (result == 0) {
                break;
            }
            // Go left or right based on comparison result
            p = result < 0 ? p.left : p.right;
        }
        return p;
    }
        /*
         * Recursively finds the node a given element is stored at.
         */
    private Object findRecursive(Node p, Object element){
        if (p == null)
            return null;
        int result = cmp.compare(element, p.element);
        if (result == 0)
            return p.element;
        if (result<0)
            return findRecursive(p.left, element);
        else
            return findRecursive(p.right, element);
    }
    public Object findRecursive(Object element){
        return findRecursive(root, element);
    }
    
    /**
     * Inserts an element in the tree and returns the new node.
     * @param element The element to insert
     * @return The node that hosts element, or null if element wasn’t found.
     */
    public Node insert(Object element) {
        if (element == null) throw new IllegalArgumentException();
        Node n = root;
        Node p = null;
        int result = 0;
        while (n != null) {
            // Compare element with the element in the current subtree
            result = cmp.compare(element, n.element);
            if (result == 0) return null;
            // Go left or right based on comparison result
            // Keep a reference in the last non
            // node encountered
            p = n;
            n = result < 0 ? n.left : n.right;
        }
        // Create and connect a new node
        Node node = new Node(element);
        node.parent = p;
        // The new node must be a left child of p
        if (result < 0) {
            p.left = node;
        }
        // The new node must be a right child of p
        else if (result > 0) {
            p.right = node;
        }
        // The tree is empty; root must be set
        else {
            root = node;
        }
        ++size;
        return node;
    }
    /*
    * Recursively inserts an element in the tree and returns the new node.
    */
    private Node insertRecursive(Node p, Object element, Node parent){
        if (p == null){
            Node node = new Node(element);
            node.parent = parent;
            ++size;
            return node;
        }
        int result = cmp.compare(element, p.element);
        if (result == 0) return p;
        if (result<0)
            p.left = insertRecursive(p.left, element, p);
        else
            p.right = insertRecursive(p.right, element, p);
        return p;
    }
    public void insertRecursive(Object element){
        root = insertRecursive(root, element, null);
    }
    private String toStringR(Node h){
        if (h == null) return "";
        String s = toStringR(h.left);
        s += h.element.toString() + " ";
        s += toStringR(h.right);
        return s;
    }
    
    public String toString(){
        return toStringR(root);
    }    
    
    // Test program
    public static void main( String [ ] args ) {
        BinarySearchTree t = new BinarySearchTree( );
        
        t.insertRecursive(10);
        System.out.println(t.toString());
        t.insertRecursive(20);
        System.out.println(t.toString());
        t.insertRecursive(6);
        System.out.println(t.toString());
        t.insertRecursive(8);
        System.out.println(t.toString());
        t.insertRecursive(3);
        System.out.println(t.toString());
        t.insertRecursive(100);
        System.out.println(t.toString());
        t.insertRecursive(100);
        System.out.println(t.toString());
        t.insertRecursive(10);
        System.out.println(t.toString());                
        
        Node n = t.find(20);
        if(n!=null && n.element.equals(20)){
        	System.out.println("found 20!");
        }else{
        	System.out.println("did not find 20!");
        }
        
        n = t.find(25);
        if(n==null){
        	System.out.println("did not find 25!");
        }else{
        	System.out.println("found 25!");
        }

    }
}
