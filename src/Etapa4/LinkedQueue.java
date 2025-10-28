package Etapa4;

public class LinkedQueue<E> implements Queue<E>{

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int numElements() {
        return 0;
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
