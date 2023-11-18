package mylib.datastructures.linear;
import mylib.datastructures.nodes.SNode;

public class QueueLL extends SLL {
    //Constructors
    public QueueLL() {
        super();
    }

    public QueueLL(SNode node) {
        super(node);
    }

    // Override singlyLL methods that don't apply to queues
    @Override
    public void insertHead(SNode node) {} //Queues enqueue from tail

    @Override
    public void deleteTail() {} //Queues dequeue from head

    @Override
    public void delete(SNode node) {
        dequeue();
    }

    @Override
    public void insert(SNode node, int position) {} //inserting in arbitrary positions not allowed in queues

    @Override
    public void sortedInsert(SNode node) {}

    @Override
    public void sort() {} //Sorting not needed in a QueueLL

    @Override
    public SNode search(SNode node) { return null; }

    // enqueue: adds a new node to the end of the queue
    public void enqueue(SNode node) {
        super.insertTail(node);
    }

    // dequeue: removes and returns the first node in the queue
    public SNode dequeue() {
        SNode topNode = head;
        super.deleteHead();
        return topNode;
    }
}
