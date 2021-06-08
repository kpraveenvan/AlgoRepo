package com.praveen.fundamentals.bagsqueuesstacks;

//Move-to-front. Read in a sequence of words from standard input and
//        maintain the words in a linked list with no duplicates. When you read in a previously
//        unseen word, insert it at the front of the list. When you read in a duplicate
//        word, delete it from the list and reinsert it at the beginning. Name your program
//        MoveToFront: it implements the well-known move-to-front strategy, which is useful for
//        caching, data compression, and many other applications where items that have been
//        recently accessed are more likely to be reaccessed.

import java.util.Iterator;

public class MoveToFrontCacheImplementation<Item> implements Iterable<Item>{

    Node front; //This is used for inserting newer words in front

    public void insert(Item item) {
        searchAndRemove(item);
        Node nodeToInsert = new Node(item);
        if(front == null) {
            front = nodeToInsert;
            return;
        }
        nodeToInsert.next = front;
        front = nodeToInsert;
    }

    public void searchAndRemove(Item item) {
        if(front == null) return;
        if(front.item.equals(item)) front = null;

        Node temp = front;
        Node nodeToDelete = temp.next;
        while (nodeToDelete != null && !nodeToDelete.item.equals(item)) {
            nodeToDelete = nodeToDelete.next;
            temp = temp.next;
        }
        if(nodeToDelete != null) {
            temp.next = nodeToDelete.next;
            nodeToDelete.next = null;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new CacheIterator();
    }

    private class CacheIterator implements Iterator<Item> {

        Node current = front;

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
        MoveToFrontCacheImplementation<String> cacheImplementation = new MoveToFrontCacheImplementation<>();
        cacheImplementation.insert("Hello");
        cacheImplementation.insert("There");
        cacheImplementation.insert("Praveen");
        cacheImplementation.insert("Here");
        cacheImplementation.insert("Praveen");
        cacheImplementation.insert("Hello");

        for(String element : cacheImplementation) {
            System.out.println(element);
        }
    }
}

