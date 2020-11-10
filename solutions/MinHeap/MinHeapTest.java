package MinHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapTest {
    public static void main(String[] args) {
        List<Integer> array =
                new ArrayList<>(Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41));
        IMinHeap heap = new MinHeap(array);
        heap.insert(76);
        heap.peek();
        heap.remove();
        heap.peek();
        heap.insert(87);
    }
}
