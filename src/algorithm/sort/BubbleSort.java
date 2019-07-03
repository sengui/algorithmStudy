package algorithm.sort;

/**
 * Bubble Sort
 * example: Ascending
 *
 */
public class BubbleSort {

    public int[] bubbleSort(int[] array){
        int length = array.length;
        int n;
        for (int i = 0; i < length - 1; i++){
            for (int j = 0; j < length -1 -i; j++){
                if (array[j+1] < array[j]){
                    n = array[j];
                    array[j] = array[j+1];
                    array[j+1] = n;
                }
            }
        }
        return array;
    }
}
