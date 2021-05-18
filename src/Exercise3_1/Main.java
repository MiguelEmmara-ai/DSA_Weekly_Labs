package Exercise3_1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Miguel Emmara
 */
public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        int item;
        int popItem;
        int peekItem;
        boolean stop = false;

        System.out.println("# Array Stack Tester #\n");
        System.out.println("Enter your choice ");
        do {
            try {
                System.out.println("" +
                        "\t1. Push" +
                        "\n\t2. Pop" +
                        "\n\t3. Peek" +
                        "\n\t4. Print" +
                        "\n\t5. Exit");
                System.out.print("\nAnswer> ");
                int userInput = scanner.nextInt();
                scanner.nextLine();

                switch (userInput) {
                    case 1:
                        System.out.print("\nItem To Push: ");
                        item = scanner.nextInt();
                        scanner.nextLine();
                        arrayStack.push(item);
                        break;
                    case 2:
                        try {
                            popItem = arrayStack.pop();
                            System.out.println("\nPopped Item: [" + popItem + "]");
                        } catch (Exception e) {
                            System.out.println("\nStack is empty!");
                        }
                        break;
                    case 3:
                        try {
                            peekItem = arrayStack.peek();
                            System.out.println("\nPeek Item: [" + peekItem + "]");
                        } catch (Exception e) {
                            System.out.println("\nStack is empty!");
                        }
                        break;
                    case 4:
                        System.out.println("\n" + arrayStack);
                        break;
                    case 5:
                        System.out.println("\nGood Bye!");
                        stop = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Please Input Correct Number");
                scanner.nextLine();
            }
        } while (!stop);

    }
}
