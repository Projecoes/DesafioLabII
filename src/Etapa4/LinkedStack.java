package Etapa4;

public class LinkedStack<E> implements Stack<E> {

    private Node<E> top;
    private int size;

    public LinkedStack(){
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
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
    public void push(E element) throws OverflowException {
        Node<E> novoNode = new Node<>(element);
        novoNode.setNext(top);
        top = novoNode;
        size++;

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
