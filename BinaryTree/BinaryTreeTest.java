/*
 * BinaryTreeTest.java
 */

public class BinaryTreeTest {
    
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        BinaryTree.Node a = BinaryTree.makeLeafNode("A");
        BinaryTree.Node b = BinaryTree.makeLeafNode("B");
        BinaryTree.Node c = BinaryTree.makeLeafNode("C");
        BinaryTree.Node d = BinaryTree.makeLeafNode("D");
        BinaryTree.Node e = BinaryTree.makeLeafNode("E");
        BinaryTree.Node f = BinaryTree.makeLeafNode("F");
        BinaryTree.Node g = BinaryTree.makeLeafNode("G");
        tree.setRootNode(a);
        tree.setLeftChild(a, b);
        BinaryTree.Node p = b.getParent();
        System.out.println(p);
        tree.setRightChild(a, c);
        tree.setLeftChild(b, f);
        tree.setRightChild(c, d);
        tree.setRightChild(d, e);
        tree.setRightChild(f, g);    

        System.out.print("Preorder traversal:");
        tree.preorder();
        System.out.println();
        System.out.print("Inorder traversal:");
        tree.inorder();
        System.out.println();        
        System.out.print("Postorder traversal:");        
        tree.postorder();
        System.out.println();  
        System.out.print("Breadth traversal:");        
        tree.breadth();       
        System.out.println();        
        System.out.print("Depth traversal:");        
        tree.depth();           
    }
    
}
