import java.util.Arrays;

public class Main {

    public static long count(int[] a) {
        Arrays.sort(a);

        int N = a.length;
        long count = 0;

        for (int i = 0; i < N - 3; i++) {

            for (int j = i + 1; j < N - 2; j++) {

                int left = j + 1;
                int right = N - 1;

                while (left < right) {

                    long sum = (long) a[i]
                            + a[j]
                            + a[left]
                            + a[right];

                    if (sum == 0) {

                        if (a[left] == a[right]) {

                            long n = right - left + 1;

                            count += n * (n - 1) / 2;

                            break;

                        } else {

                            int leftValue = a[left];
                            long leftCount = 0;

                            while (left <= right
                                    && a[left] == leftValue) {

                                leftCount++;
                                left++;
                            }

                            int rightValue = a[right];
                            long rightCount = 0;

                            while (left <= right
                                    && a[right] == rightValue) {

                                rightCount++;
                                right--;
                            }

                            count += leftCount * rightCount;
                        }

                    } else if (sum < 0) {
                        left++;

                    } else {
                        right--;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] a = {1, 2, -3, 4, -1, -2, 0};
        System.out.println("So bo 4 co tong bang 0: " + count(a));

        int[] b = {0, 0, 0, 0, 0, 0};
        System.out.println("So bo 4 co tong bang 0: " + count(b));
    }
}