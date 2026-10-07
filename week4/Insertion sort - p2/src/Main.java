import java.util.*;

public class Main {
    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.println(x + " ");
        }
        System.out.println();
    }

    public static void insertIntoSorted(int[] arr, int idx) {
        int value = arr[idx];
        int i = idx - 1;

        while (i >= 0 && arr[i] > value) {
            arr[i + 1] = arr[i];
            i--;
        }

        arr[i + 1] = value;
    }

    public static void insertionSortPart2(int[] arr) {
        for (int idx = 1; idx < arr.length; idx++) {
            insertIntoSorted(arr, idx);
            printArray(arr);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        insertionSortPart2(arr);

        sc.close();
    }
}