package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

//    Steque. A stack-ended queue or steque is a data type that supports push, pop, and
//    enqueue. Articulate an API for this ADT. Develop a linked-list-based implementation.
public class Steque<Item> implements Iterable<Item> {

    //Push -> Insert at beginning
    //Pop -> delete at beginning
    //enqueue -> insert at end
    Node first;
    Node last;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(Item item) {

        Node itemToBeInserted = new Node(item);
        if(isEmpty()) {
            first = last = itemToBeInserted;
            size++;
            return;
        }
        itemToBeInserted.next = first;
        first = itemToBeInserted;
        size++;
    }

    public Item pop() {

        if(isEmpty()) {
            throw new UnsupportedOperationException();
        }
        Node temp = first;
        first = first.next;
        size--;
        return temp.item;
    }

    public void enqueue(Item item) {

        Node itemToBeInserted = new Node(item);
        if(isEmpty()) {
            first = last = itemToBeInserted;
            size++;
            return;
        }
        last.next = itemToBeInserted;
        last = itemToBeInserted;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StequeIterator();
    }

    private class Node {
        Item item;
        Node next;
        public Node(Item item) {
            this.item = item;
        }
    }

    private class StequeIterator implements Iterator<Item> {

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

    public static void main(String[] args) {
        Steque<String> steque = new Steque<>();
        steque.push("Vanga");
        steque.push("Kumar");
        steque.push("Praveen");
        steque.enqueue("Here");

        for(String element : steque) {
            System.out.println(element);
        }
    }
}
