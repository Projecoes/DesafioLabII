package Etapa3;

public class StaticStack<E> implements Stack<E>{

    private int top;
    private Object[] elements;
    private int maxSize;

    public StaticStack(int maxSize) {
        this.maxSize = maxSize;
        this.elements = new Object[maxSize];
        this.top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == maxSize -1;
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
