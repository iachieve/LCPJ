package MinHeap;

import java.util.List;

public class MinHeap implements IMinHeap {
    List<Integer> heap;

    public MinHeap(List<Integer> array) {
        heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
        int firstParentIndex = (array.size() - 2) / 2;
        for (int currIdx = firstParentIndex; currIdx >= 0; currIdx++) {
            siftDown(currIdx, array.size() - 1, array);
        }
        return array;
    }

    public void siftDown(int currIdx, int endIdx, List<Integer> heap) {
        int firstChildIdx = currIdx * 2 + 1;
        while (firstChildIdx < endIdx) {
            int secondChildIdx = currIdx * 2 + 2 < endIdx ? currIdx * 2 + 1 : -1;
            int idxToSwap;
            if (secondChildIdx != -1 && heap.get(secondChildIdx) < heap.get(currIdx)) {
                idxToSwap = secondChildIdx;
            } else {
                idxToSwap = firstChildIdx;
            }

            if (heap.get(idxToSwap) < heap.get(currIdx)) {
                swap(idxToSwap, currIdx, heap);
                currIdx = idxToSwap;
                firstChildIdx = currIdx * 2 + 1;
            } else {
                return;
            }
        }
    }

    public void siftUp(int currIdx, List<Integer> heap) {
        int parentIndex = (currIdx - 1) / 2;
        while (heap.get(currIdx) < heap.get(parentIndex)) {
            swap(currIdx, parentIndex, heap);
            currIdx = parentIndex;
            parentIndex = (currIdx - 1) / 2;
        }
    }

    public int remove() {
        swap(0, heap.size()-1, heap);
        int valueToRemove = heap.get(heap.size()-1);
        heap.remove(heap.size()-1);
        siftDown(0, heap.size()-1, heap);
        return valueToRemove;
    }

    public void insert(int value) {
        heap.add(heap.size() - 1);
        siftUp(heap.size() - 1, heap);
    }

    public int peek() {
        return heap.get(0);
    }
}





































