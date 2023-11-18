package mylib.datastructures.linear;
import mylib.datastructures.nodes.DNode;


public class DLL {
    protected DNode head;
    protected DNode tail;
    protected int size;
    protected boolean sorted;

    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.sorted = false;
    }

    public DLL(DNode node) {
        this.head = node;
        this.tail = node;
        this.size = 1;
        this.sorted = false;
    }

    public DNode getHead() {
        return this.head;
    }

    public void insertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.setPrev(node);
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public void insertTail(DNode node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        size++;
    }

    public void insert(DNode node, int position) {
        if (position == 0) {
            insertHead(node);
        } else if (position >= size) {
            insertTail(node);
        } else {
            DNode currNode = head;
            for (int i = 0; i < position-1; i++) {
                currNode = currNode.getNext();
            }
            node.setNext(currNode.getNext());
            node.setPrev(currNode);
            currNode.getNext().setPrev(node);
            currNode.setNext(node);
            size++;
        }
        sorted = false;
    }

    public void SortedInsert(DNode node) {
        if (size == 0) {
            insertHead(node);
            return;
        }
        DNode current = head;
        while (current != null) {
            if (node.getData() <= current.getData()) {
                if (current.getPrev() == null) {
                    insertHead(node);
                } else {
                    node.setPrev(current.getPrev());
                    current.getPrev().setNext(node);
                    node.setNext(current);
                    current.setPrev(node);
                    size++;
                }
                return;
            }
            current = current.getNext();
        }
        insertTail(node);
        if (size > 1) {
            DNode prevNode = head;
            current = prevNode.getNext();
            boolean sorted = true;
            while (current != null) {
                if (prevNode.getData() > current.getData()) {
                    sorted = false;
                    break;
                }
                prevNode = current;
                current = current.getNext();
            }
            if (sorted) {
                this.sorted = true;
            }
        }
    }
    
    public DNode search(DNode node) {
        DNode currNode = head;
        while (currNode != null) {
            if (currNode.getData() == node.getData()) {
                return currNode;
            }
            currNode = currNode.getNext();
        }
        return null;
    }

    public void deleteHead() {
        if (head == null) {
            return;
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            head.getNext().setPrev(null);
            head = head.getNext();
        }
        size--;
    }

    public void deleteTail() {
        if (tail == null) {
            return;
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail.getPrev().setNext(null);
            tail = tail.getPrev();
        }
        size--;
    }

    public void delete(DNode node) {
        if (head == null) {
            return;
        } else if (head == node) {
            deleteHead();
        } else if (tail == node) {
            deleteTail();
        } else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            size--;
        }
    }

    public void sort() {
        if (size <= 1) {
            return;
        }
        
        boolean swapped;
        do {
            swapped = false;
            DNode current = head;
            while (current.getNext() != null) {
                if (current.getData() > current.getNext().getData()) {
                    DNode node1 = current;
                    DNode node2 = current.getNext();
                    
                    DNode node1Prev = node1.getPrev();
                    DNode node2Next = node2.getNext();
                    
                    if (node1Prev != null) {
                        node1Prev.setNext(node2);
                    } else {
                        head = node2;
                    }
                    node2.setPrev(node1Prev);
                    
                    node2.setNext(node1);
                    node1.setPrev(node2);
                    
                    node1.setNext(node2Next);
                    if (node2Next != null) {
                        node2Next.setPrev(node1);
                    }
                    
                    swapped = true;
                } else {
                    current = current.getNext();
                }
            }
        } while (swapped);

        DNode tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        this.tail = tail;
        sorted = true;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void print() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        // print list length
        System.out.println("The list length is " + size);
    
        // print sorted status
        if (sorted) {
            System.out.println("The list is sorted");
        } else {
            System.out.println("The list is not sorted");
        }
    
        System.out.print("List content: ");
        DNode current = head;
        int count = 0;
        while (current != null && count < size) {
            System.out.print(current.getData());
            if (current.getNext() != null && current != tail) {
                System.out.print(" -> ");
            }
            current = current.getNext();
            count++;
        }
        System.out.println();
        System.out.println();
    }    
}
