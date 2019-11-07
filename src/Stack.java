/*
 * Stack.java
 * This class creates a stack where you can push, pop, and peek elements. It has two instance data, size, and front, and
 * an accessor for size. Also has a method that returns whether or not the stack is empty.
 * Date: 10/08/19
 * On my honor: EA
 */

import java.util.EmptyStackException;

public class Stack<E> {
    private Node<E> front;
    private int size;

    //returns void, takes in an element and puts it at the top of the stack
    public void push(E element){
        Node<E> newNode = new Node<>(element);
        //place an item above the front, set to front
        newNode.setBack(front);
        front = newNode;

        //increment size
        this.size++;
    }

    //returns the item removed, no parameters, removes element at the top of the stack
    public E pop()
            throws EmptyStackException{
        if(!isEmpty()){
            Node<E> oldFront = front;
            Node<E> oldBack = front.getBack();

            //remove front's pointer, replace front with the value behind it
            front.setBack(null);
            front = oldBack;

            //decrement size
            this.size--;

            //return the old value
            return oldFront.getData();
        } else {
            throw new EmptyStackException();
        }
    }


    //returns whether or not the stack is empty, no parameters
    public boolean isEmpty(){
        return this.size <= 0 && this.front == null;
    }


    //returns the int size value, no parameters
    public int size(){
        return this.size;
    }

    //returns the data of the top element on the stack, no parameters
    public E peek()
            throws EmptyStackException{
        //conditional because it will throw an error if you try to use .getData on
        if(!isEmpty()){
            return this.front.getData();
        } else {
            throw new EmptyStackException();
        }
    }



}