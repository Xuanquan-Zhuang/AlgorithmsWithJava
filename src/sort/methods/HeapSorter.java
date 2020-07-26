package sort.methods;

import sort.heap.Heap;

public class HeapSorter implements ISorter {
    @Override
    public void sort(int[] numbers) {
        if (numbers == null) {
            return;
        }

        int length = numbers.length;

        if (length < 2) {
            return;
        }

        Heap heap = new Heap(length);
        for (int i = 0; i < length; ++i) {
            heap.insert(numbers[i]);
        }
        int[] sorted = heap.sort();
        for (int i = 1; i <= length; ++i) {
            numbers[i-1] = sorted[i];
        }
    }
}
