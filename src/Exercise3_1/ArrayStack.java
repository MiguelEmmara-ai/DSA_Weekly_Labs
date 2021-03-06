package Exercise3_1;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Created by Miguel Emmara - 18022146
 */
public class ArrayStack<E> implements StackADT<E> {
    private final int INITIAL_CAPACITY = 20;
    protected int numElements;
    protected E[] elements;

    // default constructor that creates a new stack
    // that is initially empty
    @SuppressWarnings("unchecked")
    public ArrayStack() {
        numElements = 0;
        elements = (E[]) (new Object[INITIAL_CAPACITY]); // unchecked
    }

    // constructor for creating a new stack which
    // initially holds the elements in the collection c
    public ArrayStack(Collection<? extends E> c) {
        this();
        for (E element : c)
            push(element);
    }

    // Adds one element to the top of this stack
    public void push(E element) {
        if (numElements >= elements.length)
            expandCapacity();
        shiftRight();
        elements[0] = element;
        numElements++;
    }

    // removes and returns the top element from this stack
    public E pop() throws NoSuchElementException {
        if (numElements > 0) {
            E topElement = elements[0];
            shiftLeft();
            elements[numElements - 1] = null;
            numElements--;
            return topElement;
        } else
            throw new NoSuchElementException();
    }

    // returns without removing the top element of this stack
    public E peek() throws NoSuchElementException {
        if (numElements > 0)
            return elements[numElements - 1];
        else
            throw new NoSuchElementException();
    }

    // returns true if this stack contains no elements
    public boolean isEmpty() {
        return (numElements == 0);
    }

    // returns the number of elements in this stack
    public int size() {
        return numElements;
    }

    // returns a string representation of the stack from top to bottom
    public String toString() {
        StringBuilder output = new StringBuilder("[");
        for (int i = numElements - 1; i >= 0; i--) {
            output.append(elements[i]);
            if (i > 0)
                output.append(",");
        }
        output.append("]");
        return output.toString();
    }

    // HELPER //
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        E[] largerArray = (E[]) (new Object[elements.length * 2]); //unchecked
        // copy the elements array to the largerArray
        if (numElements >= 0) System.arraycopy(elements, 0, largerArray, 0, numElements);
        elements = largerArray;
    }

    private void shiftRight() {
        if (numElements + 1 >= 0) System.arraycopy(elements, 0, elements, 1, numElements + 1);
    }

    private void shiftLeft() {
        if (numElements - 1 >= 0) System.arraycopy(elements, 1, elements, 0, numElements - 1);
    }
}