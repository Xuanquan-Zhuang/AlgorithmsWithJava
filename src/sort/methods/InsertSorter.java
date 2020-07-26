package sort.methods;

public class InsertSorter implements ISorter {
    @Override
    public void sort(int[] numbers) {
        if (numbers == null) {
            return;
        }

        int length = numbers.length;

        if (length < 2) {
            return;
        }

        int insertNum;
        int i, j, k;
        for (i = 1; i < length; i++) {
            insertNum = numbers[i];
            for (j = 0; j < i; j++) {
                if (numbers[j] > insertNum)
                    break;
            }
            for (k = i; k > j; k--) {
                numbers[k] = numbers[k-1];
            }
            numbers[j] = insertNum;
        }
    }
}
