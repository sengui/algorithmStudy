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
     