package algorithm.sort;

public class QuickSort {

    public int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left < right) {
            //进行一趟快速排序，并返回最终枢轴所指的位置
            int pivotpos = partition(array, left, right);
            //将左序列进行快速排序
            quickSort(array, left, pivotpos - 1);
            //将右序列进行快速排序
            quickSort(array, pivotpos + 1, right);
        }
    }

    private int partition(int[] array, int i, int j) {
        //初始枢轴的值
        int pivot = array[i];
        while (i < j) {
            //找到右序列中小于基准的位置
            while (i < j && array[j] >= pivot) {
                j--;
            }
            //右序列存在小于枢轴的值，将该记录交换到枢轴所指的位置，并将左i+1
            if (i < j) {
                array[i++] = array[j];
            }

            //找到左序列中大于基准的位置
            while (i < j && array[i] <= pivot) {
                i++;
            }
            //左序列中存在大于枢轴的值，将该记录交换到枢轴所指的位置，并将右序列j-1
            if (i < j) {
                array[j--] = array[i];
            }
        }
        array[i] = pivot;
        return i;
    }

}
