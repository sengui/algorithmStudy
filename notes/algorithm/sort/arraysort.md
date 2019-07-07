# 排序算法比较

## 1. 冒泡排序 （Bubble Sort）
  冒泡排序是一种简单的排序，它重复的遍历数列中的所有元素。每相邻两个记录关键字比较大小，
大的记录下沉(也可以小的上浮)。每一遍把最后一个下沉的位置记下，下一遍只需检查比较到止为止，
到所有记录都不发生下沉时，整个过程结束。

1. 算法描述  
   * 比较相邻的元素。如果第一个比第二个大（小），就交换它们两个；
   * 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大(小)的数；
   * 针对所有的元素重复以上的步骤，除了最后已排好的元素；
   * 重复步骤1~3，直到排序完成。
   
2. 动图演示

  ![bubble sort](img/bubbleSort.gif)  
    
  ![bubble sort](img/bubbleSort2.gif)
 
3. 代码实现
 ```java
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
```

## 2. 选择排序（Selection Sort）
  选择排序是从待排序序列中选取一个关键字最小的元素，把它与第一个记录交换存储位置，使之成为有序。然后在余下的无序记录中，
再选出关键字最小的元素与无序区中第一个元素交换位置，又使它成为有序。以此类推，直到完成整个排序。

1. 算法描述  
    * 初始状态：整个数组r划分成两个部分，即有序区（初始为空）和无序区
    * 基本操作：从无序区中选择关键字值最小的记录，将其与无序区的第一个记录交换位置（实质是添加到有序区尾部）。
    * 从初态（有序区为空）开始，重复步骤（2），直到终态（无序区为空）。  
  
2.   
  ![selection sort](img/selectionSort.gif)
  
  ![selection sort](img/selectionSort2.gif)
  
3. 代码实现  
```java
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
```  

## 3. 插入排序（Insertion Sort）
  插入排序工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。

1. 算法描述
    * 从第一个元素开始，该元素可以认为已经被排序
    * 取出下一个元素，在已经排序的元素序列中从后向前扫描
    * 如果该元素（已排序）大于新元素，将该元素移到下一位置
    * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
    * 将新元素插入到该位置
    * 重复步骤2~5
  
2. 动图演示

  ![insertion sort](img/insertionSort.gif)
  
3. 代码实现
```java
public class InsertionSort {
    
    public int[] insertionSort(int[] arr){
        int len = arr.length;
        int preIndex;
        int current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }
}
```

## 4. 希尔排序（Shell Sort）
  希尔排序又称缩小增量排序，它也是一种插入排序的方法，但是在时间上比直接插入排序有较大的改进。

1. 算法描述   
 先将整个待排序的记录序列分割成若干个子序列分别进行直接插入排序，具体算法描述
    * 选择一个增量序列t1, t2, ... ,tk, 其中ti > tj, tk=1
    * 按增量序列个数k, 对序列进行k趟排序
    * 每趟排序，根据对应的增量ti, 将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
  
2. 动图演示
 
  ![Shell Sort](img/shellSort.gif)
  
3. 代码实现
```java
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
```

## 5. 快速排序 （Quick Sort）
  就排序时间而言，快速排序被认为是一种最好的内部排序方法。其基本思想：任取待排序序列中的某个元素作为基准，
通过一趟快速排序将待排序的元素分割成左右两个子序列，其中左子序列元素的排序关键字均比基准（也称枢轴）元素的关键字值小；
右子序列元素的关键字均比基准元素的关键字大，基准元素得到了它在整个序列中的最终位置并存放好，这个过程称为一趟快速排序。
第二趟再分别对分割成左右两部分的子序列，进行快速排序，这两个部分子序列中的枢轴元素也得到了最终在序列中的位置而被存放好，
并且它们又分别分割出左右独立的两个子序列。显然，这是一个递归的过程，不断地进行下去，直到每个待排序的子序列中只有一个记录为止，
整个排序过程结束。快速排序是对冒泡排序的一种改进。

1. 算法描述   
设待排序序列的下界和上界分别为 low 和 high，R[low]是枢轴元素，快速排序的具体过程如下：
    * 首先将R[low]中的记录保存到pivot变量中，用两个整型变量i，j分别指向 low和 high所在位置上的记录。
    * 先从j所指出的记录起自右向左逐一将关键字和pivot.key 进行比较，当找到第1个关键字小于pivot.key记录时，将
  此记录复制到i所指的位置上去。
    * 然后从i+1所指的记录起自左向右逐一将关键字和pivot.key进行比较，当找到第1个关键字大于pivot.key的记录时，
  将该记录复制到j所指的位置上去。
    * 接着再从j-1 所指的记录重复以上的(2)、（3）两步，直到 i=j为止，此时将pivot中的记录放回到i（或j）的位置上，
  一趟快速排序完成。
  * 再以上面i为界限的左右两个序列重复以上的动作，使其每个序列完成快速排序，直到每个子序列只有一个记录时，整个快速排序完成。
  
2. 动图演示

  ![Quick Sort](img/quickSort.gif)
  
3. 代码实现
```java
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
```