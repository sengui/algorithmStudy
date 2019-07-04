package algorithm.sort;

public class SelectionSort {

    public int[] SelectionSort(int[] array){
        int min;
        int n;
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]){
                    min = j;
                }
            }
            if (min != i) {
                n = array[min];
                array[min] = array[i];
                array[i] = n;
            }

        }
        return array;
    }
}
