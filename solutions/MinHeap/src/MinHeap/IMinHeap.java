package MinHeap;

import java.util.List;

public interface IMinHeap {

    int peek();

    // 5 l
    void siftUp(int currentIndex, List<Integer> heap);

    // 15 l
    void siftDown(int currentIndex, int endIndex, List<Integer> heap);

    // 5 l
    int remove();

    // 2 l
    void insert(int value);

    List<Integer> buildHeap(List<Integer> array);

    default void swap(int i, int j, List<Integer> heap) {
        int temp = heap.get(j);
        heap.set(j, heap.get(i));
        heap.set(i, temp);
    }
}