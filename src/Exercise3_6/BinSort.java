package Exercise3_6;

import java.util.Arrays;

/**
 * Class which demonstrates how bin sort can be used to
 * sort distinct integer numbers between 0 and MAX_VALUE
 */
public class BinSort {
    public static void main(String[] args) {
        // Distinct integer values between 0 and MAX_VALUE
        int[] list = {17, 2, 23, 7, 41, 29, 19, 43, 31, 5, 11, 47, 13, 3, 37, 100, 50, 7};
        final int MAX_VALUE = 100;
        boolean[] flags = new boolean[MAX_VALUE + 1]; //initially all false
        // determine which bins should be set to true
        list = binSort(list);
        System.out.println(Arrays.toString(list));
    }

    private static void binSort(int[] list, boolean[] flags) {
        for (int value : list) flags[value] = true;
        // use the flags to put the numbers back in the list sorted
        int flagNo = 0;
        for (int i = 0; i < list.length; i++) {  // find the next flag that is true
            while (flagNo < flags.length && !flags[flagNo])
                flagNo++;
            list[i] = flagNo++;
        }
        // output the results
        for (int i = 0; i < list.length; i++)
            System.out.print(((i > 0) ? ", " : "") + list[i]);
        System.out.println();
    }

    private static int[] binSort(int[] arr) {
        int[] bin = new int[100 + 1];
        int[] bin_sorted_arr = new int[arr.length];
        for (int value : arr) bin[value]++;
        int pos = 0;
        for (int i = 0; i < bin.length; i++)
            for (int j = 0; j < bin[i]; j++)
                bin_sorted_arr[pos++] = i;
        return bin_sorted_arr;
    }
}
