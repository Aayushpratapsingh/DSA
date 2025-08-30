import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

public class BinarySearchTree {
    private static List<Integer> insertedValues = new ArrayList<>();

    public static void main(String[] args) {
        Node root = null;

        System.out.println("Inserting values into BST...");
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);

        System.out.println("\nInsertion complete. Order:");
        for (int val : insertedValues) System.out.print(val + " ");
        System.out.println("\n");

        int searchValue = 60;
        System.out.println("Searching for " + searchValue + "...");
        Node found = find(root, searchValue);
        if (found != null)
            System.out.println("Found node: " + searchValue + "\n");
        else
            System.out.println("Node not found.\n");

        int deleteValue = 30;
        System.out.println("Deleting node: " + deleteValue);
        root = deleteNode(root, deleteValue);

        System.out.println("\nBST after deletion (in-order traversal):");
        inOrderTraversal(root);
        System.out.println();
    }

    public static Node insert(Node root, int value) {
        insertedValues.add(value);
        if (root == null) return new Node(value);
        if (value < root.data) root.left = insert(root.left, value);
        else if (value > root.data) root.right = insert(root.right, value);
        return root;
    }

    public static Node find(Node root, int value) {
        if (root == null || root.data == value) return root;
        return value < root.data ? find(root.left, value) : find(root.right, value);
    }

    public static Node deleteNode(Node root, int value) {
        if (root == null) return root;
        if (value < root.data) root.left = deleteNode(root.left, value);
        else if (value > root.data) root.right = deleteNode(root.right, value);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            Node min = findMinimum(root.right);
            root.data = min.data;
            root.right = deleteNode(root.right, min.data);
        }
        return root;
    }

    public static Node findMinimum(Node root) {
        while (root.left != null) root = root.left;
        return root;
    }

    public static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }
}
