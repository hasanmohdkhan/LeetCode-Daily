package CodingPatterns;

/**
 * @Auther : hasan.khan
 * @Created : 11-Dec-23
 * @Description : <a href="">link</a>
 */
public class BinaryTree {

    private Node root;

    // init
    public void insert(int data) {
        if (root == null) root = new Node(data);
        else root.insert(data);
    }

    // print data in Tree
    public void traverseInOrder() {
        if (root == null) return;
        root.inOrderPrint();
    }

    public Node get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }

    public int min() {
        return root.min();
    }

    public int max() {
        return root.max();
    }

    public Node delete(int value) {
        root = delete(root, value);
        return root;
    }

    private Node delete(Node subTree, int value) {
        if (subTree == null) {
            return subTree;
        }

        if (value < subTree.getVal()) {
            subTree.setLeft(delete(subTree.getLeft(), value));
        } else if (value > subTree.getVal()) {
            subTree.setRight(delete(subTree.getRight(), value));
        } else {
            // Case 1 & 2: Subtree has 0 or 1 children?
            if (subTree.getLeft() == null) return subTree.getRight();
            else if (subTree.getRight() == null) return subTree.getLeft();

            // Case 3: Where there are two children in subtree
            subTree.setVal(subTree.getRight().min());

            subTree.setRight(delete(subTree.getRight(),subTree.getVal()));
        }

        return subTree;
    }


}
