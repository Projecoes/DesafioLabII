package Etapa4;

public class LinkedStack<E> implements Stack<E> {


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
    public void push(E element) throws OverflowException {

    }

    @Override
    public E pop() throws UnderflowException {
        return null;
    }

    @Override
    public E top() throws UnderflowException {
        return null;
    }
}
