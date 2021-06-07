package com.praveen.fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.In;

import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item> {

    Item[] items = (Item[]) new Object[2];
    int size;

    //bag has only add functionality
    public void add(Item item) {
        if(items.length == size) {
            resize(2 * size);
        }
        items[size++] = item;
    }

    private void resize(int newSize) {

        Item[] temp = (Item[]) new Object[2 * newSize];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<Item> {

        Item[] currentItems = items;
        int currentSize = 0;

        @Override
        public boolean hasNext() {
            return currentSize < size;
        }

        @Override
        public Item next() {

            int randomNumber = (int) (currentSize + Math.floor(Math.random() * (size - currentSize)));
            Item temp = currentItems[currentSize];
            currentItems[currentSize] = currentItems[randomNumber];
            currentItems[randomNumber] = temp;
            return currentItems[currentSize++];
        }

        @Override
        public void remove() {
            //NoOp
        }
    }

    public static void main(String[] args) {
        RandomBag<Integer> randomBag = new RandomBag<>();
        randomBag.add(2);
        randomBag.add(4);
        randomBag.add(5);
        randomBag.add(9);
        for (int number : randomBag) {
            System.out.println(number);
        }
    }
}
