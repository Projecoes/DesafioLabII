package Etapa3;

public class StaticList<E> implements Lista<E> {
    private E[] elements;
    private int size;
    private int maxSize;

    @SuppressWarnings("unchecked")
    public StaticList(int maxSize) {
        this.maxSize = maxSize;
        this.elements = (E[]) new Object[maxSize];
        this.size = 0;
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public void insert(E element, int pos) {
        if (isFull()) {
            throw new OverflowException();
        }
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Posição inválida: " + pos);
        }

        // Desloca elementos para a direita
        for (int i = size; i > pos; i--) {
            elements[i] = elements[i - 1];
        }

        elements[pos] = element;
        size++;
    }

    @Override
    public E remove(int pos) {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida: " + pos);
        }

        E element = elements[pos];

        // Desloca elementos para a esquerda
        for (int i = pos; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[size - 1] = null;
        size--;
        return element;
    }

    @Override
    public E get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida: " + pos);
        }
        return elements[pos];
    }

    @Override
    public int contaElementos(E el, int index) {
        return contaElementosRecursivo(el, 0);
    }

    @Override
    public int search(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] != null && elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    // Método privado recursivo
    private int contaElementosRecursivo(E el, int index) {
        // Caso base: chegou ao final da lista
        if (index >= size) {
            return 0;
        }

        // Verifica se o elemento atual é igual ao procurado
        int count = 0;
        if (elements[index] != null && elements[index].equals(el)) {
            count = 1;
        }

        // Chamada recursiva para o próximo elemento
        return count + contaElementosRecursivo(el, index + 1);
    }
}