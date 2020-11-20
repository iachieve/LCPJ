package HeapSort;

import java.util.Arrays;

class Program {

    public static void main(String[] args) {
        int[] array = {8,5,2,9,5,6,3};
        System.out.println(Arrays.equals(heapSort(array), new int[] {2, 3, 5, 5, 6, 8, 9}));
    }
    public static int[] heapSort(int[] array) {
        System.out.println("original array: ");
        System.out.println(Arrays.toString(array));
        buildHeap(array);
        System.out.println("after heap built:");
        System.out.println(Arrays.toString(array));

        for(int end = array.length - 1; end >= 0; end--){
            swap(0, end, array);
            siftDown(0, end - 1, array);
        }
        return array;
    }
    public static void buildHeap(int[] array){
        int p = (array.length - 2) / 2;
        for(int c = p; c >= 0; c--){
            siftDown(c, array.length - 1, array);
        }
    }
    public static void siftDown(int c, int e, int[] array){
        int f = c * 2 + 1;
        while(f <= e){
            int s = c*2+2 <= e ? c*2+2 : -1;
            int idxToSwap;
            if(s != -1 && array[s] > array[f]){
                idxToSwap = s;
            }else{
                idxToSwap = f;
            }

            if(array[idxToSwap] > array[c]){
                swap(idxToSwap, c, array);
                c = idxToSwap;
                f = c * 2 + 1;
            }else{
                return;
            }
        }
    }
    public static void swap(int i, int j, int[] array){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}








