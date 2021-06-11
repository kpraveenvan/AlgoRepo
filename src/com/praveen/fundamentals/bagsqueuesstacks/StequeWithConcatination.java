package com.praveen.fundamentals.bagsqueuesstacks;

public class StequeWithConcatination<Item> {

    Node first;
    Node last;
    int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(Item item) {

        Node node = new Node(item);
        if(size == 0) {
            first = last = node;
            size++;
            return;
        }

        node.next = first;
        first = node;
        size++;
    }

    public Item pop() {

        if(isEmpty()) throw new UnsupportedOperationException();
        Node temp = first;
        first = first.next;
        size--;
        return temp.item;
    }

    public void enqueue(Item item) {

        Node node = new Node(item);
        if(isEmpty()) {
            first = last = node;
            size++;
            return;
        }
        last.next = node;
        last = node;
        size++;
    }

    public Item dequeue() {
        if(isEmpty()) throw new UnsupportedOperationException();
        Node temp = first;
        first = first.next;
        size--;
        return temp.item;
    }

    public void concatinateStack(StequeWithConcatination<Item> steque) {
        if(isEmpty()) {
            first = steque.first;
            last = steque.last;
            size = steque.size();
            return;
        }
        steque.last = first;
        first = steque.first;
        size = size + steque.size;
    }

    public void concatinateQueue(StequeWithConcatination<Item> steque) {

        if(isEmpty()) {
            first = steque.first;
            last = steque.last;
            size = steque.size();
            return;
        }

        last.next = steque.first;
        last = steque.last;
        size = size + steque.size;
    }

    private class Node {
        Item item;
        Node next;
        Node previous;

        public Node(Item item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {

        StequeWithConcatination<String> steque1 = new StequeWithConcatination<>();
        steque1.push("This");
        steque1.push("is");
        steque1.push("Praveen");
        steque1.enqueue("Morning");
        steque1.enqueue("Here");

        StequeWithConcatination<String> steque2 = new StequeWithConcatination<>();
        steque2.push("This");
        steque2.push("is");
        steque2.push("Praveen");
        steque2.enqueue("Morning");
        steque2.enqueue("Here");

        StequeWithConcatination<String> steque3 = new StequeWithConcatination<>();
        steque3.push("Nice");
        steque3.push("Weather");
        steque3.push("50 Degrees");
        steque3.enqueue("Not so");
        steque3.enqueue("Hot");

        StequeWithConcatination<String> steque4 = new StequeWithConcatination<>();
        steque4.push("Nice");
        steque4.push("Weather");
        steque4.push("50 Degrees");
        steque4.enqueue("Not so");
        steque4.enqueue("Hot");

        steque1.concatinateStack(steque2);
        steque3.concatinateQueue(steque4);

        while (!steque1.isEmpty()) {
            System.out.println("Concatinated Stack " + steque1.pop());
        }

        while (!steque3.isEmpty()) {
            System.out.println("Concatinated Queue " + steque3.dequeue());
        }
    }

}
