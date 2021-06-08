package Exercise4_4;

import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Miguel Emmara - 18022146
 */
public class Task<E> {
    private final E element;
    private final int priority;

    //constructor
    public Task(E e, int p) {
        element = e;
        priority = p;
    }

    //return the element
    public E getElement() {
        return element;
    }

    //return the priority
    public int getPriority() {
        return priority;
    }
}

// Class to compare Task by priority
class TaskCompare<E> implements Comparator<Task<E>> {
    //method to compare two Task objects by priority
    public int compare(Task<E> t1, Task<E> t2) {
        return Integer.compare(t1.getPriority(), t2.getPriority());
    }
}

//class PriorityQueue
class PriorityQueue<E> {
    Task<E>[] pq;
    int size;
    TaskCompare<E> tCompare = new TaskCompare<>();

    //constructor
    @SuppressWarnings("unchecked")
    public PriorityQueue() {
        size = 0;
        pq = (Task<E>[]) new Task<?>[10];
    }

    //enqueue to the PriorityQueue
    public void enqueue(Task<E> task) {
        int i = size;
        pq[i] = task;

        while (i > 0) {
            if (tCompare.compare(pq[i], pq[(i - 1) / 2]) < 0) {
                Task<E> t = pq[(i - 1) / 2];
                pq[(i - 1) / 2] = pq[i];
                pq[i] = t;
            }
            i = (i - 1) / 2;
        }
        size++;
    }

    //dequeue from the PriorityQueue
    public Task<E> dequeueMin() {
        int i = size;
        if (i == 0) return null;

        Task<E> out = pq[0];

        if (i == 1) {
            size = 0;
            return out;
        }

        pq[0] = pq[i - 1];
        size--;
        i = 0;
        while (2 * i < size - 1) {
            int m = 2 * i + 1;
            if (tCompare.compare(pq[m], pq[m + 1]) > 0)
                m++;
            if (tCompare.compare(pq[i], pq[m]) > 0) {
                Task<E> t = pq[m];
                pq[m] = pq[i];
                pq[i] = t;
            }
            i = m;
        }

        return out;
    }

    //return the minimum
    public Task<E> findMin() {
        return pq[0];
    }

    //print priority queue
    public void print() {
        for (int i = 0; i < size; i++)
            System.out.print(pq[i].getElement() + ":" + pq[i].getPriority() + " ");
        System.out.println();
    }
}


//class Driver
class Driver {
    //main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        Task<Integer> t1 = new Task<>(1, 20);
        Task<Integer> t2 = new Task<>(2, 19);
        Task<Integer> t3 = new Task<>(3, 18);
        Task<Integer> t4 = new Task<>(4, 17);
        Task<Integer> t5 = new Task<>(5, 10);

        //some enqueue operation
        priorityQueue.enqueue(t1);
        priorityQueue.print();
        priorityQueue.enqueue(t2);
        priorityQueue.print();
        priorityQueue.enqueue(t3);
        priorityQueue.print();
        priorityQueue.enqueue(t4);
        priorityQueue.print();
        priorityQueue.enqueue(t5);
        priorityQueue.print();

        //delete the minimum
        Task<Integer> out = priorityQueue.dequeueMin();
        System.out.println(out.getElement() + " is removed");
        priorityQueue.print();
    }
}