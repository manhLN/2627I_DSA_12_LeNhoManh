import java.util.*;

public class Main {
    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.println(x + " ");
        }
        System.out.println();
    }

    public static void insertIntoSorted(int[] arr) {
        int value = arr[arr.length - 1];
        int i = arr.length - 2;

        while (i >= 0 && arr[i] > value) {
            arr[i + 1] = arr[i];
            printArray(arr);
            i--;
        }

        arr[i + 1] = value;
        printArray(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        insertIntoSorted(arr);

        sc.close();
    }
}