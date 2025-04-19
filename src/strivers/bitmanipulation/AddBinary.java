package strivers.bitmanipulation;

/**
 * @Auther : hasan.khan
 * @Created : 26-Mar-25
 * @Description : <a href="https://leetcode.com/problems/add-binary/description/">link</a>
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int dif = Math.abs(b.length() - a.length());

        if (a.length() < b.length()) {
            a = new StringBuilder().repeat('0', dif) + a;
        } else if (b.length() < a.length()) {
            b = new StringBuilder().repeat('0', dif) + b;
        }
        return  add(a, b);
    }

    private static String add(String a, String b) {
        StringBuilder res = new StringBuilder();
        boolean carry = false;

        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                res.insert(0, (carry ? "1" : "0"));
                carry = true;
            } else if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                res.insert(0, (carry ? "1" : "0"));
                carry = false;
            } else res.insert(0, (carry ? "0" : "1"));

        }

        if (carry) res.insert(0, "1");
        return res.toString();
    }


    public static void main(String[] args) {
        AddBinary b = new AddBinary();
        System.out.println("4 = " + Integer.toBinaryString(4));
        System.out.println("5 = " + Integer.toBinaryString(5));
        System.out.println("b = " + Integer.toBinaryString(5 & (1 << 2)));
        System.out.println("b = " + Integer.toBinaryString(13 | (1 << 2)));



       /* System.out.println("s = " + b.addBinary("11", "1"));
        System.out.println("s = " + b.addBinary("1", "10"));
        System.out.println("s = " + b.addBinary("1010", "1011"));*/
    }
}
