package LinkedList;

public interface Linked<E> {
    void addHead(E e);
    void addTail(E e);
    void add(E e, int index);

    int size();
    E getElByIndex(int index);
}
