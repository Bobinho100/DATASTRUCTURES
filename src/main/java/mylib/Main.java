package main.java.mylib;
import main.java.mylib.datastructures.heap.MaxHeap;
import main.java.mylib.datastructures.heap.MinHeap;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Test the MinHeap class
        System.out.println("Testing MinHeap:");

        // Create a new MinHeap object
        MinHeap minHeap = new MinHeap();

        // Insert some values into the MinHeap
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(8);
        minHeap.insert(1);

        // Test the deleteMin method
        System.out.println("Minimum value in the heap: " + minHeap.deleteMin()); // Expected output: 1

        // Test the heapsort method
        int[] array1 = { 5, 2, 8, 1 };
        int[] sortedArray1 = MinHeap.heapsort(array1);
        System.out.println("Sorted array: " + Arrays.toString(sortedArray1)); // Expected output: [1, 2, 5, 8]

        // Test the MaxHeap class
        System.out.println("\nTesting MaxHeap:");

        // Create a new MaxHeap object
        MaxHeap maxHeap = new MaxHeap();

        // Insert some values into the MaxHeap
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(8);
        maxHeap.insert(1);

        // Test the deleteMax method
        System.out.println("Maximum value in the heap: " + maxHeap.deleteMax()); // Expected output: 8

        // Test the heapsort method
        int[] array2 = { 5, 2, 8, 1 };
        int[] sortedArray2 = MaxHeap.heapsort(array2);
        System.out.println("Sorted array: " + Arrays.toString(sortedArray2)); // Expected output: [8, 5, 2, 1]

    }

}
