package mylib.datastructures.nodes;

public class TNode {
    private int data;
    private TNode left;
    private TNode right;
    private TNode parent;
    private int balance;
    
    // Default constructor
    public TNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }
    
    // Overload constructor
    public TNode(int data, int balance, TNode P, TNode L, TNode R) {
        this.data = data;
        this.left = L;
        this.right = R;
        this.parent = P;
        this.balance = balance;
    }
    
    // Getters
    public int getData() {
        return data;
    }
    
    public TNode getLeft() {
        return left;
    }
    
    public TNode getRight() {
        return right;
    }
    
    public TNode getParent() {
        return parent;
    }
    
    public int getBalance() {
        return balance;
    }
    
    // Setters
    public void setData(int data) {
        this.data = data;
    }
    
    public void setLeft(TNode left) {
        this.left = left;
    }
    
    public void setRight(TNode right) {
        this.right = right;
    }
    
    public void setParent(TNode parent) {
        this.parent = parent;
    }
    
    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    // Print method
    public void print() {
        String parentData = parent != null ? String.valueOf(parent.getData()) : "null";
        String leftData = left != null ? String.valueOf(left.getData()) : "null";
        String rightData = right != null ? String.valueOf(right.getData()) : "null";
        System.out.println("Data: " + data + ", Balance: " + balance 
                        + ", Parent: " + parentData + ", Left: " + leftData + ", Right: " + rightData);
    }
    
    // ToString method
    public String toString() {
        return String.valueOf(this.data);
    }
}

