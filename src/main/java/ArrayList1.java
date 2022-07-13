import java.util.*;
import java.util.function.UnaryOperator;

public class ArrayList1<E> implements List<E> {
    private final int INITIAL_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private int size;
    private E[] elements;

    public ArrayList1() {
        this.elements = (E[]) new Object[INITIAL_CAPACITY];
    }


    public ArrayList1(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elements = (E[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elements = (E[]) EMPTY_ELEMENTDATA;
        }
    }

    public ArrayList1(Collection<? extends E> c) {
        E[] a = (E[]) c.toArray();
        if ((size = a.length) != 0) {
            if (c.getClass() == ArrayList1.class) {
                elements = a;
            } else {
                elements = (E[]) Arrays.copyOf(a, size, Object[].class);
            }
        }
    }

    private void grow() {
        if (size == elements.length) {
            int oldCapacity = elements.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            Object[] enlargedElements = new Object[newCapacity];
            System.arraycopy(elements, 0, enlargedElements, 0, elements.length);
            elements = (E[]) enlargedElements;
        }
    }

    @Override
    public E set(int index, E element) {
        E temp = elements[index];
        elements[index] = element;
        return temp;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public boolean add(E e) {
        grow();
        elements[size++] = e;
        return true;
    }

    @Override
    public void add(int index, E element) {
        grow();
        if (index == size) {
            add(element);
        } else {
            Object[] largerElements = new Object[elements.length];
            System.arraycopy(elements, 0, largerElements, 0, index);
            largerElements[index] = element;
            System.arraycopy(elements, index, largerElements, index + 1, size - index);
            elements = (E[]) largerElements;
            size++;
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        Object[] largerElements;
        int tempIndex = index;
        if (c.size() > elements.length - size) {
            largerElements = new Object[size + c.size()];
        } else {
            largerElements = new Object[elements.length];
        }
        System.arraycopy(elements, 0, largerElements, 0, index);
        for (Object o : c) {
            grow();
            largerElements[index++] = o;
            size++;
        }
        System.arraycopy(elements, tempIndex, largerElements, tempIndex + c.size(), size - tempIndex);
        elements = (E[]) largerElements;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object es = c.toArray();
        for (E el : c) {
            grow();
            elements[size++] = el;
        }
        return true;
    }

    @Override
    public E remove(int index) {
        E temp = elements[index];
        if (index == size){
            elements[index] = null;
        } else {
            Object[] tempElements = new Object[elements.length];
            System.arraycopy(elements,0,tempElements,0,index);
            System.arraycopy(elements, index + 1, tempElements, index, size - index - 1);
            size--;
            elements = (E[]) tempElements;
        }
        return  temp;
    }

    @Override
    public boolean remove(Object o) {
        for( int i = 0; i < elements.length; i++) {
            if (elements[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean temp;
        for (Object o : c) {
            temp = remove(o);
            if (!temp) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int countOfRemovedElements = 0;
        for (Object o : elements) {
            if(c.contains(o)) {
                continue;
            }
            remove(o);
            countOfRemovedElements++;
        }
        return  countOfRemovedElements > 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int indexOf(Object o) {
        return indexOfRange((E) o, 0, size);
    }

    @Override
    public int lastIndexOf(Object o) {
        return lastIndexOfRange((E) o, 0, size);
    }

    public int indexOfRange(E o, int start, int end) {
        if (o == null) {
            for (int i = start; i <= end; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i <= end; i++) {
                if (elements[i].equals(o)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOfRange(E o, int start, int end) {
        if (o == null) {
            for (int i = end; i >= start; i--) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = end; i >= start; i--) {
                if (elements[i].equals(o)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        List<E> a = new ArrayList1<>(toIndex - fromIndex);
        for (int i = 0; i < toIndex - fromIndex; i++) {
            a.add(elements[fromIndex++]);
        }
        return a;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public void clear() {
        final Object[] es = elements;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    /* not implemented methods*/

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        System.out.println("it will be working soon!;)");
    }

    @Override
    public void sort(Comparator<? super E> c) {
        System.out.println("it will be working soon!;)");
    }

    @Override
    public Spliterator<E> spliterator() {
        return List.super.spliterator();
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }
}
