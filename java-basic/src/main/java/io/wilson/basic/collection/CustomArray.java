package io.wilson.basic.collection;

import lombok.SneakyThrows;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

/**
 * @author Wilson-He
 * @date 2020/6/4
 */
public class CustomArray<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
    final ReentrantLock lock = new ReentrantLock();
    private transient volatile Object[] array;

    public CustomArray() {
        this.array = new Object[0];
    }

    @Override
    @SneakyThrows
    public boolean add(E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Thread.sleep(1000);
            System.out.println("write thread:" + Thread.currentThread().getId() + " , add: " + e);
            Object[] elements = getArray();
            int len = elements.length;
            Object[] newElements = Arrays.copyOf(elements, len + 1);
            newElements[len] = e;
            setArray(newElements);
            return true;
        } catch (Exception ex){

        } finally{
            lock.unlock();
        }
        return false;
    }

    public E[] getArray() {
        return (E[]) this.array;
    }

    /**
     * Sets the array.
     */
    final void setArray(Object[] a) {
        array = a;
    }

    @Override
    @SneakyThrows
    public void forEach(Consumer<? super E> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        Object[] elements = getArray();
        int len = elements.length;
        for (int i = 0; i < len; ++i) {
            @SuppressWarnings("unchecked") E e = (E) elements[i];
            action.accept(e);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(getArray());
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    private E get(Object[] a, int index) {
        return (E) a[index];
    }

    @Override
    public E get(int index) {
        return get(getArray(), index);
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        final ReentrantLock lock = this.lock;
        System.err.println("remove " + index);
        lock.lock();
        try {
            Object[] elements = getArray();
            int len = elements.length;
            E oldValue = get(elements, index);
            int numMoved = len - index - 1;
            if (numMoved == 0) {
                setArray(Arrays.copyOf(elements, len - 1));
            } else {
                Object[] newElements = new Object[len - 1];
                System.arraycopy(elements, 0, newElements, 0, index);
                System.arraycopy(elements, index + 1, newElements, index,
                        numMoved);
                setArray(newElements);
            }
            return oldValue;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
