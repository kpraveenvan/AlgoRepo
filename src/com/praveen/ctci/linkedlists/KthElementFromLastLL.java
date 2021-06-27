package com.praveen.ctci.linkedlists;

public class KthElementFromLastLL<Item> {

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

    private Node getKthElementFromEndUsingRecursion(int k) {
        return getKthFromEnd(first, k, new NodeWrapper(first, 0));
    }

    private void printKthElementFromEndUsingRecursion(int k) {
        printKthFromEnd(first, k);
    }

    private int printKthFromEnd(Node head, int k) {
        if(head == null) {
            return 0;
        }
        int index = printKthFromEnd(head.next, k) + 1; // this goes all the way to the end and addes 1 to the index!!
        if(index == k) {
            System.out.println(k + " element from end in the LL is " + head.item);
        }
        System.out.println(" ** Debug the index count from end : " + index + " Debug **");
        return index;
        //Just return indexes from end and print the element at kth index;
    }

    private Node getKthFromEnd(Node head, int k, NodeWrapper wrapper) {

        if(head == null) {
            return null;
        }
        Node node = getKthFromEnd(head.next, k, wrapper);
        wrapper.counter = wrapper.counter + 1;
        if(wrapper.counter == k) {
            return head;
        }
        System.out.println(" ** Debug the index count from end : " + wrapper.counter + " Debug **");
        return node;
    }

    private Node returnKthElementFromEndIterativeApproach(int k) {
        Node p1 = first;
        Node p2 = first;

        for(int i = 0; i < k; i++) {
            if(p2 == null) {
                throw new UnsupportedOperationException("LL is not k elements long");
            }
            p2 = p2.next;
        }

        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        return p1;
    }
    
    private class Node{
        
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    private class NodeWrapper {
        Node node;
        int counter;

        public NodeWrapper(Node node, int counter) {
            this.node = node;
            this.counter = counter;
        }
    }

    public static void main(String[] args) {

        KthElementFromLastLL<Integer> kthElementFromLastLL = new KthElementFromLastLL<>();
        kthElementFromLastLL.insertAtEnd(1);
        kthElementFromLastLL.insertAtEnd(2);
        kthElementFromLastLL.insertAtEnd(3);
        kthElementFromLastLL.insertAtEnd(4);
        kthElementFromLastLL.insertAtEnd(5);
        kthElementFromLastLL.insertAtEnd(6);

        kthElementFromLastLL.printLinkedList();
        System.out.println();
        System.out.println("1st element from last = " + kthElementFromLastLL.returnKthElementFromEndIterativeApproach(1).item);
        System.out.println("2nd element from last = " + kthElementFromLastLL.returnKthElementFromEndIterativeApproach(2).item);
        System.out.println("3rd element from last = " + kthElementFromLastLL.returnKthElementFromEndIterativeApproach(3).item);
        System.out.println("4th element from last = " + kthElementFromLastLL.returnKthElementFromEndIterativeApproach(4).item);
        System.out.println("5th element from last = " + kthElementFromLastLL.returnKthElementFromEndIterativeApproach(5).item);
        System.out.println("6th element from last = " + kthElementFromLastLL.returnKthElementFromEndIterativeApproach(6).item);
        //System.out.println("7th element from last = " + kthElementFromLastLL.returnKthElementFromEndIterativeApproach(7).item);

        System.out.println("   ----    ");
        kthElementFromLastLL.printKthElementFromEndUsingRecursion(1);
        System.out.println("   ----    ");
        kthElementFromLastLL.printKthElementFromEndUsingRecursion(2);
        System.out.println("   ----    ");
        kthElementFromLastLL.printKthElementFromEndUsingRecursion(3);
        System.out.println("   ----    ");
        kthElementFromLastLL.printKthElementFromEndUsingRecursion(4);
        System.out.println("   ----    ");
        kthElementFromLastLL.printKthElementFromEndUsingRecursion(5);
        System.out.println("   ----    ");
        kthElementFromLastLL.printKthElementFromEndUsingRecursion(6);
        System.out.println("   ----    ");
        kthElementFromLastLL.printKthElementFromEndUsingRecursion(7);

        System.out.println("**** Using Wrapper **** ");
        System.out.println("**** Using Wrapper **** ");
        System.out.println("**** Using Wrapper **** ");
        System.out.println("   ----    ");
        System.out.println(kthElementFromLastLL.getKthElementFromEndUsingRecursion(1).item);
        System.out.println("   ----    ");
        System.out.println(kthElementFromLastLL.getKthElementFromEndUsingRecursion(2).item);
        System.out.println("   ----    ");
        System.out.println(kthElementFromLastLL.getKthElementFromEndUsingRecursion(3).item);
        System.out.println("   ----    ");
        System.out.println(kthElementFromLastLL.getKthElementFromEndUsingRecursion(4).item);
        System.out.println("   ----    ");
        System.out.println(kthElementFromLastLL.getKthElementFromEndUsingRecursion(5).item);
        System.out.println("   ----    ");
        System.out.println(kthElementFromLastLL.getKthElementFromEndUsingRecursion(6).item);
        System.out.println("   ----    ");
        System.out.println(kthElementFromLastLL.getKthElementFromEndUsingRecursion(7).item);


    }
}
