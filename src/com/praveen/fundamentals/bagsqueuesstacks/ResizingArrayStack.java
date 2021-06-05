package com.praveen.fundamentals.bagsqueuesstacks;


import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

    Item[] items = (Item[]) new Object[2];
    int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(Item item) {

        if(items.length == size) { //Stack Full resize!!
            resize(size * 2);
        }
        items[size++] = item; //Array 0 index start from 0th position
    }

    public Item pop() {

        Item item = items[--size]; //Array 0 index!!
        items[size] = null; //This way we are avoiding loittering and GC will clear the Item
        if(size < items.length/4) { //Stack less than 1/4th full
            resize(size/2);
        }
        return item;
    }

    private void resize(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0 ; i < items.length; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        int tmpSize = size;

        @Override
        public boolean hasNext() {
            return tmpSize > 0;
        }

        @Override
        public Item next() {
            return items[--tmpSize]; //0 index in Array
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        stack.push("hello");
        stack.push("world");
        stack.push("praveen");
        stack.push("here");
        stack.push("Size 5");
        System.out.println(stack.size());
    }
}
