/*
 * BinaryTree.java
 * Based on an implementation by M. Sintihakis
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    
    public static class Node {
        
        protected static final Node EXTERNAL = new Node();
        
        protected Object element;
        protected Node left, right, parent;
        
        private Node() {
            super();
        }
        
        protected Node(Object element) {
            this(element, EXTERNAL, EXTERNAL, EXTERNAL);
        }
        
        protected Node(Object element, Node parent, Node left, Node right) {
            super();
            if (parent == null || left == null || right == null) {
                throw new IllegalArgumentException();
            }
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
        
        public Object getElement() {
            illegalOnExternalNode();
            return element;
        }
        
        public void setElement(Object element) {
            illegalOnExternalNode();
            this.element = element;
        }
        
        public Node getParent() {
            illegalOnExternalNode();
            return parent;
        }
        
        public Node getLeftChild() {
            illegalOnExternalNode();
            return left;
        }
        
        public Node getRightChild() {
            illegalOnExternalNode();
            return right;
        }
        
        public boolean isExternal() {
            return this == EXTERNAL;
        }
        
        public boolean isInternal() {
            return this != EXTERNAL;
        }
        
        public boolean isLeaf() {
            return this.left.isExternal() && this.right.isExternal();
        }
        
        private void illegalOnExternalNode() {
            if (this == EXTERNAL) {
                throw new IllegalStateException();
            }
        }
        
        public void visit() {
            System.out.print(element+" ");
        }
        
    }
    
    protected Node root;
    
    public BinaryTree() {
        super();
        root = Node.EXTERNAL;
    }
    
    public BinaryTree(Node node) {
        super();
        root = node;
        root.parent = Node.EXTERNAL;
    }
    
    public static Node makeLeafNode(Object element) {
        return new Node(element);
    }
    
    public Node setRootNode(Node root) {
        if (this.root != Node.EXTERNAL) {
            throw new IllegalStateException();
        }
        checkNode(root);
        return this.root = root;
    }
    
    public Node getRoot() {
        return root;
    }
    
    public void setElement(Node node, Object element) {
        checkNode(node);
        checkElement(element);
        node.element = element;
    }
    
    public void setLeftChild(Node parent, Node child) {
        if (parent.left != Node.EXTERNAL) {
            throw new IllegalStateException();
        }
        child.parent = parent;
        parent.left = child;
    }
    
    public void setRightChild(Node parent, Node child) {
        if (parent.right != Node.EXTERNAL) {
            throw new IllegalStateException();
        }
        child.parent = parent;
        parent.right = child;
    }
    
    public BinaryTree getLeftSubtree(Node node) {
        checkNode(node);
        return new BinaryTree(node.left);
    }
    
    public BinaryTree getLeftSubtree() {
        return new BinaryTree(root.left);
    }
    
    public BinaryTree getRightSubtree(Node node) {
        checkNode(node);
        return new BinaryTree(node.right);
    }
    
    public BinaryTree getRightSubtree() {
        return new BinaryTree(root.right);
    }
    
    public Node getSibling(Node node) {
        checkNode(node);
        return node == node.parent.left	? node.parent.right : node.parent.left;
    }
    
    public boolean isRoot(Node node) {
        return root == node;
    }
    
    public int level(Node node) {
        return isRoot(node) ? 0 : 1 + level(node.parent);
    }
    
    public int height() {
        return height(root);
    }
    
    private int height(Node node) {
        return node.isLeaf()? 1	: 1 + Math.max(height(node.left), height(node.right));
    }
    
    private void checkNode(Node node) {
        if (node == null) {
            throw new IllegalArgumentException();
        }
    }
    
    private void checkElement(Object element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
    }
    
    public void preorder() {
        preorder(root);
    }
    public void preorder(Node node) {
        if (node == Node.EXTERNAL)
            return;
        node.visit();
        preorder(node.left);
        preorder(node.right);
    }
    
    public void inorder() {
        inorder(root);
    }
    public void inorder(Node node) {
        if (node.isExternal())
            return;
        inorder(node.left);
        node.visit();
        inorder(node.right);
    }
    
    public void postorder() {
        postorder(root);
    }
    public void postorder(Node node) {
        if (node.isExternal())
            return;
        postorder(node.left);
        postorder(node.right);
        node.visit();
    }
    
    public void breadth() {
        Queue q = new LinkedList();
        if (!root.isExternal()) q.offer(root);
        while (!q.isEmpty()) {
            Node node = (Node)q.remove();
            node.visit();
            if (!node.left.isExternal()) q.offer(node.left);
            if (!node.right.isExternal()) q.offer(node.right);
        }
    }
    public void depth() {
        Stack s = new Stack();
        if (!root.isExternal()) s.push(root);
        while (!s.isEmpty()) {
            Node node = (Node)s.pop();
            node.visit();
            if (!node.right.isExternal()) s.push(node.right);
            if (!node.left.isExternal()) s.push(node.left);
        }
    }
}