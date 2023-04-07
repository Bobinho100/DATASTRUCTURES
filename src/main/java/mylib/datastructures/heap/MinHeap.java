package main.java.mylib.datastructures.heap;

import java.util.Vector;

public class MinHeap {

    private Vector<Integer> heap;

    // Constructor to create an empty MinHeap
    public MinHeap() {
        heap = new Vector<Integer>();
    }

    // Insert a new value into the MinHeap
    public void insert(int value) {
        heap.add(value); // Add the value to the end of the heap
        int index = heap.size() - 1; // Get the index of the last element
        // Bubble up the element until it's in the correct position
        while (index > 0 && heap.get((index - 1) / 2) > heap.get(index)) {
            int temp = heap.get(index);
            heap.set(index, heap.get((index - 1) / 2));
            heap.set((index - 1) / 2, temp);
            index = (index - 1) / 2;
        }
    }

    // Remove and return the minimum value from the MinHeap
    public int deleteMin() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        int minVal = heap.get(0); // Get the minimum value
        heap.set(0, heap.get(heap.size() - 1)); // Replace it with the last element
        heap.remove(heap.size() - 1); // Remove the last element
        int index = 0; // Start from the root
        // Bubble down the element until it's in the correct position
        while (index * 2 + 1 < heap.size()) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int minIndex = left;
            if (right < heap.size() && heap.get(right) < heap.get(left)) {
                minIndex = right;
            }
            if (heap.get(index) > heap.get(minIndex)) {
                int temp = heap.get(index);
                heap.set(index, heap.get(minIndex));
                heap.set(minIndex, temp);
                index = minIndex;
            } else {
                break;
            }
        }
        return minVal;
    }

    // Static function to perform heapsort on an input array
    public static int[] heapsort(int[] array) {
        MinHeap minHeap = new MinHeap(); // Create a new MinHeap object
        for (int i = 0; i < array.length; i++) {
            minHeap.insert(array[i]); // Insert each element of the array into the heap
        }
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = minHeap.deleteMin(); // Remove the minimum element in a loop to obtain a sorted array
        }
        return sortedArray; // Return the sorted array
    }

}
