package com.praveen.ctci.linkedlists;

public class LLPartition<Item> {
    
    Node first;

    private void insertAtEnd(Item item) {
        Node node = new Node(item);
        if(first == null) {
            first = node;
            return;
        }

        Node temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    private void printLinkedList() {
      printLinkedList(first);
    }

    private void printLinkedList(Node node) {
        Node temp = node;
        while (temp != null) {
            if(temp.next == null)
                System.out.print( temp.item );
            else
                System.out.print( temp.item + " -> ");
            temp = temp.next;
        }
    }

    public Node partitionByPivot(int pivot) {

        Node node = first;
        Node head = first;
        Node tail = first;
        while (node != null) {
           Node next = node.next;

           //Now put the current node either at the begining or end
           if((Integer) node.item < pivot) {
               //Inset at begining
               node.next = head;
               head = node;
           } else {
               //Insert at end
               tail.next = node;
               tail = node;
           }
           node = next; //Here we are loosing node.next that is why we are assigning it to next so we can loop forward!!
        }
        tail.next = null;
        return head;
    }

    private class Node{

        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        LLPartition<Integer> llPartition = new LLPartition<>();
        llPartition.insertAtEnd(3);
        llPartition.insertAtEnd(5);
        llPartition.insertAtEnd(8);
        llPartition.insertAtEnd(5);
        llPartition.insertAtEnd(10);
        llPartition.insertAtEnd(2);
        llPartition.insertAtEnd(1);

        llPartition.printLinkedList();
        System.out.println("After partition by 5");
        System.out.println();
        llPartition.printLinkedList(llPartition.partitionByPivot(5));
    }
}
