package CodingPatterns;

/**
 * @Auther : hasan.khan
 * @Created : 06-Nov-23
 * @Description : <a href="">link</a>
 */
public class Recursion {

    public String reverse(String input) {
        if (input.isEmpty()) return "";
        /*System.out.print("input.substring(1) = " + input.substring(1));
        System.out.print("   input = " + input.charAt(0));
        System.out.println();*/
        return reverse(input.substring(1)) + input.charAt(0);
    }

    public static void main(String[] args) {
        Recursion r = new Recursion();
        System.out.println("r = " + r.reverse("hello"));
        System.out.println("r = " + r.reverse("kayak"));
    }

}
