package sort.estimate;

import sort.methods.ISorter;

public class SortEstimator {

    private ISorter mSorter;
    private int[] mNumbers;

    public SortEstimator(ISorter sorter, int[] numbers) {
        this.mSorter = sorter;
        this.mNumbers = numbers;
    }

    public boolean checkCorrectness() {
        if (mSorter == null) {
            System.out.println("sorter is null");
            return false;
        }
        if (mNumbers == null) {
            System.out.println("numbers is null");
            return false;
        }
        int[] copy = new int[mNumbers.length];
        System.arraycopy(mNumbers, 0, copy, 0, mNumbers.length);
        mSorter.sort(copy);
        return isSorted(copy);
    }

    private boolean isSorted(int[] array) {
        int len = mNumbers.length;
        if (len < 2) {
            return true;
        }
        for (int i = 0; i < mNumbers.length-1; ++i) {
            if (array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }
}
