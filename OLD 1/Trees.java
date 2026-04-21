class Tree {
    int v;
    Tree l;
    Tree r;
    Tree(int v) {
        this.v = v;
        l = null;
        r = null;
    }
}
class Traversals{
    /*
    
    TRAVERSALS

    1. Inorder
    - Left - Root - Right

    2. Preorder
    - Root - Left - Right

    3. Postorder
    - Left - Right - Root
    */

    public void inorder(Tree root) {
        if (root == null) {
            return;
        }
        inorder(root.l);
        System.out.print(root.v + " ");
        inorder(root.r);
    }
    public void preorder(Tree root) {
        if (root == null) {
            return;
        }
        System.out.print(root.v + " ");
        inorder(root.l);
        inorder(root.r);
    }
    public void postorder(Tree root) {
        if (root == null) {
            return;
        }
        inorder(root.l);
        inorder(root.r);
        System.out.println(root.v + " ");
    }
}
public class Trees {
    public static void main(String[] args) {
        /*
        
                4
            2       6
          1   3   5   7

        */

        Tree root = new Tree(4);
        root.l = new Tree(2);
        root.r = new Tree(6);
        root.l.l = new Tree(1);
        root.l.r = new Tree(3);
        root.r.l = new Tree(5);
        root.r.r = new Tree(7);

        Traversals tr = new Traversals();
        tr.preorder(root);
        
    }
}
