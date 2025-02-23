package strivers.linkedlist.lc;

/**
 * @Auther : hasan.khan
 * @Created : 20-Jan-25
 * @Description : <a href="">link</a>
 */
public class RemoveDuplicate {
    NodeG removeDuplicatesBrute(NodeG head){
        NodeG temp = head;


        while (temp != null){
            if(temp.next != null && temp.data == temp.next.data && temp.next.next != null) {
                    NodeG temp2 = temp.next.next;

                    while (temp2 != null) {
                        if (temp2.next!= null && temp2.data != temp2.next.data) {
                            break;
                        }
                        temp2 = temp2.next;
                    }
                    if (temp2 != null) temp.next = temp2;
                   // System.out.println("temp2 = " + temp2);
                }


            temp = temp.next;
        }


        return head;
    }

    NodeG removeDuplicates(NodeG head){
        NodeG temp = head;

        while (temp != null && temp.next != null){
            NodeG nexNode = temp;
            while (nexNode != null && nexNode.data == temp.data){
                nexNode = nexNode.next;
            }
            temp.next = nexNode;
            if(nexNode != null) nexNode.prev = temp;
            temp = temp.next;
        }


        return head;
    }

   public static void main(String[] args) {
       RemoveDuplicate s = new RemoveDuplicate();
       System.out.println("s = " + s.removeDuplicates(getNodeG(new int[]{1, 1, 1, 2, 3 ,4})));
       System.out.println("s = " + s.removeDuplicates(getNodeG(new int[]{1,1,1,2,3,4})));
       System.out.println("s = " + s.removeDuplicates(getNodeG(new int[]{1,1,2,3,4})));
       System.out.println("s = " + s.removeDuplicates(getNodeG(new int[]{1,2,3,3,4})));
   }

    private static NodeG getNodeG(int[] ints) {
        NodeG head = new NodeG(ints[0]);
        NodeG temp = head;

        for (int i = 1; i < ints.length; i++) {
            NodeG next = new NodeG(ints[i]);
            next.prev = temp;
            temp.next = next;
            temp = next;
        }
        return head;
    }


}
