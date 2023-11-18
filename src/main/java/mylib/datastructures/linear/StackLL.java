package mylib.datastructures.linear;
import mylib.datastructures.nodes.SNode;

public class StackLL extends SLL {

    // Constructors
    public StackLL() {
        super();
    }

    public StackLL(SNode node) {
        super(node);
    }

    // Override methods from SLL that are not applicable to StackLL
    @Override
    public void insertTail(SNode node) {} 

    @Override
    public void deleteHead() {}

    @Override
    public void deleteTail() {}

    @Override
    public void delete(SNode node) {
        pop();
    }

    @Override
    public void insert(SNode node, int position) {} //inserting in arbitrary positions not allowed in stacks

    @Override
    public void sortedInsert(SNode node) {}

    @Override
    public void sort() {} //Sorting not needed in a StackLL

    // Define function wrappers with proper naming conventions to invoke the functionality from the super class
    public void push(SNode node) {
        super.insertHead(node);
    }

    public SNode pop() {
        SNode topNode = head;
        super.deleteHead();
        return topNode;
    }    

    public SNode search() {
        if (head == null) {
            return null;
        }
        return head;
    }
}

