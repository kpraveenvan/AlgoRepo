package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class DeleteKthRecentlyInsertedItemUsingLL<Item> implements Iterable<Item> {

    //With LL whenever you are deleting you have to traverse to the kth last inserted element
    //If k is really small use a Doubly linkedlist as you can traverse k elements back

    Node first;
    Node last;
    int size;

    public void insert(Item item) {
        Node nodeToBeInserted = new Node(item);
        if(size == 0) {
            first = last = nodeToBeInserted;
            size++;
            return;
        }
        last.next = nodeToBeInserted;
        last = nodeToBeInserted;
        size++;
    }

    public Item delete(int k) { //Delete kth least recently inserted element

        if(size < k) {
            throw new UnsupportedOperationException();
        }
        Node temp = first;
        for(int i = 0; i < size - k - 1; i++) {
            temp = temp.next;
        }
        Node nodeToBeDeleted = temp.next;
        temp.next = nodeToBeDeleted.next;
        nodeToBeDeleted.next = null;
        size--;
        return nodeToBeDeleted.item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new CustomLLIterator();
    }

    private class CustomLLIterator implements Iterator<Item> {

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

    private class Node {

        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        DeleteKthRecentlyInsertedItemUsingLL<Integer> ll = new DeleteKthRecentlyInsertedItemUsingLL<>();
        ll.insert(0);
        ll.insert(1);
        ll.insert(2); //X
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        for(int element : ll) {
            System.out.println(element);
        }
        System.out.println("After deleting 3rd recent element");
        ll.delete(3);
        for(int element : ll) {
            System.out.println(element);
        }
        System.out.println("After deleting 2rd recent element");
        ll.delete(2);
        for(int element : ll) {
            System.out.println(element);
        }

    }


}
