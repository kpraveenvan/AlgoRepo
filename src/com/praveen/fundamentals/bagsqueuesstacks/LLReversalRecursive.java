package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class LLReversalRecursive<Item> implements Iterable<Item> {

    Node first;

    public Node reverse(Node first) {

        if(first == null) return null;
        if(first.next == null) return first;
        Node second = first.next;
        Node reverse = reverse(second); //Sub problem reversing from the second node!!
        second.next = first;
        first.next = null;
        return reverse;
    }

    public void printReverse(Node node) {
        Node reverse = reverse(node);
        while (reverse != null) {
            System.out.println(reverse.item);
            reverse = reverse.next;
        }
    }

    private void addAtEnd(Item item) {

        Node newNode = new Node(item);
        if(first == null) {
            first = newNode;
            return;
        }
        Node temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LLIterator();
    }

    private class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    private class LLIterator implements Iterator<Item> {

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
        LLReversalRecursive<String> llReversalIterative = new LLReversalRecursive<>();
        llReversalIterative.addAtEnd("1");
        llReversalIterative.addAtEnd("2");
        llReversalIterative.addAtEnd("3");
        llReversalIterative.printReverse(llReversalIterative.first);
    }
}
