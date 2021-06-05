package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class LLBasedBag<Item> implements Iterable<Item>{
    
    Node first;
    int size;
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void add(Item item) { //Order does not matter, Just add to the begin of the LL
        Node node = new Node(item);
        node.next = first;
        first = node;
        size++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class Node{
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }
    
    private class BagIterator implements Iterator<Item> {

        Node current = first;
        
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {  //Order does not matter in bag!!
            Node tmp = current;
            current = current.next;
            return tmp.item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        LLBasedBag<String> bag = new LLBasedBag<>();
        bag.add("Hello");
        bag.add("World");
        bag.add("Praveen");
        bag.add("Here");
        System.out.println("bag size " + bag.size());
        for (String element: bag) {
            System.out.println(element);
        }
    }
}
