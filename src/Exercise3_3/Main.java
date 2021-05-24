package Exercise3_3;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Miguel Emmara - 18022146
 */
public class Main {
    private static final Deque<Integer> deque = new ArrayDeque<>();
    private static final JosephusQueue queue = new JosephusQueue(deque);
    private static final Scanner scanner = new Scanner(System.in, String.valueOf(StandardCharsets.UTF_8));

    public static void main(String[] args) {
        int numElements;
        boolean stop = false;

        do {
            try {
                System.out.print("Enter the number of elements: ");
                numElements = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter the gap between elements: ");
                queue.setGap(scanner.nextInt());
                scanner.nextLine();

                initiateCounting(numElements);

                stop = true;

            } catch (InputMismatchException e) {
                System.out.println("Please Enter a Valid Input!");
                scanner.nextLine();
            }
        } while(!stop);
    }

    private static void initiateCounting(int numElements) {
        for (int i = 0; i < numElements; i++) {
            deque.add(i);
        }

        System.out.println("Time Start!");
        long startTime = System.currentTimeMillis();

        System.out.println("Removal order: " + queue.removeElements());
        long timeTaken = System.currentTimeMillis() - startTime;

        System.out.println("Elapsed time (in ms): " + timeTaken);
    }
}
