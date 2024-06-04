package strivers.recurssion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 22-Feb-24
 * @Description : <a href="">link</a>
 */
public class PrintString {


    public static List<String> printNtimes(int n){
        List<String> list = new ArrayList<>();
        return printTimes(n, list);
    }

    public static List<String> printTimes(int n, List<String> list){
        if(n>1){
            printTimes(n-1, list);
       }
        list.add("Coding Ninjas ");
      //  System.out.print("Coding Ninjas ");
        return list;
    }



    public static void main(String[] args) {
        System.out.println("args = " + printNtimes(3));
       /* System.out.println("args = " + */printNtimes(3);//);
    }
}
