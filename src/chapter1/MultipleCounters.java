package chapter1;

/**
 * A class which demonstrates how threads are created
 */

public class MultipleCounters {
    public static void main(String[] args) {  // create three threads
        Counter counterA = new Counter("A", 20);
        Counter counterB = new Counter("B", 20);
        Counter counterC = new Counter("C", 20);
        Thread threadA = new Thread(counterA);
        Thread threadB = new Thread(counterB);
        Thread threadC = new Thread(counterC);
        threadC.setPriority(Thread.NORM_PRIORITY + 2); // higher priority
        // start the three threads
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

// a class that represents a counter
class Counter implements Runnable {
    private final String name;
    private final int maxCounts;

    public Counter(String name, int maxCounts) {
        this.name = name;
        this.maxCounts = maxCounts;
    }

    public void run() {
        for (int i = 0; i < maxCounts; i++) {
            System.out.print("Counter " + name + " is " + i + ", ");
            System.out.println("Counter " + name + " about to loop");
        }
    }
}
