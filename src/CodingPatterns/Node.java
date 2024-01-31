package CodingPatterns;

/**
 * @Auther : hasan.khan
 * @Created : 11-Dec-23
 * @Description :Binary tree implementation
 */
public class Node {
    private int val;
    private Node right;
    private Node left;

    public Node(int val) {
        this.val = val;
        right = null;
        left = null;
    }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }


    public void insert(int data) {
        if (val == data) {
            return;
        }

        if (data < val) { //left
            if (left == null) left = new Node(data);
            else left.insert(data);

        } else { // Right
            if (right == null) right = new Node(data);
            else right.insert(data);

        }


    }

    public void inOrderPrint() {
      /*  if(node == null) return;
        inOrderPrint(node.left);
        System.out.print(" " + node.val +", ");
        inOrderPrint(node.right);*/

        if (left != null) {
            left.inOrderPrint();
        }
        System.out.print(" " + val + ", ");
        if (right != null) {
            right.inOrderPrint();
        }
    }

    public Node get(int value) {
        if (val == value) {
            return this;
        }
        if (value < val) {
            if (left != null) return left.get(value);
        } else {
            if (right != null) return right.get(value);
        }
        return null;
    }

    public int min() {
        if (left == null) {
            return val;
        } else {
            return left.min();
        }

    }

    public int max() {
        if (right == null) {
            return val;
        } else {
            return right.max();
        }

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("val=").append(val);
        sb.append(", right=").append(right);
        sb.append(", left=").append(left);
        sb.append('}');
        return sb.toString();
    }
}
