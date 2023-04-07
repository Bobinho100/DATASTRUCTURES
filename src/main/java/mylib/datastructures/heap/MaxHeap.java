package main.java.mylib.datastructures.heap;


import java.util.Vector;

public class MaxHeap {

    private Vector<Integer> heap;

    public MaxHeap() {
        heap = new Vector<>();
    }

    public void insert(int value) {
        heap.add(value);
        int index = heap.size() - 1;
        while (index > 0 && heap.get(index) > heap.get((index - 1) / 2)) {
            int temp = heap.get(index);
            heap.set(index, heap.get((index - 1) / 2));
            heap.set((index - 1) / 2, temp);
            index = (index - 1) / 2;
        }
    }

    public int deleteMax() {
        int max = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int index = 0;
        while (index * 2 + 1 < heap.size()) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int maxIndex = left;
            if (right < heap.size() && heap.get(right) > heap.get(left)) {
                maxIndex = right;
            }
            if (heap.get(index) < heap.get(maxIndex)) {
                int temp = heap.get(index);
                heap.set(index, heap.get(maxIndex));
                heap.set(maxIndex, temp);
                index = maxIndex;
            } else {
                break;
            }
        }
        return max;
    }

    public static int[] heapsort(int[] array) {
        MaxHeap maxHeap = new MaxHeap();
        for (int i = 0; i < array.length; i++) {
            maxHeap.insert(array[i]);
        }
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = maxHeap.deleteMax();
        }
        return sortedArray;
    }
}
