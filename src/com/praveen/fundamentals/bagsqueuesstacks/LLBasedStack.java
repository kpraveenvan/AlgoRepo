package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class LLBasedStack<Item> implements Iterable<Item>{

    Node first;
    int size;
    LLBasedStack() {}

    public void push(Item item) { //add at the begining
        Node node =  new Node(item);
        node.next = first;
        first = node;
        size++;
    }

    public Item pop() {
        if(size == 0) throw new UnsupportedOperationException();
        Node temp = first;
        first = first.next;
        size--;
        return temp.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class Node {
        Item data;
        Node next;

        public Node(Item data) {
            this.data = data;
        }
    }

    class StackIterator implements Iterator<Item> {

        Node current = first;
        int iterSize = size;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Node tmp = current;
            current = current.next;
            return tmp.data;
        }

        @Override
        public void remove() {
            //NoOp
        }
    }

    public static void main(String[] args) {
        LLBasedStack<String> stack = new LLBasedStack<>();
        stack.push("Hello");
        stack.push("World");
        stack.push("Praveen");
        stack.push("Here");
        for(String element : stack) {
            System.out.println("Stack iteration : " + element);
        }
        System.out.println("Stack size " + stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("Stack size now " + stack.size());
        System.out.println(stack.pop());

    }
}
