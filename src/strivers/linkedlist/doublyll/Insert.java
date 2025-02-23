package strivers.linkedlist.doublyll;

/**
 * @Auther : hasan.khan
 * @Created : 10-Dec-24
 * @Description : <a href="">link</a>
 */
public class Insert {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

      //  DNode dl = createDL(arr);

      /*  System.out.println("for empty: ");

        deleteHead(createDL(new int[]{}));

        System.out.println("for non-empty: ");
        DNode dl2 = deleteHead(dl);

        deleteTail(createDL(arr));*/

  /*      System.out.println("deleteByValue = " + deleteByValue(dl, 2));
        System.out.println("deleteByValue = " + deleteByValue(createDL(arr), 1));
        System.out.println("deleteByValue = " + deleteByValue(createDL(arr), 3));
 */
    //    System.out.println("byCounter =" + deleteByCounter(createDL(arr), 0));
    //    System.out.println("byCounter =" + deleteByCounter(createDL(arr), 1));
//        System.out.println("byCounter =" + deleteByCounter(createDL(arr), 2));
        System.out.println("byCounter =" + deleteByCounter(createDL(arr), 3));


    }

    private static DNode deleteTail(DNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        DNode tail = head;


        while (tail.next != null) {
            tail = tail.next;
        }

        DNode newTail = tail.prev;
        newTail.next = null;
        tail.prev = null;


        System.out.println("Insert.deleteTail....");
        System.out.println("head = " + head);
        return head;
    }

    private static DNode deleteHead(DNode head) {
        // if head is null or single node
        if (head == null || head.next == null) {
            return null;
        }

        DNode prev = head;
        head = head.next;

        head.prev = null;
        prev.next = null;

        return head;
    }

    private static DNode createDL(int[] arr) {
        if (arr.length == 0) return null;

        DNode dNode = new DNode(arr[0]);
        DNode head = dNode;

        for (int i = 1; i < arr.length; i++) {
            DNode temp = new DNode(arr[i], dNode, null);
            dNode.next = temp;
            dNode = temp;
        }

       // System.out.println("Insert.createDL::");
        System.out.println("Cr = " + head);

        return head;

    }

    private static DNode deleteByValue(DNode head, int key) {
        System.out.println("Insert.deleteByValue");
        if (head == null || head.next == null) return null;

        DNode current = head;

        if (head.data == key) {
            head = head.next;
            if (head != null) head.prev = null;
            return head;
        }

        while (current.next != null) {

            if (current.data == key) {
                DNode prev = current.prev;
                DNode next = current.next;

                if (prev != null) prev.next = next;
                if (next != null) next.prev = prev;
                //System.out.println("current = " + current.data);
                return head;
            }

            current = current.next;
        }

        return head;

    }

    private static DNode deleteByCounter(DNode head, int nthNodeToDelete) {
        int count = 0;
        DNode traverser = head;

        if(nthNodeToDelete==0){
            head = head.next;
            if(head != null) head.prev = null;
            return head;
        }

        while (traverser.next != null) {
            if (count == nthNodeToDelete) {
                DNode next = traverser.next;
                DNode prev = traverser.prev;

                if(prev != null) prev.next = next;
                if(next != null) next.prev = prev;


                return head;
            }
            count++;
           traverser = traverser.next;
        }


        return head;
    }

}
