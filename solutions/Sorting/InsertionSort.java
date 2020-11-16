package Sorting;

import java.util.Arrays;

public class InsertionSort {
  public static void main(String[] args) {
    int[] arr = { 4, 3, 2, 10, 12, 1, 5, 6 };
    System.out.println(Arrays.toString(insertionSort(arr)));
  }

  public static int[] insertionSort(int[] list) {
    for (int i = 1; i < list.length; i++) {
      int key = list[i];
      int j = i - 1;
      while (j >= 0 && key < list[j]) {
        int temp = list[j];
        list[j] = list[j+1];
        list[j+1] = temp;
        j--;
      }
    }
    return list;
  }
}