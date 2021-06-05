package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Iterator;
import java.util.Stack;

public class StackUsingLLWithCopyFunction<Item> implements Iterable<Item>{

    Node first;
    int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(Item item) {
        Node temp = new Node(item);
        if(isEmpty()) first = temp;
        else {
            temp.next = first;
            first = temp;
        }
        size++;
    }

    public Item pop() {
        if(isEmpty()) throw new UnsupportedOperationException();
        Node temp = first;
        first = first.next;
        size--;
        return temp.item;
    }

    public StackUsingLLWithCopyFunction<Item> copy(StackUsingLLWithCopyFunction<Item> originalStack) {

        StackUsingLLWithCopyFunction<Item> intermediateTempStack = new StackUsingLLWithCopyFunction<>();
        StackUsingLLWithCopyFunction<Item> copyStack = new StackUsingLLWithCopyFunction<>();
        for(Item item : originalStack) {
            intermediateTempStack.push(item);
        }
        for(Item item : intermediateTempStack) {
            copyStack.push(item);
        }
        return copyStack;
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
        StackUsingLLWithCopyFunction<String> stack = new StackUsingLLWithCopyFunction<>();
        stack.push("Hello");
        stack.push("There");
        stack.push("Praveen");
        stack.push("Here");
        StackUsingLLWithCopyFunction<String> copyStack = stack.copy(stack);
        for (String element : copyStack) {
            System.out.println(element);
        }
    }
}
