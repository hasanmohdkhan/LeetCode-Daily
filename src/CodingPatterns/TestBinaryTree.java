package CodingPatterns;

/**
 * @Auther : hasan.khan
 * @Created : 11-Dec-23
 * @Description : <a href="">link</a>
 */
public class TestBinaryTree {


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(20);
        binaryTree.insert(10);
        binaryTree.insert(30);
        binaryTree.insert(40);
        binaryTree.insert(35);
        binaryTree.insert(50);

        binaryTree.traverseInOrder();
        System.out.println();
      /*  Node node = binaryTree.get(40);
        System.out.println("node = " +node);
        System.out.println("node1 = " +binaryTree.get(20));
        System.out.println("node2 = " +binaryTree.get(2000));

        System.out.println();

        System.out.println("max = " + binaryTree.max());
        System.out.println("min = " + binaryTree.min());
        System.out.println("40 min = " + node.min());
        System.out.println("40 max = " + node.max());*/


        binaryTree.delete(10);
        System.out.print("after deletion: ");
        binaryTree.traverseInOrder();


        BinaryTree binaryTree1 = new BinaryTree();
        binaryTree1.insert(15);
        binaryTree1.insert(17);
        binaryTree1.insert(20);
        binaryTree1.insert(22);
        binaryTree1.insert(25);
        binaryTree1.insert(26);
        binaryTree1.insert(27);
        binaryTree1.insert(29);
        binaryTree1.insert(30);
        binaryTree1.insert(32);
        System.out.println();
        binaryTree1.traverseInOrder();

        Node delete = binaryTree1.delete(17);
       // System.out.println("\n--- delete = " + delete +"\n");
        System.out.println();
        System.out.print("after deletion: ");

        binaryTree1.traverseInOrder();



    }
}
