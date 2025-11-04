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
        Node<E> novoNode = new Node<>(element);
        if (isEmpty()) {
            front = novoNode;
        }else {
            back.setNext(novoNode);
        }
        back = novoNode;
        size++;
    }

    @Override
    public E dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        E element = front.getElement();
        if (front == null) {
            back = null; //fila vazia
        }
        size--;
        return element;
    }

    @Override
    public E front() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return front.getElement();
    }

    @Override
    public E back() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return back.getElement();
    }

    public E first() throws UnderflowException {
        if(isEmpty()) {
            throw new UnderflowException();
        }
        return front.getElement();
    }
}
