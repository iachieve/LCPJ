package Sorting;

public class SelectionSort {
  public void selectionSort(int[] list){
    for (int i = 0; i < list.length; i++) {
      int minVal = list[i];
      int minIdx = i;
      for (int j = i; j < list.length; j++) {
        if(list[j] < minVal){
          minVal = list[j];
          minIdx = j;
        }
      }

      if(minVal < list[i]){
        int temp = list[i];
        list[i] = list[minIdx];
        list[minIdx] = temp;
      }

    }
    
  }
}
