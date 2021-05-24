package Exercise3_4;

import java.util.*;

/**
 * Created by Miguel Emmara - 18022146
 */
public class BinarySearchList {
    static void binarySearch(ListIterator<Integer> iterator, int length, int target, char dir) {
        int cur;

        // End case for 0 items in list
        if (length == 0)
            return;

        int h = length / 2; // Half / Mid Point

        // If dir is R move right
        if (dir == 'R') {
            System.out.println("\nMove " + h + " positions to right");
            for (int i = 1; i < h; i++) {
                iterator.next();
            }
            cur = iterator.next();

        } else {
            System.out.println("\nMove " + h + " positions to left");
            for (int i = 1; i < h; i++) {
                iterator.previous();
            }
            cur = iterator.previous();
        }

        System.out.println("Compare " + cur + " and " + target);
        if (cur == target) {
            System.out.println("\n\tItem found");

            // If current is less than item
        } else if (cur < target) {
            if (h != 0) {
                //change direction from left to right
                //continue search in right
                if (dir == 'R') {

                } else {
                    iterator.next();
                }
                binarySearch(iterator, length - h, target, 'R');
            }
            System.out.println("\n\tNot Found");
        } else {
            if (h != 0) {
                //change direction from right to left
                //continue search in left
                if (dir == 'L') {

                } else {
                    iterator.previous();
                }
                binarySearch(iterator, length - h, target, 'L');
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean stop = false;
        int item = 0;
        System.out.println("Initiating Arraylist");

        System.out.print("List: ");
        for (int i = 1; i <= 10; i++) {
            System.out.print((10 * i) + " ");
            list.add(10 * i);
        }

        do {
            try {
                System.out.print("\n\nPlease Input Number To Search: ");
                item = scanner.nextInt();
                scanner.nextLine();
                stop = true;

            } catch (InputMismatchException e) {
                System.out.println("Please Input A Valid Number");
                scanner.nextLine();
            }
        } while (!stop);

        int length = list.size();
        ListIterator<Integer> iterator = list.listIterator(); //list iterator
        //call the binary search method
        binarySearch(iterator, length, item, 'R');
    }
}