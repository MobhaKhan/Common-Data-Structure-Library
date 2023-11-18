package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

public class CSLL extends SLL {

    public CSLL() {
        super();
        if (head != null) {
            tail.setNext(head); // make the tail point to the head to form a circular list
        }
    }
    
    public CSLL(SNode node) {
        super(node);
        tail.setNext(head); // make the tail point to the head to form a circular list
    }
    

    @Override
    public void insertHead(SNode node) {
        super.insertHead(node);
        tail.setNext(head); // update the tail to point to the head to maintain the circular list
    }

    @Override
    public void insertTail(SNode node) {
        super.insertTail(node);
        tail.setNext(head); // update the tail to point to the head to maintain the circular list
    }

    @Override
    public void deleteHead() {
        super.deleteHead();
        tail.setNext(head); // update the tail to point to the head to maintain the circular list
    }

    @Override
    public void deleteTail() {
        super.deleteTail();
        tail.setNext(head); // update the tail to point to the head to maintain the circular list
    }

    @Override
    public void delete(SNode node) {
        super.delete(node);
        tail.setNext(head); // update the tail to point to the head to maintain the circular list
    }

    @Override
    public void sort() {
        if (head == null || head.getNext() == null) {
            return; // nothing to sort
        }

        SNode currentNode = head;
        do {
            SNode nextNode = currentNode.getNext();
            while (nextNode != head) {
                if (currentNode.getData() > nextNode.getData()) {
                    int temp = currentNode.getData();
                    currentNode.setData(nextNode.getData());
                    nextNode.setData(temp);
                }
                nextNode = nextNode.getNext();
            }
            currentNode = currentNode.getNext();
        } while (currentNode != head);
        sorted = true;
    }

    @Override
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

        // print circular list content
        SNode currNode = head;
        String contentStr = "";
        do {
            contentStr += currNode.getData() + " -> ";
            currNode = currNode.getNext();
        } while (currNode != head); // loop until we reach the head again
        System.out.println("List content: " + contentStr.substring(0, contentStr.length() - 4));
    }
}
