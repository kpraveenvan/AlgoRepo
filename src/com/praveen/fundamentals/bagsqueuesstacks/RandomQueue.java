package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class RandomQueue<Item> implements Iterable<Item> {

    Item[] items = (Item[]) new Object[2];
    int start;
    int end;
    int size;

    public void enqueue(Item item) {

        if(end == items.length) {
            resize(2 * items.length);
        }
        items[end++] = item;
        size++;
    }

    public Item dequeue() { //Dequeue a random number!!
        if(size == 0) {
            throw new UnsupportedOperationException();
        }
        if(size < items.length/4) {
            resize(items.length/2);
        }
        int random = (int) (start + Math.floor(Math.random() * (end - start)));
        Item temp = items[start];
        items[start] = items[random];
        items[random] = temp;

        temp = items[start]; //After replacement get the item to return!!
        items[start++] = null; //No Loiter
        size--;
        return temp;

    }

    private void resize(int newSize) {

        Item[] temp = (Item[]) new Object[newSize];
        for(int i = 0; i < end - start; i++) {
            temp[i] = items[start + i];
        }
        start = 0;
        end = size;
        items = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }

    private class RandomQueueIterator implements Iterator<Item> {

        int statIndex = start;
        int endIndex = end;

        @Override
        public boolean hasNext() {
            return statIndex < endIndex;
        }

        @Override
        public Item next() {

            int random = (int) (statIndex + Math.floor(Math.random() * (endIndex - statIndex)));
            Item temp = items[random];
            items[random] = items[statIndex];
            items[statIndex] = temp;

            return items[statIndex++];
        }

        @Override
        public void remove() {
            //NoOp
        }
    }

    public static void main(String[] args) {
        RandomQueue<Integer> randomQueue = new RandomQueue<>();
        randomQueue.enqueue(2);
        randomQueue.enqueue(4);
        randomQueue.enqueue(5);
        randomQueue.enqueue(7);
        randomQueue.enqueue(8);
//        System.out.println(randomQueue.dequeue());
//        System.out.println(randomQueue.dequeue());
//        System.out.println(randomQueue.dequeue());
//        System.out.println(randomQueue.dequeue());
//        System.out.println(randomQueue.dequeue());
        for (int element : randomQueue) {
            System.out.println(element);
        }
    }
}
