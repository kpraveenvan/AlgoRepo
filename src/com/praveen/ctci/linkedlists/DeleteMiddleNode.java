package com.praveen.ctci.linkedlists;


public class DeleteMiddleNode<Item> {

    Node first;

    private void insertAtBegin(Item item) {
        Node node = new Node(item);
        node.next = first;
        first = node;
    }

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
        Node temp = first;
        while (temp != null) {
            if(temp.next == null)
                System.out.print( temp.item );
            else
                System.out.print( temp.item + " -> ");
            temp = temp.next;
        }
    }

    private class Node{

        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    public void deleteMiddleNode() {
        Node slow = first;
        Node fast = first;

        while (fast != null && fast.next != null) {
            fast = fast.next;
            fast = fast.next;
            if(fast != null && fast.next != null) { //Only move slow if next fast move is possible
                slow = slow.next;
            }
        }

        Node temp = slow.next;
        slow.next = temp.next;
    }

    public static void main(String[] args) {
        DeleteMiddleNode<Integer> deleteMiddleNode = new DeleteMiddleNode<>();
        deleteMiddleNode.insertAtEnd(1);
        deleteMiddleNode.insertAtEnd(2);
        deleteMiddleNode.insertAtEnd(3);
        deleteMiddleNode.insertAtEnd(4);
        deleteMiddleNode.insertAtEnd(5);

        deleteMiddleNode.printLinkedList();
        System.out.println();

        deleteMiddleNode.deleteMiddleNode();
        System.out.println();
        deleteMiddleNode.printLinkedList();
        deleteMiddleNode.deleteMiddleNode();
        System.out.println();
        deleteMiddleNode.printLinkedList();



    }

}
