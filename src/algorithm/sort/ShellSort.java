package algorithm.sort;

public class ShellSort {

    public int[] shellSort(int[] array) {
        int n;
        int j;
        int len = array.length;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                j = i - gap;
                while (j >= 0) {
                    if (array[j] > array[j + gap]) {
                        n = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = n;
                        j -= gap;
                    }else {
                        break;
                    }
                }
            }
        }
        return array;
    }
}
