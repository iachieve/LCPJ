package MinHeap;

import java.util.List;

public class MinHeap implements IMinHeap {
    public List<Integer> heap;

    public MinHeap(List<Integer> array) {
        heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
        int firstParentIndex = (array.size() - 2) / 2;
        for (int currIdx = firstParentIndex; currIdx >= 0; currIdx--) {
            siftDown(currIdx, array.size() - 1, array);
        }
        return array;
    }

    public void siftDown(int cIdx, int endIdx, List<Integer> heap) {
        int fIdx = cIdx * 2 + 1;
        while (fIdx <= endIdx) { // <=
            int sIdx = cIdx * 2 + 2 <= endIdx ? cIdx * 2 + 2 : -1; // <=
            int idxToSwap;
            if (sIdx != -1 && heap.get(sIdx) < heap.get(fIdx)) { // second < first
                idxToSwap = sIdx;
            } else {
                idxToSwap = fIdx;
            }

            if (heap.get(idxToSwap) < heap.get(cIdx)) {
                swap(idxToSwap, cIdx, heap);
                cIdx = idxToSwap;
                fIdx = cIdx * 2 + 1;
            } else {
                return;
            }
        }
    }

    public void siftUp(int cIdx, List<Integer> heap) {
        int pIdx = (cIdx - 1) / 2;
        while (cIdx > 0 && heap.get(cIdx) < heap.get(pIdx)) { // while(currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIndex))
            swap(cIdx, pIdx, heap);
            cIdx = pIdx;
            pIdx = (cIdx - 1) / 2;
        }
    }

    public int peek() {
        return heap.get(0);
    }

    public int remove() {
        swap(0, heap.size() - 1, heap);
        int valueToRemove = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return valueToRemove;
    }

    public void insert(int value) {
        heap.add(value);
        siftUp(heap.size() - 1, heap);
    }

}





































