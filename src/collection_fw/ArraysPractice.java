package collection_fw;

import java.util.Arrays;

public class ArraysPractice {

    public static void main(String[] args) {
        int[] arr = new int[10];

        Arrays.fill(arr, 0);

        int index = Arrays.binarySearch(arr, 0);

        Arrays.sort(arr);
    }
}
