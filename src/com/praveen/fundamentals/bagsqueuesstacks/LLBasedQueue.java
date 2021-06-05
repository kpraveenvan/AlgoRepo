package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class LLBasedQueue<Item> implements Iterable<Item>{

    Node first;
    Node last;
    int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) { //Insert at last!!
        Node node = new Node(item);
        if(isEmpty()){
            first = last = node;
        }
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public Item dequeue() {

        if(isEmpty()) throw new UnsupportedOperationException();
        Node temp = first;
        first = first.next;
        size--;
        if(isEmpty()) last = null;
        return temp.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }


    class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    class QueueIterator implements Iterator<Item> {

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
        LLBasedQueue<String> queue = new LLBasedQueue<>();
        queue.enqueue("Hello");
        queue.enqueue("World");
        queue.enqueue("Praveen");
        queue.enqueue("Here");
        for(String element: queue) {
            System.out.println("Queue Iterator : " + element );
        }
        System.out.println("queue size " + queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println("queue size now " + queue.size());
        System.out.println(queue.dequeue());
    }

}
