package sort.heap;

public class Heap {
    private int[] mArray;
    private int mCapacity;
    private int mCount;

    public Heap(int capacity) {
        mArray = new int[capacity + 1];
        mCapacity = capacity;
        mCount = 0;
    }

    public void insert(int data) {
        if (mCount >= mCapacity) {
            return;
        }

        ++mCount;
        mArray[mCount] = data;
        int i = mCount;
        while (i/2 > 0 && mArray[i] > mArray[i/2]) {
            swap(i, i/2);
            i = i / 2;
        }
    }


    public void removeMax() {
        if (mCount == 0) {
            return;
        }

        mArray[1] = mArray[mCount];
        --mCount;
        heapify(mCount, 1);
    }

    public int[] sort() {
        int last = mCount;
        while (last > 1) {
            swap(1, last);
            --last;
            heapify(last, 1);
        }
        return mArray;
    }

    private void heapify(int n, int i) {
        while (true) {
            int maxPos = i;

            if (i*2 <= n && mArray[i] < mArray[i*2]) {
                maxPos = i * 2;
            }

            if (i*2+1 <= n && mArray[maxPos] < mArray[i*2+1]) {
                maxPos = i * 2 + 1;
            }

            if (maxPos == i) {
                break;
            }

            swap(i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int index1, int index2) {
        int temp = mArray[index1];
        mArray[index1] = mArray[index2];
        mArray[index2] = temp;
    }
}
