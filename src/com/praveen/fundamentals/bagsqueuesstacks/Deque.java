package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

//Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or
//        a queue but supports adding and removing items at both ends. A deque stores a collection
//        of items and supports the following API:
//public class Deque<Item> implements Iterable<Item>
//Deque() create an empty deque
//        boolean isEmpty() is the deque empty?
//        int size() number of items in the deque
//        void pushLeft(Item item) add an item to the left end
//        void pushRight(Item item) add an item to the right end
//        Item popLeft() remove an item from the left end
//        Item popRight() remove an item from the right end

public class Deque<Item> implements Iterable<Item> {

    Node left;
    Node right;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void pushLeft(Item item) {

        Node nodeToBeInserted = new Node(item);
        if(isEmpty()) {
            left = right = nodeToBeInserted;
            size++;
            return;
        }
        nodeToBeInserted.next = left;
        left.previous = nodeToBeInserted;
        left = nodeToBeInserted;
        size++;
    }

    public void pushRight(Item item) {

        Node nodeToBeInserted = new Node(item);
        if(isEmpty()) {
            left = right = nodeToBeInserted;
            size++;
            return;
        }
        right.next = nodeToBeInserted;
        nodeToBeInserted.previous = right;
        right = nodeToBeInserted;
        size++;
    }

    public Item popLeft() {

        if(isEmpty()) {
            throw new UnsupportedOperationException();
        }

        Node temp = left;
        left = left.next;
        temp.next = null;
        if(left != null) {
            left.previous = null;
        }
        size--;
        return temp.item;
    }

    public Item popRight() {

        if(isEmpty()) {
            throw new UnsupportedOperationException();
        }

        Node temp = right;
        right = right.previous;
        temp.previous = null;
        if(right != null) {
            right.next = null;
        }
        size--;
        return temp.item;
    }


//        Item popRight() remove an item from the right end



    private class Node {
        Item item;
        Node next;
        Node previous;

        public Node(Item item) {
            this.item = item;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        Node current = left;

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
        Deque<String> deque = new Deque<>();
        deque.pushLeft("Vanga");
        deque.pushLeft("Kumar");
        deque.pushLeft("Praveen");
        deque.pushRight("is");
        deque.pushRight("a");
        deque.pushRight("Human");
        for(String element : deque) {
            System.out.println(element);
        }

        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());

        System.out.println(deque.popRight());
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());


    }

}
