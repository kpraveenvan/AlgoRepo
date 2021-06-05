package com.praveen.fundamentals.bagsqueuesstacks;

public class MaximumInLL<Item> {

    Node first;

    public void add(Item item) {

        Node temp = new Node(item);
        if(first == null) {
            first = temp;
        } else {
          Node curr = first;
          while (curr.next != null) {
              curr = curr.next;
          }
          curr.next = temp;
        }
    }

    public double max() {
        double currentMax = Double.MIN_VALUE;
        Node temp = first;
        while (temp != null) {
            double value = (double) temp.item;
            if(currentMax < value) currentMax = value;
            temp = temp.next;
        }
        return currentMax;
    }

    public double maxRecursive(Node node) {
        if(node == null) return 0.0;
        return Math.max((Double) node.item, maxRecursive(node.next));
    }

    private class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {

        MaximumInLL<Double> ll = new MaximumInLL<>();
        ll.add(1.0);
        ll.add(15.0);
        ll.add(17.0);
        ll.add(21.0);
        ll.add(7.0);
        System.out.println(ll.max());
        System.out.println(ll.maxRecursive(ll.first));
    }
}
