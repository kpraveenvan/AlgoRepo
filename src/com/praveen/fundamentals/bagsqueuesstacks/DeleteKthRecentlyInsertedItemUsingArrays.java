package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class DeleteKthRecentlyInsertedItemUsingArrays<Item> implements Iterable<Item> {

    //Array implementation is better as you need to access elements by index, but after deleting kth least
    //recently added element you have to reshuffle the Array
    Item[] items = (Item[]) new Object[2];
    int endIndex;

    public void insert(Item item) {
        if(endIndex == items.length) {
            resize(2 * items.length);
        }
        items[endIndex++] = item;
    }

    public void delete(int k) { //Delete kth least recently inserted element
        int kthLeastInsertedIndex = endIndex - k;
        processRemovingKthLeastInsertedElement(kthLeastInsertedIndex);
    }

    private void processRemovingKthLeastInsertedElement(int kthLeastInsertedIndex) {

        endIndex--;
        for(int i = kthLeastInsertedIndex; i < endIndex; i++) {
            items[i] = items[i + 1];
        }
        items[endIndex] = null;
    }

    private void resize(int newSize) {

        Item[] temp = (Item[]) new Object[newSize];
        for(int i = 0 ; i < items.length; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new CustomLLIterator();
    }

    private class CustomLLIterator implements Iterator<Item> {

        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < endIndex;
        }

        @Override
        public Item next() {
            return items[currentIndex++];
        }

        @Override
        public void remove() {
            //NoOp
        }
    }

    public static void main(String[] args) {
        DeleteKthRecentlyInsertedItemUsingArrays<Integer> ll = new DeleteKthRecentlyInsertedItemUsingArrays<>();
        ll.insert(0);
        ll.insert(1);
        ll.insert(2); //X
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        for(int element : ll) {
            System.out.println(element);
        }
        System.out.println("After deleting 3rd recent element");
        ll.delete(3);
        for(int element : ll) {
            System.out.println(element);
        }
        System.out.println("After deleting 2rd recent element");
        ll.delete(2);
        for(int element : ll) {
            System.out.println(element);
        }

    }


}
