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

    public void enqueue(Item item) {

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

    public Item dequeue() {

        if(isEmpty()) {
            throw new UnsupportedOperationException();
        }
        Node temp = first;
        first = first.next;
        if(first != null) {
            first.previous = null;
        }
        size--;
//        //Do we need these
//        if(size == 1) {
//            last = first;
//        }
//        //Do we need these
//        if(size == 0) {
//            first = last = null;
//        }
        return temp.item;
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
        doublyLinkedList.enqueue("Hello");
        doublyLinkedList.enqueue("There");
        doublyLinkedList.enqueue("Praveen");
        doublyLinkedList.enqueue("Here");
        for(String element : doublyLinkedList) {
            System.out.println(element);
        }
        System.out.println(doublyLinkedList.dequeue());
        System.out.println(doublyLinkedList.dequeue());
        System.out.println(doublyLinkedList.dequeue());
        System.out.println(doublyLinkedList.dequeue());
        doublyLinkedList.enqueue("Hello");
        doublyLinkedList.enqueue("There");
        doublyLinkedList.enqueue("Praveen");
        doublyLinkedList.enqueue("Here");
        System.out.println(doublyLinkedList.dequeue());
        System.out.println(doublyLinkedList.dequeue());
        System.out.println(doublyLinkedList.dequeue());
        System.out.println(doublyLinkedList.dequeue());
    }
}
