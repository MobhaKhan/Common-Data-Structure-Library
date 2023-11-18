package mylib.datastructures.trees;
import mylib.datastructures.nodes.TNode;
import java.util.*;

public class BST {
    private TNode root; //references root of the tree

    public BST() { this.root = null; }

    public BST(TNode obj) { this.root = obj; }

    public BST(int val) {
        this.root = new TNode(val, 0, null, null, null);
    }

    //Setter and getter
    public void setRoot(TNode root) { this.root = root; }
    
    public TNode getRoot() { return this.root; } 
    
    //Insert 
    public void Insert(int val) {
        TNode newNode = new TNode(val, 0, null, null, null);
        Insert(newNode);
    }
    
    public void Insert(TNode node) {
        TNode parent = null;
        TNode current = root;
        while (current != null) {
            parent = current;
            if (node.getData() < current.getData()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        node.setParent(parent);
        if (parent == null) {
            root = node;
        } else if (node.getData() < parent.getData()) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }
    }

    //Delete
    public void Delete(int val) {
        root = deleteNode(root, val);
    }
    
    private TNode deleteNode(TNode root, int val) {
        // If the tree is empty
        if (root == null) {
            System.out.println("Value " + val + " not found in the tree");
            return null;
        }
    
        // Search for the node to be deleted
        if (val < root.getData()) {
            root.setLeft(deleteNode(root.getLeft(), val));
        } else if (val > root.getData()) {
            root.setRight(deleteNode(root.getRight(), val));
        } else { // Found the node to be deleted
            // Case 1: Node has no children
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
            }
            // Case 2: Node has one child
            else if (root.getLeft() == null) {
                root = root.getRight();
            } else if (root.getRight() == null) {
                root = root.getLeft();
            }
            // Case 3: Node has two children
            else {
                TNode temp = findMin(root.getRight());
                root.setData(temp.getData());
                root.setRight(deleteNode(root.getRight(), temp.getData()));
            }
        }
        return root;
    }
    
    private TNode findMin(TNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }    
    
    //Search 
    public TNode Search(int val) {
        TNode current = root;
        while (current != null) {
            if (current.getData() == val) {
                return current;
            } else if (current.getData() > val) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    //Print methods
    public void printInOrder() {
        printInOrderHelper(root);
    }
    
    private void printInOrderHelper(TNode node) {
        if (node != null) {
            printInOrderHelper(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrderHelper(node.getRight());
        }
    }    
     
    public void printBF() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<TNode> queue = new LinkedList<>(); 
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TNode current = queue.remove();
                System.out.print(current.getData() + " ");
                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
            System.out.println();
        }
    }  
}
