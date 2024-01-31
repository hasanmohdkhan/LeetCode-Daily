package Daily.december;

/**
 * @Auther : hasan.khan
 * @Created : 08-Dec-23
 * @Description : <a href="https://leetcode.com/problems/construct-string-from-binary-tree/description/?envType=daily-question&envId=2023-12-08">link</a>
 */
public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode root) {
        if(root == null) return "";
        StringBuilder st = new StringBuilder();

       // System.out.println("------------- = " + " = ------------- ");
        preorderTraverse(root,st);
       // System.out.println("st = " + st);
       // System.out.println("------------- = " + " = ------------- ");

      return st.substring(1, st.length()-1);

    }

    void preorderTraverse(TreeNode root, StringBuilder st) {
        if (root != null) {
            st.append("(");
            st.append(root.val);
            if(root.left == null && root.right!= null) st.append("()");
            preorderTraverse(root.left, st);
            preorderTraverse(root.right, st);
            st.append(")");
        }

      //  System.out.println("st = " + st);
    }

    public static void main(String[] args) {
        ConstructStringFromBinaryTree res = new ConstructStringFromBinaryTree();
        TreeNode root = new TreeNode(1);

      //  [1,2,3,4]
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);


       // System.out.println("res = " + res.preorderTraverse(root));
        System.out.println("res = " + res.tree2str(root));
    }


 // Definition for a binary tree node.
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

  }


}
