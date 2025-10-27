package Etapa3;

public class StaticStack<E> implements Stack<E> {
    private int top;
    private E[] elements;
    private int maxSize;

    @SuppressWarnings("unchecked")
    public StaticStack(int maxSize) {
        this.maxSize = maxSize;
        this.elements = (E[]) new Object[maxSize];
        this.top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }

    @Override
    public int numElements() {
        return top + 1;
    }

    @Override
    public void push(E element) throws OverflowException {
        if (isFull()) {
            throw new OverflowException();
        }
        elements[++top] = element;
    }

    @Override
    public E pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        E element = elements[top];
        elements[top--] = null;
        return element;
    }

    @Override
    public E top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return elements[top];
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(elements[i]);
            if (i < top) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}