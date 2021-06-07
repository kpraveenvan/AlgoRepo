package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class LLReversalIterative<Item> implements Iterable<Item> {

    Node first;

    public Node reverse(Node node) {

        if(node == null || node.next == null) return node;
        Node tempFirst = node;
        Node reverse = null;
        while (tempFirst != null) {
            Node tempSecond = tempFirst.next;
            tempFirst.next = reverse;
            reverse = tempFirst;
            tempFirst = tempSecond;
        }
        //Printing Reverse
        Node tempPrint = reverse;
        while (tempPrint != null) {
            System.out.println(tempPrint.item);
            tempPrint = tempPrint.next;
        }

        return reverse;
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
        LLReversalIterative<String> llReversalIterative = new LLReversalIterative<>();
        llReversalIterative.addAtEnd("1");
        llReversalIterative.addAtEnd("2");
        llReversalIterative.addAtEnd("3");
        llReversalIterative.reverse(llReversalIterative.first);
    }
}
