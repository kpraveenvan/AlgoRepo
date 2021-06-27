package com.praveen.ctci.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesLL <Item> {

    Node first;

    private void insertAtBegin(Item item) {
        Node node = new Node(item);
        node.next = first;
        first = node;
    }

    private void insertAtEnd(Item item) {
        Node node = new Node(item);
        if(first == null) {
            first = node;
            return;
        }

        Node temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    private void printLinkedList() {
        Node temp = first;
        while (temp != null) {
            if(temp.next == null)
                System.out.print( temp.item );
            else
                System.out.print( temp.item + " -> ");
            temp = temp.next;
        }
    }

    public void removeDuplicatesWithOutOtherStorage() {

        Node temp = first;

        while (temp.next != null) {
            Node tempNext = temp.next;
            temp.next = removeDuplicate(tempNext, temp.item);
            temp = temp.next;
        }
    }

    public Node removeDuplicate(Node start, Item value) {
        Node temp = start;
        while (temp.next != null) {
            Node tempNext = temp.next;
            if(tempNext.item == value) {
                temp.next = tempNext.next;
            } else {
                temp = temp.next;
            }
        }
        return start;
    }

    public void removeDuplicatesWithOtherStorage() {

        Set<Item> itemSet = new HashSet<>();
        if(first == null) {
            return;
        }
        Node temp = first;
        itemSet.add(temp.item);
        while (temp.next != null) {
            Node tempNext = temp.next;
            if(!itemSet.add(tempNext.item)) {
                //Duplicate
                temp.next = tempNext.next;
            } else {
                temp = temp.next;
            }
        }

    }

    private class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {

        RemoveDuplicatesLL<Integer> removeDuplicatesLL = new RemoveDuplicatesLL<>();
        removeDuplicatesLL.insertAtEnd(1);
        removeDuplicatesLL.insertAtEnd(2);
        removeDuplicatesLL.insertAtEnd(2);
        removeDuplicatesLL.insertAtEnd(3);
        removeDuplicatesLL.insertAtEnd(3);
        removeDuplicatesLL.insertAtEnd(4);
        removeDuplicatesLL.insertAtEnd(4);
        removeDuplicatesLL.insertAtEnd(5);
        System.out.println("Printing Original List");
        removeDuplicatesLL.printLinkedList();
        removeDuplicatesLL.removeDuplicatesWithOtherStorage();
        System.out.println("\nAfter Duplicate removal With Storage ");
        removeDuplicatesLL.printLinkedList();

        RemoveDuplicatesLL<Integer> removeDuplicatesLL2 = new RemoveDuplicatesLL<>();
        removeDuplicatesLL2.insertAtEnd(1);
        removeDuplicatesLL2.insertAtEnd(2);
        removeDuplicatesLL2.insertAtEnd(2);
        removeDuplicatesLL2.insertAtEnd(3);
        removeDuplicatesLL2.insertAtEnd(3);
        removeDuplicatesLL2.insertAtEnd(4);
        removeDuplicatesLL2.insertAtEnd(4);
        removeDuplicatesLL2.insertAtEnd(5);
        System.out.println("\nPrinting Original List");
        removeDuplicatesLL2.printLinkedList();
        removeDuplicatesLL2.removeDuplicatesWithOtherStorage();
        System.out.println("\nAfter Duplicate removal Without Storage ");
        removeDuplicatesLL2.printLinkedList();

     }


}
