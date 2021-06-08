package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class CopyStack<Item> implements Iterable<Item>{

    public CopyStack() {
    }

    public CopyStack(CopyStack<Item> copy) {
        CopyStack<Item> tempStack = new CopyStack<>();
        for(Item item : copy) {
            tempStack.push(item);
        }
        for(Item item : tempStack) {
            this.push(item);
        }
    }

    Node first;
    int size;

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public void push(Item item) {
        Node node = new Node(item);
        if(isEmpty()) {
            first = node;
            size++;
            return;
        }
        node.next = first;
        first = node;
        size++;
    }

    public Item pop() {
        if(isEmpty()) throw new UnsupportedOperationException();
        Node temp = first;
        first = first.next;
        size--;
        return temp.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    private class StackIterator implements Iterator<Item> {

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
        CopyStack<String> copyStack = new CopyStack<>();
        copyStack.push("Copy");
        copyStack.push("From");
        copyStack.push("is");
        copyStack.push("This");
        copyStack.push("Praveen");

        CopyStack<String> fromCopy = new CopyStack<>(copyStack);

        copyStack.pop(); //Removes Praveen
        fromCopy.pop(); //removes Praveen
        fromCopy.pop(); //removes This

        System.out.println("This is from Copy");
        for(String item : copyStack) {
            System.out.println(item);
        }

        System.out.println("This is from fromCopy");
        for(String item : fromCopy) {
            System.out.println(item);
        }
    }
}
