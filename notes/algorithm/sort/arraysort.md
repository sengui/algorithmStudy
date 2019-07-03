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

     