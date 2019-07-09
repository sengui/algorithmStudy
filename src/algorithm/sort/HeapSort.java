package algorithm.sort;

import java.util.Arrays;

public class HeapSort {

    public int[] heapSort(int[] array) {
        int length = array.length - 1;
        //建立大顶堆
        for (int i = parent(length); i >= 0; i--) {
            heapAdjust(array, i, length);
        }

        for (int i = length; i > 0; i--) {
            //交换堆顶元素到数组最后面
            swap(array, 0, i);
            //调整大顶堆
            heapAdjust(array, 0, i - 1);
        }
        return array;
    }

    //调整s结点下面树分支满足大顶堆条件
    private void heapAdjust(int[] arr, int s, int length) {
        int max = arr[s];
        //s 的左子结点
        int k = left(s);
        //判断k是否在调整范围内
        while (k <= length) {
            //判断k作为左结点时，右结点是否存在。并比较两个结点最大的值
            if (k + 1 <= length && arr[k] < arr[k + 1]) {
                k = k + 1;
            }

            //子结点是否比父结点大
            if (arr[s] < arr[k]) {
                //交换结点
                swap(arr, s, k);
                //保存新的父结点
                s = k;
            }else {
                break;
            }
            k = left(k);
        }
        arr[s] = max;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //父节点
    private int parent(int i) {
        return (i - 1) / 2;
    }

    //左子结点
    private int left(int i) {
        return 2 * i + 1;
    }

}
