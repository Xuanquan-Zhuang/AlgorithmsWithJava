package sort.methods;

public class BubbleSorter implements ISorter {
    @Override
    public void sort(int[] numbers) {
        if (numbers == null) {
            return;
        }

        int length = numbers.length;

        if (length < 2) {
            return;
        }

        boolean flag = true;  // whether array changes
        int exchange;

        for (int i = length - 1; i > 0; i--) {
            if (!flag) {
                break;  // array didn't change last round, which means array has been sorted
            }
            flag = false;
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[j+1]) {
                    exchange = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = exchange;
                    flag = true;
                }
            }
        }
    }
}
