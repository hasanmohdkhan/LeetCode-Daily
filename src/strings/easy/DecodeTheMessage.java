package strings.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 27-Oct-23
 * @Description : <a href="https://leetcode.com/problems/decode-the-message/description/">link</a>
 */
public class DecodeTheMessage {

    public String decodeMessage(String key, String message) {
        Map<Character,Character> hashMap = new HashMap<>(); //TODO -  check why putting char as not print correct map?
        StringBuilder stringBuilder  = new StringBuilder(message.length());
        char[] charArray = key.toCharArray();
        char start ='a';
        for (int i = 0; i < charArray.length; i++) {
            if(!hashMap.containsKey(key.charAt(i)) && key.charAt(i)!=' ') hashMap.put(charArray[i], start++);
        }

        for (int i = 0; i < message.length(); i++) {
            if(hashMap.containsKey(message.charAt(i))){
                stringBuilder.append(hashMap.get(message.charAt(i)));
            }else {
                stringBuilder.append(message.charAt(i));
            }
        }

     //   System.out.println("stringBuilder = " + stringBuilder);
     //   System.out.println("hashMap = " + hashMap.toString());
     //   System.out.println("hashMap = " + hashMap.get('a'));

       return  stringBuilder.toString();

    }

    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv";

        DecodeTheMessage decodeTheMessage = new DecodeTheMessage();
        System.out.println("decodeTheMessage = " + decodeTheMessage.decodeMessage(key, message));

    }
}
