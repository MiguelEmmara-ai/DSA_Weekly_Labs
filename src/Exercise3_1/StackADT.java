package Exercise3_1;

import java.util.NoSuchElementException;

/**
 * @author Andrew Ensor
 * <p>
 * Miguel Emmara - 18022146
 */
public interface StackADT<E> {
    // adds one element to the top of this stack
    void push(E element);

    // removes and returns the top element from this stack
    E pop() throws NoSuchElementException;

    // returns without removing the top element of this stack
    E peek() throws NoSuchElementException;

    // returns true if this stack contains no elements
    boolean isEmpty();

    // returns the number of elements in this stack
    int size();
}
