package Etapa4;

public class LinkedQueue<E> implements Queue<E>{

    private Node<E> front;
    private Node<E> back;
    private int size;

    public LinkedQueue() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public boolean isFull() {
        return false; //nunca fica cheia
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public void enqueue(E element) throws OverflowException {

    }

    @Override
    public E dequeue() throws UnderflowException {
        return null;
    }

    @Override
    public E front() throws UnderflowException {
        return null;
    }

    @Override
    public E back() throws UnderflowException {
        return null;
    }

    public void first(){

    }
}
