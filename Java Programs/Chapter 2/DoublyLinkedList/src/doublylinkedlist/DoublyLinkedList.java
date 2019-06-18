
package doublylinkedlist;

//Program to implement doubly linked list.
//Elements of any datatype could be inserted into the doubly linked list.

import java.io.*;
import java.util.*;

//Node operations
class Node {

    protected Object value;
    protected Node next_address;
    protected Node previous_address;

    public void getNode() {
        value = null;
        next_address = null;
        previous_address = null;
    }

    public Object getValue() {
        return value;
    }

    public Node getNext_address() {
        return next_address;
    }

    public Node getPrevious_address() {
        return previous_address;
    }

    public void setValue(Object item) {
        value = item;
    }

    public void setNext_address(Node next) {
        next_address = next;
    }

    public void setPrevious_address(Node previous) {
        previous_address = previous;
    }
}

class DoublyLinkedList_Operations {

    protected Node start;
    protected Node current;
    protected Node newNode;
    protected Node previous;
    protected Node temp;

    //creating doubly linked list
    public void create_LinkedList(Object item) {
        newNode = new Node();
        newNode.setValue(item);

        if (start == null) {
            start = newNode;

        } else {
            temp = start;
            while (temp.getNext_address() != null) {
                temp = temp.getNext_address();

            }
            newNode.setPrevious_address(temp);
            temp.setNext_address(newNode);
        }
    }

    //insertion in doubly linked list.
    public void insertion_DoublyLinkedList(Object item, Object data) {
        newNode = new Node();
        newNode.getNode();
        newNode.setValue(item);
        if (start == null) {
            start = newNode;
        } else {
            current = start;
            while (current.getNext_address() != null) {
                if (("" + current.getValue()).equals("" + data)) {
                    newNode.setNext_address(current.getNext_address());
                    newNode.setPrevious_address(current);
                    current.setNext_address(newNode);
                    break;
                } else {
                    current = current.getNext_address();
                }
            }
            current.setNext_address(newNode);
            newNode.setPrevious_address(current);
        }
    }

    //deletion in doubly linked list 
    public void deletion_DoublyLinkedList(Object data) {
        boolean flag=false;
        if (start == null) {
            System.out.println("No item to delete");
            return;
        }
        current = start;
        previous = start;
        while (current != null) {
            if (("" + current.getValue()).equals("" + data)) {
                flag=true;
                if (current == start) {
                    start = current.getNext_address();
                    if (start != null) {
                        start.setPrevious_address(null);
                    }
                    System.out.println("The item is deleted");
                    break;
                } else {
                    previous.setNext_address(current.getNext_address());
                    if (current.getNext_address() != null) {
                        current.getNext_address().setPrevious_address(previous);
                    }
                    System.out.println("The item is deleted");
                    break;
                }
            } else {
                previous = current;
                current = current.getNext_address();
            }
        }
        if(flag == false)
            System.out.println("Element is not found");

    }

    //Traversal in doubly linked list
    public void traversal_DoublyLinkedList() {
        current = start;
        System.out.print("Doubly Linked list: ");
        if (current == null) {
            System.out.print("Empty list..");
        }
        while (current != null) {
            System.out.print("" + current.getValue() + " | ");
            current = current.getNext_address();
        }
    }
}

public class DoublyLinkedList {

    public static void main(String args[]) {
        int choice, noitems, i;
        Object item, data;

        Scanner oin = new Scanner(System.in);
        DoublyLinkedList_Operations lst = new DoublyLinkedList_Operations();

        //Creating initial list of items in doubly linked list.
        System.out.print("Enter the number of items to be inserted in the link list: ");
        noitems = Integer.parseInt(oin.nextLine());

        System.out.println("Enter the items to be inserted in the link list:");
        for (i = 0; i < noitems; i++) {
            System.out.print("Item" + (i + 1) + ": ");
            item = (Object) oin.nextLine();
            lst.create_LinkedList(item);
        }

        while (true) {
            System.out.println("\n\nEnter the choice of operation:\n 1. Insert\n 2. Traverse\n 3. Delete \n 4. Exit");
            System.out.print("Option: ");
            choice = Integer.parseInt(oin.nextLine());

            if (choice == 1) {
                System.out.print("Enter an item to be inserted in the linked list: ");
                item = (Object) oin.nextLine();
                System.out.print("Enter an item after which the new item must be inserted: ");
                data = (Object) oin.nextLine();
                lst.insertion_DoublyLinkedList(item, data);
                lst.traversal_DoublyLinkedList();

            } else if (choice == 2) {
                lst.traversal_DoublyLinkedList();
            } else if (choice == 3) {
                System.out.println("enter an item to be deleted");
                item = (Object) oin.nextLine();
                lst.deletion_DoublyLinkedList(item);
                lst.traversal_DoublyLinkedList();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid Choice");
            }
        }
    }
}
