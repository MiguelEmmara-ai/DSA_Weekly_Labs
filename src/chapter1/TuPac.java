package chapter1;


import java.util.Random;

/**
 * @author sehall
 */
public class TuPac implements Runnable {
    private final Object monitor;
    private final Random gen;
    private final boolean starts;
    public boolean requestStop;

    public TuPac(Object monitor, boolean starts) {   //think of Monitor like a Microphone, only 1 rapper can use it
        this.monitor = monitor;
        this.starts = starts;
        gen = new Random();
    }

    @Override
    public void run() {
        requestStop = false;
        if (!starts) {
            synchronized (monitor) {
                try {
                    System.out.println("----TUPAC IS WAITING----");
                    monitor.wait();
                } catch (InterruptedException ex) {
                }
            }
        }
        while (!requestStop) {
            int x = gen.nextInt(10) + 3;
            for (int i = 0; i < x; i++) {
                System.out.println("TUPAC: Rapping, trading insults and throwing gang signs");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                }
            }
            synchronized (monitor) {
                try {
                    monitor.notify();
                    System.out.println("-------TUPAC IS WAITING-------");
                    monitor.wait();
                } catch (InterruptedException ex) {
                }
                System.out.println("-------TUPACS TURN TO RAP-------");
            }
        }
    }
}
