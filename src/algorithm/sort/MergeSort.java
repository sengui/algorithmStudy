package algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    public int[] mergeSort(int[] array) {
        int[] tempArr = new int[array.length];
        mergeSort(array, tempArr,0 , array.length - 1);
        return array;
    }

    private void mergeSort(int[] arr, int[] tempArr, int l, int h) {
        if (l < h) {
            int mid = (l + h)/2;
            mergeSort(arr, tempArr, l, mid);//归并左序列
            mergeSort(arr, tempArr, mid + 1, h);//归并右序列
            merge(arr, tempArr, l, mid, h);
        }
    }

    // 进行一趟归并，2-路归并
    private void merge(int[] arr, int[] tempArr, int l, int mid, int h) {
        int i = l;
        int j = mid + 1;
        int k = l;
        while (i <= mid && j <= h) {
            tempArr[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            tempArr[k++] = arr[i++];
        }
        while (j <= h) {
            tempArr[k++] = arr[j++];
        }
        for (i = l; i <= h; i++) {
            arr[i] = tempArr[i];
        }
    }
}
