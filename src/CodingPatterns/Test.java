package CodingPatterns;

/**
 * @Auther : hasan.khan
 * @Created : 08-Dec-23
 * @Description : <a href="">link</a>
 */

public class Test {

    TestNode root;

    static class TestNode {
        int data;
        TestNode left, right;

        TestNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    void insert(int data) {
        root = insert(root, data);
    }

    TestNode insert(TestNode root, int data) {

        if (root == null) {
            root = new TestNode(data);
            return root;
        }

        if (data < root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        return root;
    }

    void printPreorder() {
        preorderRec(root);
    }

    void preorderRec(TestNode root) {
        if (root != null) {
            System.out.println(root.data);
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        Test tree = new Test();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        System.out.println("Preorder traversal of binary tree is:");
        tree.printPreorder();
    }
}
