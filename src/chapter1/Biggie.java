package chapter1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author sehall
 */
public class Biggie implements Runnable {

    private final Object monitor;
    private final Random gen;
    private final boolean starts;
    public boolean requestStop;

    public Biggie(Object monitor, boolean starts) {   //think of Monitor like a Microphone, only 1 rapper can use it
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
                    System.out.println("-------BIGGIE IS WAITING-------");
                    monitor.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Biggie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        while (!requestStop) {
            int x = gen.nextInt(10) + 3;

            for (int i = 0; i < x; i++) {
                System.out.println("BIGGIE: Rap Rap Rapping, trading insults and throwing gang signs");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                }
            }
            synchronized (monitor) {
                try {
                    System.out.println("-------BIGGIE IS WAITING-------");
                    monitor.notify();
                    monitor.wait();
                } catch (InterruptedException ex) {
                }
                System.out.println("-------BIGGIES TURN TO RAP-------");
            }
        }
    }

}
