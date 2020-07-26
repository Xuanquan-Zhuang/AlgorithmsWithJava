package sort;

import sort.estimate.SortEstimator;
import sort.methods.*;

import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        final int ARRAY_LENGTH = 100;
        final int MAX_INT = 10000;

        int[] arr = new int[ARRAY_LENGTH];
        Random rand = new Random();

        for (int i = 0; i < ARRAY_LENGTH; i++) {
            arr[i] = rand.nextInt(MAX_INT);
        }
        System.out.println("Array before sort:");
        for (int num: arr) {
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println("");

		ISorter model = new HeapSorter();
        model.sort(arr);
        System.out.println("Array after sort:");
        for (int newNum: arr) {
            System.out.print(newNum);
            System.out.print(" ");
        }
        System.out.println("");

        SortEstimator estimator = new SortEstimator(model, arr);
        if (estimator.checkCorrectness()) {
            System.out.println("result correct");
        } else {
            System.out.println("result incorrect");
        }
    }
}
