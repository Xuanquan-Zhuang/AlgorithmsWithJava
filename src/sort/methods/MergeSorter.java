package sort.methods;

public class MergeSorter implements ISorter {
    @Override
    public void sort(int[] numbers) {
        merge(numbers, 0, numbers.length-1);
    }

    private void merge(int[] numbers, int start, int end) {
        if (start >= end) {
            return;
        }

        int length = end-start+1;
        int mid = (end + start) / 2;
        merge(numbers, start, mid);
        merge(numbers, mid+1, end);

        int[] sorted = new int[length];
        int index_front = start, index_back = mid + 1;
        for (int i = 0; i < length; ++i) {
            if (index_front > mid) {
                copy(numbers, index_back, sorted, i, length - i);
                break;
            }
            if (index_back > end) {
                copy(numbers, index_front, sorted, i, length - i);
                break;
            }
            if (numbers[index_front] <= numbers[index_back]) {
                sorted[i] = numbers[index_front];
                index_front++;
            } else {
                sorted[i] = numbers[index_back];
                index_back++;
            }
        }
        copy(sorted, 0, numbers, start, length);
    }

    private void copy(int[] from, int start_from, int [] to, int start_to, int length) {
        for (int i = 0; i < length; ++i) {
            to[start_to + i] = from[start_from + i];
        }
    }
}
