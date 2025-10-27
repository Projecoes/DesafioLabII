package Etapa3;
/**
 * Interface que define o comportamento de uma lista linear.
 */
public interface Lista<E> {

    /**
     * Insere um novo elemento na posição indicada.
     * @param element O elemento a ser inserido
     * @param index A posição onde o elemento será inserido
     * 				(iniciando em 0)
     */
    public void insert(E element, int index);

    /**
     * Informa a quantidade de elementos armazenados na lista.
     * @return A quantidade de elementos armazenados na lista.
     */
    public int numElements();

    /**
     * Informa se a lista está vazia.
     * @return Verdadeiro se a lista estiver vazia,
     * 			falso caso contrário.
     */
    public boolean isEmpty();

    /**
     * Informa se a lista está cheia.
     * @return Verdadeiro se a lista estiver cheia,
     * 			falso caso contrário.
     */
    public boolean isFull();



    /**
     * Retorna o elemento da posição indicada, sem removê-lo.
     * @param index A posição do elemento
     * @return O elemento
     */
    public E get(int index);

    int contaElementos(E el, int index);

    /**
     * Remove o elemento da posição indicada.
     * @param index A posição de onde o elemento será removido
     * 				(iniciando em 0)
     * @return O elemento removido
     */
    public E remove(int index);

    int search(E element);
}