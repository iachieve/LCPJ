package Sorting;

/**
 * BubbleSort
 */
public class BubbleSort {

  public int[] bubbleSort(int[] list) {
    for (int i = 0; i < list.length; i++) {
      for (int j = i + 1; j < list.length - 1 - i; j++) {
        if (list[j] < list[j + 1]) {
          int temp = list[j + 1];
          list[j + 1] = list[j];
          list[j] = temp;
        }
      }
    }
    return list;
  }

}