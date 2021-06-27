package com.praveen.ctci.linkedlists;

public class SumListsNonReverse {
    Node firstNode;
    Node secondNode;

    public Node sumOfLists() {
        Node result = null;
        Node tempFirst = firstNode;
        Node tempSecond = secondNode;
        int carry = 0;
        while (tempFirst != null || tempSecond != null) {
            int sum = 0;
            if(tempFirst != null) {
                sum += tempFirst.value;
                tempFirst = tempFirst.next;
            }
            if(tempSecond != null) {
                sum += tempSecond.value;
                tempSecond = tempSecond.next;
            }
            sum = sum + carry;
            carry = sum / 10;
            sum = sum % 10;
            Node nodeToInsert = new Node(sum);
            if(result == null) {
                result = nodeToInsert;
            } else {
                insertAtEnd(result, nodeToInsert);
            }
        }
        return result;
    }

    public Node sumOfListsUsingRecursion() {
        return sumOfListsUsingRecursion(firstNode, secondNode, 0);
    }

    public Node sumOfListsUsingRecursion(Node list1, Node list2, int carry) {
        if(list1 == null && list2 == null && carry == 0) {
            return null;
        }
        Node result = new Node();
        int sum = carry;
        if(list1 != null) {
            sum += list1.value;
        }
        if(list2 != null) {
            sum += list2.value;
        }

        carry = sum / 10;
        sum = sum % 10;

       result.value = sum;
       result.next = sumOfListsUsingRecursion(
               list1.next == null ? null : list1.next,
               list2.next == null ? null : list2.next,
               carry
       );

       return result;
    }

    private void insertAtEnd(Node result, Node nodeToInsert) {
        Node temp = result;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = nodeToInsert;
    }

    private void insertAtBeginForFirst(int number) {
        Node node = new Node(number);
        node.next = firstNode;
        firstNode = node;
    }

    private void insertAtEndForFirst(int number) {
        Node node = new Node(number);
        if(firstNode == null) {
            firstNode = node;
            return;
        }

        Node temp = firstNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    private void insertAtBeginForSecond(int number) {
        Node node = new Node(number);
        node.next = secondNode;
        secondNode = node;
    }

    private void insertAtEndForSecond(int number) {
        Node node = new Node(number);
        if(secondNode == null) {
            secondNode = node;
            return;
        }

        Node temp = secondNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    private void printLinkedList(Node node) {
        Node temp = node;
        while (temp != null) {
            if(temp.next == null)
                System.out.print( temp.value );
            else
                System.out.print( temp.value + " -> ");
            temp = temp.next;
        }
    }

    private void printResult(Node node) { //This basically prints in reverse order

        if(node == null) {
            return;
        }
        printResult(node.next);
        System.out.print(node.value);
    }

    private class Node {
        int value;
        Node next;

        public Node() {

        }

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        SumListsNonReverse sumLists = new SumListsNonReverse();
        sumLists.insertAtEndForFirst(7);
        sumLists.insertAtEndForFirst(1);
        sumLists.insertAtEndForFirst(6);
        sumLists.insertAtEndForFirst(4);
        sumLists.insertAtEndForSecond(5);
        sumLists.insertAtEndForSecond(9);
        sumLists.insertAtEndForSecond(2);
        sumLists.insertAtEndForSecond(4);

        sumLists.printResult(sumLists.sumOfLists());
        System.out.println();


        sumLists.printResult(sumLists.sumOfListsUsingRecursion());
    }
}

