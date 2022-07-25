package LinkedList;

import java.util.EventObject;

public class LinkedList1 <E> implements Linked <E>{
    private Node<E> firstNode;
    private Node<E> lustNode;
    private int size;

    public LinkedList1() {
        this.firstNode = new Node<E>(null, null, lustNode);
        this.lustNode = new Node<E>(firstNode, null, null);
    }

    @Override
    public void addHead(E e) {
        Node<E> next = firstNode;
        next.item = e;
        next.next.prev = next;
        firstNode = new Node<>(null, null, next);
        next.prev = firstNode;
        size++;
    }

    @Override
    public void addTail(E e) {
        Node<E> prev = lustNode;
        prev.item = e;
        prev.prev.next = prev;
        lustNode = new Node<>(prev, null, null);
        prev.next = lustNode;
        size++;
    }

    @Override
    public void add(E e, int index) {
        Node<E> currentNode = firstNode.next;
        for (int i = 0; i < index; i++) {
            currentNode = getNextNode(currentNode);
        }
        Node <E> c = new Node<>(currentNode.prev, e, currentNode);
        currentNode.prev.next = c;
        currentNode.prev = c;
    }

    @Override
    public boolean remove(E element) {
        Node<E> currentNode = firstNode.next;
        while (getNextNode(currentNode) != null){
            if(currentNode.item.equals(element)) {
                break;
            } else if (currentNode.next.equals(lustNode)) {
                return  false;
            }
            currentNode = getNextNode(currentNode);
        }
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
        size--;
        return true;
    }

    boolean remove(int index) {
        if (index <= size){
        remove(getElByIndex(index));
        return true;
        }
        return  false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getElByIndex(int index) {
        Node<E> currentNode = firstNode.next;
        for (int i = 0; i < index; i++) {
            currentNode = getNextNode(currentNode);
        }
        return  currentNode.item;
    }

    private Node<E> getNextNode(Node<E> current) {
        return current.next;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
