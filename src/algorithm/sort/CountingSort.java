package algorithm.sort;

import java.util.Arrays;

public class CountingSort {

    public int[] countingSort(int[] array) {
        int[] exArr = new int[100000];
        int len = array.length;
        int sortIndex = 0;

        for (int i = 0; i < len; i++) {
            exArr[array[i] + 50000]++;
        }

        for (int i = 0; i < exArr.length; i++) {
            while (exArr[i] > 0 && sortIndex < len) {
                array[sortIndex++] = i - 50000;
                exArr[i]--;
            }
        }

        return array;
    }
}
