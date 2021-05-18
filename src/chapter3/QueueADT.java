package chapter3;

/**
 * An interface that defines the abstract data type
 * for a queue collection of elements with type E
 */

import java.util.NoSuchElementException;

public interface QueueADT<E> {
    // adds one element to the rear of this queue
    void enqueue(E element);

    // removes and returns the front element of the queue
    E dequeue() throws NoSuchElementException;

    // returns without removing the front element of this queue
    E first() throws NoSuchElementException;

    // returns true if this queue contains no elements
    boolean isEmpty();

    // returns the number of elements in this queue
    int size();
}
