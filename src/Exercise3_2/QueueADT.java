package Exercise3_2;

/**
 * Created by Miguel Emmara
 */
public interface QueueADT<E> {
    void enqueue(E element);

    E dequeue();

    E first();

    boolean isEmpty();

    int size();
}
