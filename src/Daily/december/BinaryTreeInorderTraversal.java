package Daily.december;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 09-Dec-23
 * @Description : <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/description/?envType=daily-question&envId=2023-12-09">link</a>
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderPrint(root, list);
       // System.out.println("list = " + list);
        return list;
    }

    private void inOrderPrint(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrderPrint(node.left, list);
        list.add(node.val);
        inOrderPrint(node.right, list);
    }


    public static void main(String[] args) {
        BinaryTreeInorderTraversal res = new BinaryTreeInorderTraversal();
        //root = [1,null,2,3] ->
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
      
        
        System.out.println("res = " + res.inorderTraversal(root));
    }

    //      Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
