package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class CopyQueue<Item> implements Iterable<Item> {

    Node first;
    Node last;
    int size;

    public CopyQueue() {
    }

    public CopyQueue(CopyQueue<Item> copy) {
        for(Item item : copy) {
            this.enqueue(item);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return  size == 0;
    }

    public void enqueue(Item item) { //insert at end!!
        Node nodeToBeInserted = new Node(item);
        if(isEmpty()) {
            first = last = nodeToBeInserted;
            size++;
            return;
        }
        last.next = nodeToBeInserted;
        last = nodeToBeInserted;
        size++;
    }

    public Item dequeue() {

        if(isEmpty()) throw new UnsupportedOperationException();
        Node temp = first;
        first = first.next;
        size--;
        return temp.item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {

        Node current = first;

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

    class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        CopyQueue<String> copy = new CopyQueue<>();
        copy.enqueue("Praveen");
        copy.enqueue("Kumar");
        copy.enqueue("From");

        CopyQueue<String> fromCopy = new CopyQueue<>(copy);

        copy.enqueue("Copy");
        fromCopy.enqueue("fromCopy");

        copy.dequeue(); //Removes 'Praveen'
        fromCopy.dequeue(); //Removes 'Praveen'

        System.out.println("From copy queue");
        for(String item : copy) {
            System.out.println(item);
        }

        System.out.println("From fromCopy queue");
        for(String item : fromCopy) {
            System.out.println(item);
        }


    }

}
