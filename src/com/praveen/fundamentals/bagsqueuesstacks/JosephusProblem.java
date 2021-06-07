package com.praveen.fundamentals.bagsqueuesstacks;

//Josephus problem. In the Josephus problem from antiquity, N people are in dire
//        straits and agree to the following strategy to reduce the population. They arrange themselves
//        in a circle (at positions numbered from 0 to N–1) and proceed around the circle,
//        eliminating every Mth person until only one person is left. Legend has it that Josephus
//        figured out where to sit to avoid being eliminated. Write a Queue client Josephus that
//        takes N and M from the command line and prints out the order in which people are
//        eliminated (and thus would show Josephus where to sit in the circle).
public class JosephusProblem {

    //Use Circular LL and remove nodes one of the other till one of the node is left
    Node last;
    int size;
    public void setUp(int numberOfPersons) {

        for(int i = 1; i <= numberOfPersons; i++) {
            Node nodeToBeInserted = new Node(i);
            if(last == null) {
                last = nodeToBeInserted;
                nodeToBeInserted.next = last;
                size++;
            } else {
                nodeToBeInserted.next = last.next;
                last.next = nodeToBeInserted;
                last = nodeToBeInserted;
                size++;
            }
        }
    }

    public int personLeftAfterElimination(int numberOfPersons, int eliminationNumber) {

        if(eliminationNumber > numberOfPersons) {
            //No One is eliminated
        }
        setUp(numberOfPersons);
        Node temp = last;
        while (size > 1) {
            for(int i = 0; i < eliminationNumber - 1; i++) {
                temp = temp.next;
            }
            Node eliminatedNode = temp.next;
            System.out.println("Eliminated Perosn " + eliminatedNode.personId);
            temp.next = eliminatedNode.next;
            eliminatedNode.next = null;
            size--;
        }
        System.out.println("Last remaining person " + temp.personId);
        return temp.personId;
    }



    private class Node {
        int personId;
        Node next;

        public Node(int personId) {
            this.personId = personId;
        }
    }

    public static void main(String[] args) {
        JosephusProblem josephusProblem = new JosephusProblem();
        josephusProblem.personLeftAfterElimination(7, 2);
    }

}
