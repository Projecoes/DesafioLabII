package Etapa3;

import java.util.Arrays;

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
        return top + 1;
    }

    @Override
    public void push(E element) throws OverflowException {
        if(isFull()) {
            throw  new OverflowException();
        }
        elements[++top] = element;
    }

    @Override
    public E pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        E element = (E) elements[top];
        elements[top--] = null;
        return element;
    }

    @Override
    public E top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return (E) elements[top];
    }

    @Override
    public String toString() {
        return "StaticStack{" +
                "top=" + top +
                ", elements=" + Arrays.toString(elements) +
                ", maxSize=" + maxSize +
                '}';
    }
}
