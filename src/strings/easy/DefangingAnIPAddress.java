package strings.easy;

/**
 * @Auther : hasan.khan
 * @Created : 16-Oct-23
 * @Description : <a href="https://leetcode.com/problems/defanging-an-ip-address/">Link</a>
 */
public class DefangingAnIPAddress {

    public String defangIPaddr(String address) {
        return  address.replace(".","[.]");
    }

    public static void main(String[] args) {
        String address = "1.1.1.1";
        DefangingAnIPAddress ipAddress = new DefangingAnIPAddress();
        System.out.println("ipAddress = " + ipAddress.defangIPaddr(address));


    }
}
