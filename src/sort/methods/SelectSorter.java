package sort.methods;

public class SelectSorter implements ISorter {
    @Override
    public void sort(int[] numbers) {
        if (numbers == null) {
            return;
        }

        int length = numbers.length;
        if (length < 2) {
            return;
        }

        int min;
        int exchange;
        for (int i = 0; i < length-1; ++i) {
            min = i;
            for (int j = i+1; j < length; ++j) {
                if (numbers[j] < numbers[min]) {
                    min = j;
                }
            }
            exchange = numbers[i];
            numbers[i] = numbers[min];
            numbers[min] = exchange;
        }
    }
}
