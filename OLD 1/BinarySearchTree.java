// Definition of a single node in the BST
class Node {
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    // ---- Insert a key into BST ----
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {                 // empty spot found
            return new Node(key);
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        // duplicates ignored
        return root;
    }

    // ---- Search a key ----
    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {
        if (root == null) return false;
        if (root.key == key) return true;
        if (key < root.key)
            return searchRec(root.left, key);
        else
            return searchRec(root.right, key);
    }

    // ---- Delete a key ----
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) return null;

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            // node to be deleted found
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children → replace with inorder successor
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    private int minValue(Node node) {
        int min = node.key;
        while (node.left != null) {
            min = node.left.key;
            node = node.left;
        }
        return min;
    }

    // ---- Inorder traversal (Left‑Root‑Right) ----
    public void inorder() {
        inorderRec(root);
        System.out.println(); // newline for neat output
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // ---- Driver demo ----
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert elements
        int[] values = {50, 30, 20, 40, 70, 60, 80};
        for (int v : values) bst.insert(v);

        System.out.print("In‑order traversal: ");
        bst.inorder(); // Should print sorted order

        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Search 90: " + bst.search(90));

        bst.delete(20);
        bst.delete(30);
        bst.delete(50); // delete root

        System.out.print("After deletions, in‑order: ");
        bst.inorder();
    }
}