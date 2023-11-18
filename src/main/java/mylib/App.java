package mylib;

import mylib.datastructures.linear.*;
import mylib.datastructures.nodes.*;
import mylib.datastructures.trees.*;

public class App {
    public static void main(String[] args) {
        int[] values = {7, 3, 10, 2, 5, 8, 12, 1, 4, 6, 9, 11, 13};
        int[] deleteValues = {1, 13, 7};
        int[] searchValues = {8, 11, 15};

        System.out.println("\nTesting SLL...");
        SLL sll = new SLL();
        sll.insertTail(new SNode(values[2]));
        sll.insertTail(new SNode(values[5]));
        sll.insertTail(new SNode(values[4]));
        sll.insertTail(new SNode(values[1]));

        System.out.print("Original SLL: ");
        sll.print();
        sll.sort();
        System.out.print("\nInsertion SLL: ");
        sll.insert(new SNode(10), 1);
        sll.print();
        System.out.print("\nSorted SLL: ");
        sll.print();
        SNode sllNode = sll.search(new SNode(8));
        System.out.println("\nNode found: " + sllNode.getData());
        sll.delete(sllNode);
        System.out.print("Updated SLL after Deleting Node " + sllNode.getData() + "\n");
        sll.print();
        sll.clear();
        System.out.print("\nCleared SLL: ");
        sll.print();

        System.out.println("\n\nTesting DLL...");
        // Create a new doubly linked list
        DLL DLLlist = new DLL();
        // Insert some nodes
        DLLlist.insertTail(new DNode(values[2]));
        DLLlist.insertTail(new DNode(values[5]));
        DLLlist.insertTail(new DNode(values[4]));
        DLLlist.insertTail(new DNode(values[1]));
    
        // Print the list
        DLLlist.print();
        // Sort the list
        DLLlist.sort();
        // Print the sorted list
        DLLlist.print();
        // Search for a node
        DNode node = DLLlist.search(new DNode(8));
        System.out.println("Node found: " + node.getData());
        // Delete a node
        DLLlist.delete(node);
        // Print the updated list
        DLLlist.print();
        // Clear the list
        DLLlist.clear();
        // Print the cleared list
        DLLlist.print();

        System.out.println("\n\nTesting CSLL...");
        CSLL csll = new CSLL();
        csll.insertTail(new SNode(values[2]));
        csll.insertTail(new SNode(values[5]));
        csll.insertTail(new SNode(values[4]));
        csll.insertTail(new SNode(values[1]));

        System.out.print("Original CSLL: ");
        csll.print();
        csll.sort();
        csll.insert(new SNode(10), 1);
        System.out.print("\nSorted CSLL: ");
        csll.sort();
        csll.print();
        SNode csllNode = csll.search(new SNode(8));
        System.out.println("\nNode found: " + csllNode.getData());
        csll.delete(csllNode);
        System.out.print("Updated CSLL: ");
        csll.print();
        csll.clear();
        System.out.print("\nCleared CSLL: ");
        csll.print();
        
        System.out.println("\n\nTesting CDLL...");
        CDLL cdll = new CDLL();
        cdll.insertTail(new DNode(values[2]));
        cdll.insertTail(new DNode(values[5]));
        cdll.insertTail(new DNode(values[4]));
        cdll.insertTail(new DNode(values[1]));

        System.out.print("Original CDLL: ");
        cdll.print();
        cdll.sort();
        cdll.insert(new DNode(10), 1);
        System.out.print("Sorted CDLL: ");
        cdll.sort();
        cdll.print();
        System.out.print("Deleting tail of CDLL: ");
        cdll.deleteTail();
        cdll.print();
        System.out.print("Deleting head of CDLL: ");
        cdll.deleteHead();
        cdll.print();
        cdll.clear();
        System.out.print("Cleared CDLL: ");
        cdll.print();

        // Create a queue and add nodes to it
        QueueLL queue = new QueueLL();
        System.out.println("\n\nTesting QueueLL...");
        queue.enqueue(new SNode(values[0]));
        queue.enqueue(new SNode(values[3]));
        queue.enqueue(new SNode(values[2]));

        // Print the contents of the queue
        System.out.println("\nQueue contents:");
        queue.print();

        // Dequeue a node and print it
        System.out.println("\nDequeuing a node...");
        SNode dequeuedNode = queue.dequeue();
        System.out.println("Dequeued node: " + dequeuedNode.getData());

        // Print the updated contents of the queue
        System.out.println("\nUpdated queue contents:");
        queue.print();

        // Clear the queue and print its contents
        System.out.println("\nClearing the queue...");
        queue.clear();
        System.out.println("Queue contents after clearing:");
        queue.print();

        // Create a stack and add nodes to it
        StackLL stack = new StackLL();
        System.out.println("\n\nTesting StackLL...");
        stack.push(new SNode(values[5]));
        stack.push(new SNode(values[7]));
        stack.push(new SNode(values[6]));

        // Print the contents of the stack
        System.out.println("\nStack contents:");
        stack.print();

        // Pop some nodes off the stack and print them
        System.out.println("\nPopping nodes off the stack...");
        SNode poppedNode1 = stack.pop();
        SNode poppedNode2 = stack.pop();
        System.out.println("Popped nodes: " + poppedNode1.getData() + ", " + poppedNode2.getData());

        // Print the updated contents of the stack
        System.out.println("\nUpdated stack contents:");
        stack.print();

        // Clear the stack and print its contents
        System.out.println("\nClearing the stack...");
        stack.clear();
        System.out.println("Stack contents after clearing:");
        stack.print();

        // Testing AVL
        System.out.println("\n\nTesting AVL...");
        AVL avl = new AVL();

        // Inserting values
        System.out.println("\nInserting values into AVL:");
        for (int val : values) {
            avl.Insert(val);
        }
        System.out.println("Resulting tree:");
        avl.printBF();
        System.out.println();

        // Deleting values
        System.out.println("Deleting values from AVL:");
        for (int val : deleteValues) {
            avl.Delete(val);
            System.out.println("Deleting " + val);
        }
        System.out.println("Resulting tree:");
        avl.printBF();
        System.out.println();

        // Searching for values
        System.out.println("Searching for values in AVL:");
        for (int val : searchValues) {
            TNode avlNode = avl.Search(val);
            if (avlNode != null) {
                System.out.println("Found " + val + " in the tree");
            } else {
                System.out.println("Value " + val + " not found in the tree");
            }
        }

        // Testing BST
        System.out.println("\n\nTesting BST...");
        BST bst = new BST();

        // Inserting values
        System.out.println("\nInserting values into BST:");
        for (int val : values) {
            bst.Insert(val);
        }
        System.out.println("Resulting tree:");
        bst.printBF();
        System.out.println();

        // Deleting values
        System.out.println("Deleting values from BST:");
        for (int val : deleteValues) {
            bst.Delete(val);
            System.out.println("Deleting " + val);
        }
        System.out.println("Resulting tree:");
        bst.printBF();
        System.out.println();

        // Searching for values
        System.out.println("Searching for values in BST:");
        for (int val : searchValues) {
            TNode bstNode = bst.Search(val);
            if (bstNode != null) {
                System.out.println("Found " + val + " in the tree");
            } else {
                System.out.println("Value " + val + " not found in the tree");
            }
        }
    }
}
