package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class LLOperations<Item> implements Iterable<Item>{

    private Node first;
    private Node last;
    private int size;

    public void addAtEnd(Item item) {
        Node node = new Node(item);
        if(size == 0) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addAtBegining(Item item) {
        Node node = new Node(item);
        if(size == 0) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    private Item removeAtBegining() {
        if(size == 0) throw new UnsupportedOperationException();
        else if(size == 1) {
            Node temp = first;
            first = last = null;
            size--;
            return temp.item;
        } else {
            Node temp = first;
            first = first.next;
            size--;
            return temp.item;
        }
    }

    private Item removeAtEnd() {
        Node temp = first;
        while (temp.next == last) {
            temp = temp.next;
        }
        temp.next = null;
        last = temp;
        return temp.item;
    }

    private Item deleteKthElement(int k) {

        if(size < k) throw new UnsupportedOperationException();
        Node temp = first;
        if(k == 1) {
            temp = temp.next;
            first = temp;
            return temp.item;
        }
        for(int i = 1; i < k - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        if(k == size) { //This is same as deleteing last node
            last = temp;
        }
        return temp.item;
    }

    public boolean find(Item item) {
        Node temp = first;
        while (temp != null) {
            if(temp.item.equals(item)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
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
        LLOperations<String> llOperations = new LLOperations<>();
        llOperations.addAtBegining("Praveen");
        llOperations.addAtEnd("Vanga");
        llOperations.addAtEnd("Here");
        llOperations.addAtBegining("Hello");
        llOperations.addAtBegining("world");
        for(String element : llOperations) {
            System.out.println(element);
        }
        llOperations.deleteKthElement(1);
        llOperations.deleteKthElement(3);
        System.out.println("-- After delete --");
        for(String element : llOperations) {
            System.out.println(element);
        }
    }
}
