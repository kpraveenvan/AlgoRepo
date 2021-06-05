package com.praveen.fundamentals.bagsqueuesstacks;

public class ResizingArrayQueueOfStrings<Item> {

    Item[] queueItems = (Item[]) new Object[2]; //Java no generic arrays!!
    int startIndex;
    int endIndex;
    int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if(queueItems.length == size) {
            resize(size * 2);
        }
        queueItems[endIndex++] = item;
        size++;
    }

    public Item dequeue() {
        if(isEmpty()) throw new UnsupportedOperationException();
        if(queueItems.length > 4 * size) {
            resize(queueItems.length / 2);
        }
        Item item = queueItems[startIndex++];
        size--;
        return item;
    }

    private void resize(int newSize) {

        Item[] tempArr = (Item[]) new Object[newSize]; //Java has not generic arrays
        for(int i = 0; i < endIndex - startIndex; i++) {
            tempArr[i] = queueItems[startIndex + i];
        }
        startIndex = 0;
        endIndex = size;
        queueItems = tempArr;
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings<String> queue = new ResizingArrayQueueOfStrings<>();
        queue.enqueue("Hello");
        queue.enqueue("World");
        queue.enqueue("Praveen");
        queue.enqueue("Here");
        queue.enqueue("Size 5");
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
