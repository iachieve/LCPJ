package MinHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapTest {
    public static void main(String[] args) {
        List<Integer> array =
                new ArrayList<>(Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41));
//        MinHeap minHeap = new MinHeap(array);
        Practice minHeap = new Practice(array);

        minHeap.insert(76);
        System.out.println(isMinHeapPropertySatisfied(minHeap.heap));
        System.out.println(minHeap.peek() == -5);
        System.out.println(minHeap.remove() == -5);
        System.out.println(isMinHeapPropertySatisfied(minHeap.heap));
        System.out.println(minHeap.peek() == 2);
        System.out.println(minHeap.remove() == 2);
        System.out.println(isMinHeapPropertySatisfied(minHeap.heap));
        System.out.println(minHeap.peek() == 6);
        minHeap.insert(87);
        System.out.println(isMinHeapPropertySatisfied(minHeap.heap));
    }

    static boolean isMinHeapPropertySatisfied(List<Integer> array) {
        for (int currentIdx = 1; currentIdx < array.size(); currentIdx++) {
            int parentIdx = (currentIdx - 1) / 2;
            if (parentIdx < 0) {
                return true;
            }
            if (array.get(parentIdx) > array.get(currentIdx)) {
                return false;
            }
        }

        return true;
    }
}