package mylib.datastructures.linear;
import mylib.datastructures.nodes.SNode;

public class SLL {
    protected SNode head;
    protected SNode tail;
    protected int size;
    protected boolean sorted;

    public SLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.sorted = false;
    }

    public SLL(SNode node) {
        this.head = node;
        this.tail = node;
        this.size = 1;
        this.sorted = false;
    }
    
    public void insertHead(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public void insertTail(SNode node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public void insert(SNode node, int position) {
        if (position == 0) {
            insertHead(node);
        } else if (position >= size) {
            insertTail(node);
        } else {
            SNode currNode = head;
            for (int i = 0; i < position-1; i++) {
                currNode = currNode.getNext();
            }
            node.setNext(currNode.getNext());
            currNode.setNext(node);
            size++;
        }
    }

    public void sortedInsert(SNode node) {
        if (head == null || node.getData() < head.getData()) {
            node.setNext(head);
            head = node;
            size++;
        } else {
            SNode currNode = head;
            while (currNode.getNext() != null && currNode.getNext().getData() < node.getData()) {
                currNode = currNode.getNext();
            }
            node.setNext(currNode.getNext());
            currNode.setNext(node);
            size++;
        }
    }

    public SNode search(SNode node) {
        SNode currNode = head;
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
            SNode currNode = head;
            while (currNode.getNext() != tail) {
                currNode = currNode.getNext();
            }
            currNode.setNext(null);
            tail = currNode;
        }
        size--;
    }

    public void delete(SNode node) {
        if (head == null) {
            return;
        } else if (head == node) {
            deleteHead();
        } else if (tail == node) {
            deleteTail();
        } else {
            SNode currNode = head;
            while (currNode.getNext() != node) {
                currNode = currNode.getNext();
            }
            currNode.setNext(node.getNext());
            size--;
        }
    }

    public void sort() {
        if (head == null) {
            return;
        }

        SLL sortedList = new SLL();
        SNode currNode = head;

        while (currNode != null) {
            SNode nextNode = currNode.getNext();
            sortedList.sortedInsert(currNode);
            currNode = nextNode;
        }

        head = sortedList.head;
        tail = sortedList.tail;
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
    
        // print list content
        SNode currNode = head;
        String contentStr = "";
        do {
            contentStr += currNode.getData() + " -> ";
            currNode = currNode.getNext();
            if (currNode == null && this instanceof CSLL) {
                currNode = head;
            }
        } while (currNode != null && currNode != head); // loop until we reach the head again
        System.out.println("List content: " + contentStr.substring(0, contentStr.length() - 4));
    }
}

