package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class DoublyLinkedList<Item> implements Iterable<Item>{

    Node first;
    Node last;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Item item) { //Insert at end

        Node nodeToBeAdded = new Node(item);
        if(size == 0) {
            first = last = nodeToBeAdded;
            size++;
            return;
        }
        last.next = nodeToBeAdded;
        nodeToBeAdded.previous = last;
        last = nodeToBeAdded;
        size++;
    }

    public Item dequeue() { //Remove from beginning

        if(isEmpty()) {
            throw new UnsupportedOperationException();
        }
        Node temp = first;
        first = first.next;
        if(first != null) {
            first.previous = null;
        }
        size--;
        return temp.item;
    }

    public Item removeFromEnd() { //Remove from End

        if(isEmpty()) {
            throw new UnsupportedOperationException();
        }
        Node temp = last;
        Node tempPrevious = last.previous;
        last.previous = null;
        if(tempPrevious != null) {
            tempPrevious.next = null;
        }
        size--;
        return temp.item;
    }

    public void insertAtBeginning(Item item) {

        Node nodeTobeInserted = new Node(item);
        if(size == 0) {
            first = last = nodeTobeInserted;
            size++;
            return;
        }
        nodeTobeInserted.next = first;
        first.previous = nodeTobeInserted;
        nodeTobeInserted = first;
        size++;
    }

    public void insertAfterGivenNode(Item itemToBeInserted, Item itemInQueue) {

        if(isEmpty()) {
            throw new UnsupportedOperationException();
        }
        Node temp = first;
        while (temp != null && temp.item != itemInQueue) {
            temp = temp.next;
        }
        if(temp == null) {
            throw new UnsupportedOperationException("Item Not in the List!!");
            //Item Not in the queue!!
        }
        Node nodeToBeInserted = new Node(itemToBeInserted);
        nodeToBeInserted.previous = temp;
        nodeToBeInserted.next = temp.next;
        temp.next = nodeToBeInserted;
        if(nodeToBeInserted.next != null) {
            nodeToBeInserted.next.previous = nodeToBeInserted;
        }
        size++;
    }

    public void removeANode(Item itemToRemove) {
        if(isEmpty()) {
            throw new UnsupportedOperationException();
        }
        Node temp = first;
        while (temp != null && temp.item != itemToRemove) {
            temp = temp.next;
        }
        if(temp == null) {
            throw new UnsupportedOperationException();
        }
        if(temp.previous != null)
            temp.previous.next = temp.next;
        if(temp.next != null)
            temp.next.previous = temp.previous;
        temp.previous = null;
        temp.next = null;
        size--;
    }


    @Override
    public Iterator<Item> iterator() {
        return new DLLIterator();
    }

    private class Node {
        Item item;
        Node next;
        Node previous;

        public Node(Item item) {
            this.item = item;
        }
    }

    private class DLLIterator implements Iterator<Item>{

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Node temp = current;
            current = current.next;
            return temp.item;
        }

        @Override
        public void remove() {
            //NoOp
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();
//        doublyLinkedList.enqueue("Hello");
//        doublyLinkedList.enqueue("There");
//        doublyLinkedList.enqueue("Praveen");
//        doublyLinkedList.enqueue("Here");
//        for(String element : doublyLinkedList) {
//            System.out.println(element);
//        }
//        System.out.println(doublyLinkedList.dequeue());
//        System.out.println(doublyLinkedList.dequeue());
//        System.out.println(doublyLinkedList.dequeue());
//        System.out.println(doublyLinkedList.dequeue());
        doublyLinkedList.enqueue("Hello");
        doublyLinkedList.enqueue("There");
        doublyLinkedList.enqueue("Praveen");
        doublyLinkedList.enqueue("Here");
        doublyLinkedList.insertAfterGivenNode("Kumar", "Praveen");
        doublyLinkedList.removeANode("There");
        System.out.println(doublyLinkedList.dequeue());
        System.out.println(doublyLinkedList.dequeue());
        System.out.println(doublyLinkedList.dequeue());
        System.out.println(doublyLinkedList.dequeue());
        System.out.println(doublyLinkedList.dequeue());

    }
}
