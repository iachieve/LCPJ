package MinHeap;
import java.util.Arrays;
import java.util.List;

class Practice {
    List<Integer> heap;

    public Practice(List<Integer> array){
        this.heap = this.buildHeap(array);
    }

    private List<Integer> buildHeap(List<Integer> array) {
        int firstParentIndex = (array.size() - 2) / 2;
        for(int currentIndex = firstParentIndex; currentIndex >= 0; currentIndex--){
            siftDown(currentIndex, array.size() - 1, array);
        }
        return array;
    }

    private void siftDown(int currentIndex, int endIndex, List<Integer> heap) {
        int firstChildIndex = currentIndex * 2 + 1;
        while (firstChildIndex <= endIndex){
            int secondChildIndex = currentIndex * 2 + 2 <= endIndex ? currentIndex * 2 + 2 : -1;
            int idxToSwap;
            if(secondChildIndex != -1 && heap.get(secondChildIndex) < heap.get(firstChildIndex)){
                idxToSwap = secondChildIndex;
            }else{
                idxToSwap = firstChildIndex;
            }

            if(heap.get(idxToSwap) < heap.get(currentIndex)){
                swapValues(idxToSwap, currentIndex, heap);
                currentIndex = idxToSwap;
                firstChildIndex = currentIndex * 2 + 1;
            }else{
                return;
            }
        }

    }

    public int remove(){
        swapValues(0, heap.size() - 1,heap);
        int valueToRemove = heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return valueToRemove;
    }

    public int peek(){
        return heap.get(0);
    }

    public void insert(int val){
        heap.add(val);
        siftUp(heap.size() - 1, heap);
    }

    private void siftUp(int currentIndex, List<Integer> heap) {
        int parentIndex = (currentIndex - 1) / 2;
        while (currentIndex >= 0 && heap.get(parentIndex) > heap.get(currentIndex)){
            swapValues(currentIndex, parentIndex, heap);
            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / 2;
        }
    }

    private void swapValues(int i, int j, List<Integer> heap) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }


}



















