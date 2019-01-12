import java.util.Comparator;

public class BinarySearchTree<T>{
    /**
     * Each node holds four references: left, right, parent and element.
     */
    static class Node<T> {
        public Node<T> left, parent, right;
        public T element;
        
        protected Node(T element) {
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
    protected Node<T> root;
    /**
     * The number of nodes in the tree.
     */
    protected int size;
    /**
     * The comparison function.
     */
    protected Comparator<T> cmp;
   
    /**
     * Parametrized constructor that uses a given comparison function.
     * @param cmp The comparison function to use.
     */
    public BinarySearchTree(Comparator<T> cmp) {
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
     * Finds the Node<T> a given element is stored at.
     * @param element The element to search for.
     * @return The Node<T> that hosts element, or null if element wasn�t found.
     */
    public Node<T> find(T element) {
        Node<T> p = root;
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
    private T findRecursive(Node<T> p, T element){
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
    public T findRecursive(T element){
        return findRecursive(root, element);
    }
    
    /**
     * Inserts an element in the tree and returns the new node.
     * @param element The element to insert
     * @return The node that hosts element, or null if element wasn�t found.
     */
    public Node<T> insert(T element) {
        if (element == null) throw new IllegalArgumentException();
        Node<T> n = root;
        Node<T> p = null;
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
        Node<T> node = new Node<T>(element);
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
    private Node<T> insertRecursive(Node<T> p, T element, Node<T> parent){
        if (p == null){
            Node<T> node = new Node<T>(element);
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
    public void insertRecursive(T element){
        root = insertRecursive(root, element, null);
    }
    /*
    * Recursively adds an element in the root of tree by doing rotations.
    */    
    private Node<T> rootInsert(Node<T> p, T element, Node<T> parent){
        if (p == null){
            Node<T> node = new Node<T>(element);
            node.parent = parent;
            ++size;
            return node;
        }
        int result = cmp.compare(element, p.element);
        if (result == 0) return p;        
        if (result<0){
            p.left = rootInsert(p.left, element, p);
            p = rotateRight(p);
        } else {
            p.right = rootInsert(p.right, element, p);
            p = rotateLeft(p);
        }
        return p;
    }
    
    public void rootInsert(T element){
        root = rootInsert(root, element, null);
    }
    
    /**
     * Performs a left rotation.
     * @param pivot The node to rotate.
     */
    private Node<T> rotateLeft(Node<T> pivot) {
        Node<T> parent = pivot.parent;
        Node<T> child = pivot.right;
        if (parent == null) {
            root = child;
        } else if (parent.left == pivot) {
            parent.left = child;
        } else {
            parent.right = child;
        }
        child.parent = pivot.parent;
        pivot.parent = child;
        pivot.right = child.left;
        if (child.left != null) child.left.parent = pivot;
        child.left = pivot;
        return child;
    }
    /**
     * Performs a right rotation.
     * @param pivot The node to rotate.
     */
    private Node<T> rotateRight(Node<T> pivot) {
        Node<T> parent = pivot.parent;
        Node<T> child = pivot.left;
        if (parent == null) {
            root = child;
        } else if (parent.left == pivot) {
            parent.left = child;
        } else {
            parent.right = child;
        }
        child.parent = pivot.parent;
        pivot.parent = child;
        pivot.left = child.right;
        if (child.right != null) child.right.parent = pivot;
        child.right = pivot;
        return child;
    }
    /**
     * remove a node from the tree
     */
    public boolean remove(T element) {
        Node<T> n = find(element);
        if (n == null) return false;
        remove(n);
        return true;
    }
    /**
     * Removes a given node from the tree.
     * @throws NullPointerException if p is null.
     * @param p The node to remove.
     */
    private void remove(Node<T> p) {
        // If p has two children find its successor, then remove it
        if (p.left != null && p.right != null) {
            Node<T> succ = succ(p);
            p.element = succ.element;
            p = succ;
        }
        Node<T> parent = p.parent;
        Node<T> child = p.left != null ? p.left : p.right;
        // The root is being removed
        if (parent == null) {
            root = child;
        }
        // Bypass p
        else if (p == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
        if (child != null) {
            child.parent = parent;
        }
        // Dispose p
        p.unlink();
        --size;
    }
    
    /**
     * Finds the inorder successor of a ginen node.
     * @param q The node whose successor to find
     * @throws NullPointerException if q is null
     * @return The successor of q, or null if q is the last node
     */
    private Node<T> succ(Node<T> q) {
        // The successor is the leftmost leaf of q�s right subtree
        if (q.right != null) {
            Node<T> p = q.right;
            while (p.left != null) p = p.left;
            return p;
        }
        // The successor is the nearest ancestor on the right
        else {
            Node<T> p = q.parent;
            Node<T> ch = q;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }
    /**
     * Finds the inorder predecessor of a ginen node.
     * @param q The node whose predecessor to find
     * @return The predecessor of q, or null if q is the first node
     */
    private Node<T> pred(Node<T> q) {
        // The successor is the rightmost leaf of q�s left subtree
        if (q.left != null) {
            Node<T> p = q.left;
            while (p.right != null) p = p.right;
            return p;
        }
        // The successor is the nearest ancestor on the right
        else {
            Node<T> p = q.parent;
            Node<T> ch = q;
            while (p != null && ch == p.left) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    private String toStringR(Node<T> h){
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
    	IntegerComparator intCmp = new IntegerComparator();
        BinarySearchTree<Integer> t = new BinarySearchTree<Integer>(intCmp);
        
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
        
        System.out.println("size="+t.size);
        t.remove(10);
        System.out.println(t.toString());
        t.remove(20);
        System.out.println(t.toString());
        t.remove(8);
        System.out.println(t.toString());
        t.remove(100);
        System.out.println(t.toString());
        t.remove(3);
        System.out.println(t.toString());
        t.remove(6);
        System.out.println(t.toString());
        
        System.out.println( "Checking... (no more output means success)" );
        if( t.find(20) != null )
            System.out.println( "Find error1!" );
        if( t.findRecursive(3) != null )
            System.out.println( "Find error2!" );
        
        t.insert(10);
        System.out.println(t.toString());
        t.insert(20);
        System.out.println(t.toString());
        t.insert(8);
        System.out.println(t.toString());
        t.insert(100);
        System.out.println(t.toString());
        System.out.println("size="+t.size);
        
        t.remove(10);
        System.out.println(t.toString());
        t.remove(20);
        System.out.println(t.toString());
        t.remove(8);
        System.out.println(t.toString());
        t.remove(100);
        System.out.println(t.toString());
        
        System.out.println( "Checking... (no more output means success)" );
        if( t.find(20) != null )
            System.out.println( "Find error1!" );
        if( t.findRecursive(3) == null )
            System.out.println( "Find error2!" );
        
        t.rootInsert(10);
        System.out.println(t.toString());
        t.rootInsert(20);
        System.out.println(t.toString());
        t.rootInsert(6);
        System.out.println(t.toString());
        t.rootInsert(8);
        System.out.println(t.toString());
        t.rootInsert(3);
        System.out.println(t.toString());
        t.rootInsert(100);
        System.out.println(t.toString());
        System.out.println("size="+t.size);
        
        t.remove(10);
        System.out.println(t.toString());
        t.remove(20);
        System.out.println(t.toString());
        t.remove(8);
        System.out.println(t.toString());
        t.remove(100);
        System.out.println(t.toString());
        
        System.out.println( "Checking... (no more output means success)" );
        if( t.find(20) != null )
            System.out.println( "Find error1!" );
        if( t.findRecursive(3) == null )
            System.out.println( "Find error2!" );
    }
}
