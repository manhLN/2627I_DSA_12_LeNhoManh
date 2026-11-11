import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Main {
   static Node insert(Node root, int data) {
       if (root == null) {
           return new Node(data);
       }

       if (data < root.data) {
           root.left = insert(root.left, data);
       } else if (data > root.data) {
           root.right = insert(root.right, data);
       }

       return root;
   }

   static Node lca(Node root, int v1, int v2) {
       if (root == null) {
           return null;
       }

       if (v1 < root.data && v2 < root.data) {
           return lca(root.left, v1, v2);
       }

       if (v1 > root.data && v2 > root.data) {
           return lca(root.right, v1, v2);
       }

       return root;
   }

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       int n = sc.nextInt();
       Node root = null;

       for (int i = 0; i < n; i++) {
           int x = sc.nextInt();
           root = insert(root, x);
       }

       int v1 = sc.nextInt();
       int v2 = sc.nextInt();

       Node res = lca(root, v1, v2);

       if (res != null) {
           System.out.println(res.data);
       } else {
           System.out.println("Khong tim thay");
       }

       sc.close();
   }
}