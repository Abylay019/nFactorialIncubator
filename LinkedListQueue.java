/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week11;


public class LinkedListQueue<T> implements Queue<T> {

    private int size;
    private Node<T> front;
    private Node<T> back;

    public LinkedListQueue() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void enqueue(T value) {
        Node node = new Node(value);

        if (size == 0) {
            front = node;
        } else {
            back.setLink(node);
        }

        back = node;
        size++;

    }

    @Override
    public T dequeue() throws Exception {
        if (front == null) {
            throw new Exception("Fail!!! The Queue is Empty!!!!");
        }

        T value = front.getValue();
        front = front.getLink();
        size--;
        if ( size == 0) {
            back = null;
        }
        return value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
//        System.out.print("\nQueue = front [ ");
        Node tmp = front;
        while (tmp != null) {
            sb.append(tmp.getValue()).append(" ");
            tmp = tmp.getLink();
        }
        return sb.toString(); //+ "] back";
    }

}
