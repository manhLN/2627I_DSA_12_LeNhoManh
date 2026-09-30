import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void enqueue(int value) {
        stack1.push(value);
    }

    public static void moveToStack2() {
        if (stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public static void dequeue() {
        moveToStack2();

        if(!stack2.isEmpty()) {
            stack2.pop();
        }
    }

    public static void print() {
        moveToStack2();

        if (!stack2.isEmpty()) {
            System.out.println(stack2.peek());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                int value = sc.nextInt();
                enqueue(value);
            }

            else if (type == 2) {
                dequeue();
            }

            else if (type == 3) {
                print();
            }
        }

        sc.close();
    }
}