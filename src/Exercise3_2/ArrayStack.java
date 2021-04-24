package Exercise3_2;

/**
 * Created by Miguel Emmara
 */
public class ArrayStack<E> implements QueueADT <E>{
    private static final int INIT_SIZE = 0;
    private int front;
    private int rear;
    private int size;
    private E[] array;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.array = (E[]) new Object[INIT_SIZE];
    }

    // This function is used to insert an element into the circular queue. In a circular queue,
    // the new element is always inserted at Rear position.
    @Override
    public void enqueue(E element) {
        // Condition if queue is full.
        if(size() == array.length) {
            expandCapacity();
        }
        size++;
        array[rear] = element;
        rear = size;
    }

    @Override
    public E dequeue() {
        if(front == -1) {
            System.out.print("Queue is Empty");
            return null;
        }
        E result = array[front];
        array[front] = null;
        front = (front+1) % array.length;
        size--;

        return result;
    }

    @Override
    public E first() {
        if (isEmpty())
            System.out.println("Queue is Empty");

        return array[front];
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public int size() {
        return this.size;
    }

    /*
     * to expand the capacity of the array if the array reaches it maximum capacity
     * this doubles the capacity of the array.
     */
    @SuppressWarnings("unchecked")
    public void expandCapacity() {
        E[] temp = (E[]) new Object[(size + 1)];
        if (size >= 0) {
            System.arraycopy(array, 0, temp, 0, size);
            array = temp;
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(array[(front + i) % array.length]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        ArrayStack <Integer> arrayStack = new ArrayStack <> ();
        arrayStack.enqueue(1);
        arrayStack.enqueue(2);
        arrayStack.enqueue(3);
        arrayStack.enqueue(4);
        arrayStack.enqueue(5);

        System.out.println(arrayStack);
    }
}
