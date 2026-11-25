import java.util.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Main {
    static class Item implements Comparable<Item> {
        long value;
        int order;

        Item(long value, int order) {
            this.value = value;
            this.order = order;
        }

        public int compareTo(Item other) {
            int cmp = Long.compare(this.value, other.value);

            if (cmp != 0) {
                return cmp;
            }

            return Integer.compare(this.order, other.order);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeSet<Item> tree = new TreeSet<>();
        Item midLow = null;
        Item midHigh = null;

        DecimalFormat df = new DecimalFormat(
                "0.0",
                DecimalFormatSymbols.getInstance(Locale.US)
        );

        for (int i = 0; i < n; i++) {
            Item current = new Item(sc.nextLong(), i);

            int oldSize = tree.size();
            tree.add(current);

            if (oldSize == 0) {
                midLow = current;
                midHigh = current;
            }
            else if (oldSize % 2 == 1) {
                if (current.compareTo(midLow) < 0) {
                    midHigh = midLow;
                    midLow = tree.lower(midLow);
                }
                else {
                    midLow = midLow;
                    midHigh = tree.higher(midLow);
                }
            }
            else {
                if (current.compareTo(midLow) < 0) {
                    midHigh = midLow;
                }
                else if (current.compareTo(midHigh) > 0) {
                    midLow = midHigh;
                }
                else {
                    midLow = current;
                    midHigh = current;
                }
            }

            double median;

            if (tree.size() % 2 == 1) {
                median = midLow.value;
            }
            else {
                median = ((double) midLow.value + midHigh.value) / 2.0;
            }

            System.out.println(df.format(median));
        }

        sc.close();
    }
}