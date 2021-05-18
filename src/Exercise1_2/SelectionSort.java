package Exercise1_2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * <h1>Selection Sort</h1>
 *
 * @author Miguel Emmara - 18022146
 */
public class SelectionSort {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int indexMin;
        int operations = 0;

        scanUser(numbers);

        // calculate how long the algorithm takes.
        double startTime = System.currentTimeMillis();

        // DSA manual pg 78
        for (int i = 0; i < numbers.size(); i++) {
            indexMin = i;

            for (int j = i + 1; j < numbers.size(); j++) {
                // If current number in j is smaller, replace the indexMin.
                if (numbers.get(j) < numbers.get(indexMin)) {
                    indexMin = j;
                }
                operations++;
            }

            // Swap the element
            swap(numbers, indexMin, i);

            operations = printSorting(numbers, operations);
        }

        System.out.println("\nTime Taken: " + ((System.currentTimeMillis() - startTime) / 1000.0) + " seconds");
        System.out.printf("%s sorted using %d operation%s when n is %d.\n", numbers, operations, (operations > 1 ? "s" : ""), numbers.size());

        scanner.close();
    }

    private static int printSorting(ArrayList<Integer> numbers, int operations) {
        System.out.println();
        System.out.println("Sorting..." + numbers);
        operations++;
        return operations;
    }

    private static void swap(ArrayList<Integer> numbers, int indexMin, int i) {
        int temp;
        temp = numbers.get(indexMin);
        numbers.set(indexMin, numbers.get(i));
        numbers.set(i, temp);
    }

    private static void scanUser(ArrayList<Integer> numbers) {
        boolean loop;
        do {
            try {
                prompt();
                String numberList = SelectionSort.scanner.nextLine();
                StringTokenizer tokenizeNumberList = new StringTokenizer(numberList, ", ");

                // Convert the string token into an int value and add to arraylist
                while (tokenizeNumberList.hasMoreTokens()) {
                    String token = tokenizeNumberList.nextToken();
                    numbers.add(Integer.parseInt(token));
                }

                loop = true;
            } catch (NumberFormatException e) {
                loop = false;
                numbers.removeAll(numbers);
                prompt();
                SelectionSort.scanner.nextLine();
            }
        } while (!loop);
    }

    private static void prompt() {
        System.out.println("Please enter a list of numbers separated by commas ',':");
        System.out.println("Eg. 10,15,18,22,19,28,53");
        System.out.print("> ");
    }
}
