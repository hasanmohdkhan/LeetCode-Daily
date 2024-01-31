package tool;

/**
 * @Auther : hasan.khan
 * @Created : 26-Dec-23
 * @Description : <a href="">link</a>
 */
public class Analysis {
    static long start =0;

    public Analysis() {
        System.out.println("Analysis started...  ");
        start = System.currentTimeMillis();
    }

    public void start(){
        start = System.currentTimeMillis();
        //System.out.println("start = " + start);
    }

    public void end(){
        System.out.println("Time analysis = " + (System.currentTimeMillis() - start ) + "ms");
    }


    public static void main(String[] args) {
       // start();
        for (int i = 0; i < 100000000; i++) {

        }

      // end();
    }
}
