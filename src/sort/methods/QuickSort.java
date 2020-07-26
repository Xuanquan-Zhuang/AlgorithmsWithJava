package sort.methods;

public class QuickSort implements ISorter {
    @Override
    public void sort(int[] numbers) {
        sort(numbers, 0, numbers.length-1);
    }

    private void sort(int[] numbers, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(numbers, start, end);
        sort(numbers, start, pivot-1);
        sort(numbers, pivot+1, end);
    }

    private int partition(int[] numbers, int start, int end) {
        int pivot = numbers[end];
        int sortedIndex = start;
        for (int i = start; i < end; ++i) {
            if (numbers[i] < pivot) {
                swap(numbers, sortedIndex, i);
                sortedIndex++;
            }
        }
        swap(numbers, sortedIndex, end);
        return sortedIndex;
    }

    private void swap(int[] numbers, int a, int b) {
        if (a == b) {
            return;
        }
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
