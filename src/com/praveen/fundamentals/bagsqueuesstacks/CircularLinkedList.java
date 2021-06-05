package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class CircularLinkedList <Item> implements Iterable<Item> {

    Node last;
    int size;

    private void add(Item item) {
        Node temp = new Node(item);
        if(size == 0) {
            temp.next = temp;
            last = temp;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        size++;
    }

    private Item remove() {

        Item item = last.item;
        Node temp = last;
        while (temp.next != last) {
            temp = temp.next;
        }
        temp.next = last.next;
        last = temp;
        size--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new CircularLLIterator();
    }

    private class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    private class CircularLLIterator implements Iterator<Item> {

        Node current = last.next;
        int currentSize = size;

        @Override
        public boolean hasNext() {
            return currentSize > 0;
        }

        @Override
        public Item next() {
            Node temp = current;
            current = current.next;
            currentSize--;
            return temp.item;
        }

        @Override
        public void remove() {
            //NoOp
        }
    }

    public static void main(String[] args) {
        CircularLinkedList<String> circularLinkedList = new CircularLinkedList<>();
        circularLinkedList.add("Hello");
        circularLinkedList.add("There");
        circularLinkedList.add("Praveen");
        circularLinkedList.add("Here");
        for(String element: circularLinkedList) {
            System.out.println(element);
        }
        circularLinkedList.remove();
        System.out.println("After remove");
        for(String element: circularLinkedList) {
            System.out.println(element);
        }
    }

}
