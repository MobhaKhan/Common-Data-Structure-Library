package mylib.datastructures.nodes;

public class DNode {
    private int data;
    private DNode next;
    private DNode prev;

    public DNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public int getData() { return this.data; }
    public DNode getNext() { return this.next; }
    public DNode getPrev() { return this.prev; }

    public void setData(int data) { this.data = data; }
    public void setNext(DNode next) { this.next = next; }
    public void setPrev(DNode prev) { this.prev = prev; }
}
