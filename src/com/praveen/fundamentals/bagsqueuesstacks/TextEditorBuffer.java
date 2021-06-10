package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Stack;

//Buffer() create an empty buffer
//        void insert(char c) insert c at the cursor position
//        char delete() delete and return the character at the cursor
//        void left(int k) move the cursor k positions to the left
//        void right(int k) move the cursor k positions to the right
//        int size() number of characters in the buffer
//        String serialize() return Buffer
public class TextEditorBuffer {

    Stack<Character> stack1 = new Stack<>();
    Stack<Character> stack2 = new Stack<>();

    void insert(char c) { //insert c at the cursor position
        stack1.push(c); //Always insert into stack1
    }

    char delete() {  //delete and return the character at the cursor

        char ch = stack1.pop(); //remove the element from 1st stack!!
        return ch;
    }

    void left(int k) { //move the cursor k positions to the left
        if(stack1.size() < k) throw new UnsupportedOperationException("Not possible");
        for(int i = 0; i < k; i++) {
            stack2.push(stack1.pop());
        }
    }

    void right(int k) { //move the cursor k positions to the right
        if(stack1.size() <= k) throw new UnsupportedOperationException("Not possible");
        for(int i = 0; i < k; i++) {
            stack1.push(stack2.pop());
        }
    }

    int size() { // number of characters in the buffer
        return stack1.size() + stack2.size();
    }

    String serialize() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < stack1.size(); i++) {
            sb.append(stack1.get(i)); //Should not use this
        }

        //This is in reverse order!!
        for (int i = stack2.size() - 1; i >= 0; i--) {
            sb.append(stack2.get(i)); //Should not use this
        }

        return sb.toString();
    }

    //if we are not using java.util.stack!!
    String serialize2() {

        StringBuilder sb = new StringBuilder();

        while (!stack1.isEmpty()) { //Push everything to stack2
            stack2.push(stack1.pop());
        }

        while (!stack2.isEmpty()) {
            sb.append(stack2.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        TextEditorBuffer textEditorBuffer = new TextEditorBuffer();
        textEditorBuffer.insert('a');
        textEditorBuffer.insert('b');
        textEditorBuffer.insert('c');
        textEditorBuffer.insert('d');
        textEditorBuffer.insert('e');

        textEditorBuffer.left(3);
        textEditorBuffer.right(1);

        System.out.println("Stack 1 size " + textEditorBuffer.stack1.size());
        System.out.println("Stack 2 size " + textEditorBuffer.stack2.size());

        System.out.println(textEditorBuffer.serialize());
        System.out.println(textEditorBuffer.serialize2());

    }

}
