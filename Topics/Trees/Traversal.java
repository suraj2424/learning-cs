package Topics.Trees;

/* 

TREES

* Traversals
1. Inorder (Left - Root - Right)
2. Preorder (Root - Left - Right)
3. Postorder (Left - Right - Root)


*/

class Node{
    int value;
    Node left;
    Node right;
    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class Helper_Tree_Traversal {
    
    void inorder(Node root) {
        if(root == null) {
            return;
        } 
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    void preorder(Node root) {
        if(root == null) {
            return;
        } 
        System.out.print(root.value + " ");
        inorder(root.left);
        inorder(root.right);
    }

    void postorder(Node root) {
        if(root == null) {
            return;
        } 
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.value + " ");
    }
}

public class Traversal {
    public static void main(String[] args) {
        Helper_Tree_Traversal htt = new Helper_Tree_Traversal();
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Inorder Traversal: ");
        htt.inorder(root);
        System.out.println();
        System.out.println("PreOrder Traversal: ");
        htt.preorder(root);
        System.out.println();
        System.out.println("PostOrder Traversal: ");
        htt.postorder(root);

    }
    
}
