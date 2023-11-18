package mylib.datastructures.trees;
import mylib.datastructures.nodes.TNode;

public class AVL extends BST {

    private TNode root;

    // Default constructor initializing root to null
    public AVL() {
        this.root = null;
    }

    // Overload constructor AVL(int val) which takes in an integer value, and creates a TNode and use it as root
    public AVL(int val) {
        this.root = new TNode(val, 0, null, null, null);
    }

    // Overload constructor AVL(TNode obj) which takes a TNode as an argument and use it as the root of the tree. If the TNode obj has children, the constructor needs to create a balanced tree from passed tree by iteratively inserting nodes from the original tree and balancing the new created AVL tree.
    public AVL(TNode obj) {
        this.root = obj;

        if (obj.getLeft() != null) {
            insertSubtree(obj.getLeft());
        }

        if (obj.getRight() != null) {
            insertSubtree(obj.getRight());
        }

        balanceTree();
    }

    private void insertSubtree(TNode node) {
        Insert(node.getData());

        if (node.getLeft() != null) {
            insertSubtree(node.getLeft());
        }

        if (node.getRight() != null) {
            insertSubtree(node.getRight());
        }
    }

    //
    //
    //Gave a bunch of helper functions to balance, I couldnt find anything simpler
    private void balanceTree() {
        if (root == null) {
            return;
        }
    
        int balanceFactor = getBalanceFactor(root);
    
        if (balanceFactor > 1) {
            if (getBalanceFactor(root.getLeft()) < 0) {
                root.setLeft(rotateLeft(root.getLeft()));
            }
            root = rotateRight(root);
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(root.getRight()) > 0) {
                root.setRight(rotateRight(root.getRight()));
            }
            root = rotateLeft(root);
        }
    
        if (root.getLeft() != null) {
            AVL leftTree = new AVL(root.getLeft());
            leftTree.balanceTree();
            root.setLeft(leftTree.getRoot());
        }
    
        if (root.getRight() != null) {
            AVL rightTree = new AVL(root.getRight());
            rightTree.balanceTree();
            root.setRight(rightTree.getRoot());
        }
    }
    
    private int getBalanceFactor(TNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }
    
    private int getHeight(TNode node) {
        if (node == null) {
            return -1;
        }
        return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
    }
    
    private TNode rotateLeft(TNode node) {
        TNode newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        return newRoot;
    }
    
    private TNode rotateRight(TNode node) {
        TNode newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        return newRoot;
    }    

    //Setter and getter for root
    public TNode getRoot() {
        return root;
    }

    public void setRoot(TNode node) {
        // If the new node is null, set root to null
        if (node == null) {
            root = null;
        }
        // If the new node is not null, check if it has children and create a new AVL tree if necessary
        else {
            root = node;
            if (node.getLeft() != null || node.getRight() != null) {
                AVL newTree = new AVL(node);
                root = newTree.getRoot();
            }
        }
    }

    //Insert methods
    @Override
    public void Insert(int val) {
        super.Insert(val); // call insert method of BST
        balanceTree();
    }

    @Override
    public void Insert(TNode node) { //Override this same method in BST
        super.Insert(node); // call insert method of BST

        balanceTree(); // balance the tree after insertion
    }

    public void Delete(int val) {
        // Find the node to be deleted
        TNode node = Search(val);
        if (node == null) {
            System.out.println("Value " + val + " is not in the tree.");
            return;
        }
        
        // Delete the node
        Delete(node);
    }
    
    private void Delete(TNode node) {
        TNode replacement = null;
    
        if (node.getLeft() == null && node.getRight() == null) {
            // Case 1: Node is a leaf node
            replacement = null;
        } else if (node.getLeft() == null || node.getRight() == null) {
            // Case 2: Node has one child
            replacement = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        } else {
            // Case 3: Node has two children
            // Find the maximum value in the left subtree
            TNode maxNode = node.getLeft();
            while (maxNode.getRight() != null) {
                maxNode = maxNode.getRight();
            }
            // Replace the node to be deleted with the maximum value in the left subtree
            node.setData(maxNode.getData());
            // Delete the replacement node
            Delete(maxNode);
            return;
        }
    
        // Update the parent of the replacement node
        if (replacement != null) {
            replacement.setParent(node.getParent());
        }
    
        // Update the parent of the node to be deleted
        if (node.getParent() == null) {
            root = replacement;
        } else if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(replacement);
        } else {
            node.getParent().setRight(replacement);
        }
    
        // Re-balance the tree
        balanceTree();
    }
}

