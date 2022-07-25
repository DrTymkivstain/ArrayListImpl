package LinkedList;

public interface Linked<E> {
    void addHead(E element);
    void addTail(E element);
    void add(E element, int index);
    boolean remove(E element);

    int size();
    E getElByIndex(int index);
}
