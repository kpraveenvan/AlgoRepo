package com.praveen.fundamentals.bagsqueuesstacks;

public class TwoStacksWithDeque<Item> {

    Node separator = new Node();
    Node firstBegin;
    Node firstEnd;
    Node secondBegin;
    Node secondEnd;
    int size1;
    int size2;

    public boolean isFirstStackEmpty() {
        return size1 == 0;
    }

    public boolean isSecondStackEmpty() {
        return size2 == 0;
    }

    public void pushFirst(Item item) {

        Node node = new Node(item);
        if(size1 == 0) {
            firstBegin = firstEnd = node;
            node.next = separator;
            separator.previous = node;
            size1++;
            return;
        }
        node.next = firstEnd;
        firstEnd.previous = node;
        firstEnd = node;
        size1++;
    }

    public void pushSecond(Item item) {

        Node node = new Node(item);
        if(size2 == 0) {
            secondBegin = secondEnd = node;
            node.previous = separator;
            separator.next = node;
            size2++;
            return;
        }
        secondEnd.next = node;
        node.previous = secondEnd;
        secondEnd = node;
        size2++;
    }

    public Item popFirst() {
        if(size1 == 0) throw new UnsupportedOperationException();
        Node temp = firstEnd;
        if(firstEnd.next.equals(separator)) {
            separator.previous = null;
            size1--;
            return temp.item;
        }
        firstEnd = firstEnd.next;
        size1--;
        return temp.item;
    }

    public Item popSecond() {

        if(size2 == 0) throw new UnsupportedOperationException();
        Node temp = secondEnd;
        if(secondEnd.previous.equals(separator)) {
            separator.next = null;
            size2--;
            return temp.item;
        }
        secondEnd = secondEnd.previous;
        size2--;
        return temp.item;
    }

    private class Node {
        Item item;
        Node next;
        Node previous;

        public Node() {
        }

        public Node(Item item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        TwoStacksWithDeque<String> stringTwoStacksWithDeque = new TwoStacksWithDeque<>();
        stringTwoStacksWithDeque.pushFirst("First");
        stringTwoStacksWithDeque.pushFirst("stack 1");
        stringTwoStacksWithDeque.pushFirst("Push 1");

        stringTwoStacksWithDeque.pushSecond("Second");
        stringTwoStacksWithDeque.pushSecond("stack 2");
        stringTwoStacksWithDeque.pushSecond("push 2");

        System.out.println("Popping first stack!!");
        while (!stringTwoStacksWithDeque.isFirstStackEmpty()) {
            System.out.println(stringTwoStacksWithDeque.popFirst());
        }

        System.out.println("Popping second stack!!");
        while (!stringTwoStacksWithDeque.isSecondStackEmpty()) {
            System.out.println(stringTwoStacksWithDeque.popSecond());
        }

    }
}
