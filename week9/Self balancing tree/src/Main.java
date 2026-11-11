import java.util.Scanner;

class Node {
    int val;
    int ht;
    Node left, right;

    Node(int val) {
        this.val = val;
        this.ht = 0;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    static int height(Node node) {
        if (node == null) {
            return -1;
        }

        return node.ht;
    }

    static void updateHeight(Node node) {
        node.ht = 1 + Math.max(
                height(node.left),
                height(node.right)
        );
    }

    static int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    static Node rotateRight(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    static Node rotateLeft(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            return root;
        }

        updateHeight(root);
        int balance = balanceFactor(root);

        if (balance > 1 && val < root.left.val) {
            return rotateRight(root);
        }

        if (balance < -1 && val > root.right.val) {
            return rotateLeft(root);
        }

        if (balance > 1 && val > root.left.val) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        if (balance < -1 && val < root.right.val) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(
                root.val + "(h=" + root.ht + ", BF=" + balanceFactor(root) + ") "
        );

        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node root = null;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            root = insert(root, x);
        }

        int val = sc.nextInt();
        root = insert(root, val);

        preOrder(root);

        sc.close();
    }
}