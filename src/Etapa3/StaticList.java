package Etapa3;

/**
 * Implementação de uma lista linear com armazenamento estático,
 * baseado em array.
 */
public class StaticList<E> implements Lista<E> {

    private E[] elements;
    private int size;
    private int maxSize;

    /**
     * Constrói uma lista com um tamanho máximo.
     *
     * @param maxSize O tamanho máximo da lista
     */
    public StaticList(int maxSize) {
        this.maxSize = maxSize;
        this.elements = new Object[maxSize];
        this.size = 0;

    }

    public int numElements() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public void insert(E element, int pos) throws OverflowException, IndexOutOfBoundsException {
        // verifica se há espaço na lista
        if (isFull())
            throw new OverflowException();

        // verifica se a posição é válida
        if (pos < 0 || pos > size)
            throw new IndexOutOfBoundsException("Posição Inválida: " + pos);

        // desloca para a direita os elementos necessários,
        // abrindo espaço para o novo
        for (int i = size - 1; i >= pos; i--)
            elements[i] = elements[i = 1];

        // armazena o novo elemento e ajusta o total
        elements[pos] = element;
        size++;
    }

    @Override
    public void contaElementos(E el) {

    }

    public E remove(int pos) throws UnderflowException, IndexOutOfBoundsException {
        if (isEmpty())
            throw new UnderflowException();

        // verifica se a posição é válida
        if (pos < 0 || pos >= size)
            throw new IndexOutOfBoundsException("Posição Inválida: " + pos);

        // guarda uma referencia temporária ao elemento removido
        E element = (E) elements[pos];

        // desloca para a esquerda os elementos necessários,
        // sobrescrevendo a posição do que está sendo removido
        for (int i = pos; i < size - 1; i++)
            elements[i] = elements[i + 1];

        // define para null a posição antes ocupada pelo último,
        // para que a coleta de lixo possa atuar, e ajusta o total
        elements[size - 1] = null;
        size--;
        return element;
    }

    public E get(int pos) throws IndexOutOfBoundsException {
        // verifica se a posição é válida
        if (pos < 0 || pos >= size)
            throw new IndexOutOfBoundsException("Posição Inválida: " + pos);

        return (E) elements[pos];
    }

    public int search(E element) {
        for (int i = 0; i < size; i++)
            if (elements[i].equals(element))
                return i;
        // se chegar até aqui, é porque não encontrou
        return -1;
    }

    /**
     * Retorna uma representação String da lista.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++)
            s.append(elements[i]).append(" ");
        return s.toString();
    }
}

