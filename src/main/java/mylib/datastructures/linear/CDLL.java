package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class CDLL extends DLL {

    public CDLL() {
        super();
    }

    public CDLL(DNode node) {
        super(node);
        node.setNext(node);
        node.setPrev(node);
    }

    @Override
    public void insertHead(DNode node) {
        if (head == null) {
            super.insertHead(node);
            node.setNext(node);
            node.setPrev(node);
        } else {
            super.insertHead(node);
            head.setPrev(tail);
            tail.setNext(head);
        }
    }

    @Override
    public void insertTail(DNode node) {
        if (tail == null) {
            super.insertTail(node);
            node.setNext(node);
            node.setPrev(node);
        } else {
            super.insertTail(node);
            tail.setNext(head);
            head.setPrev(tail);
        }
    }

    @Override
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
        }
    }

    @Override
    public void deleteHead() {
        if (head == null) {
            return;
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            head.getNext().setPrev(tail);
            tail.setNext(head.getNext());
            head = head.getNext();
        }
        size--;
    }

    @Override
    public void deleteTail() {
        if (tail == null) {
            return;
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail.getPrev().setNext(head);
            head.setPrev(tail.getPrev());
            tail = tail.getPrev();
        }
        size--;
    }

    @Override
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

    @Override
    public void sort() {
        DNode curr = head;
        DNode next = head.getNext();
        while (curr != tail) {
            while (next != tail.getNext()) {
                if (curr.getData() > next.getData()) {
                    int temp = curr.getData();
                    curr.setData(next.getData());
                    next.setData(temp);
                }
                next = next.getNext();
            }
            curr = curr.getNext();
            next = curr.getNext();
            sorted = true;
        }
    }
}
