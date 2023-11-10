package strings.medium;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther : hasan.khan
 * @Created : 20-Oct-23
 * @Description : <a href="https://leetcode.com/problems/encode-and-decode-tinyurl/description/">Link</a>
 */
public class EncodeAndDecodeTinyURL {

    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/design-tinyurl";

        System.out.println("url = " + url.hashCode());
        Codec codec = new Codec();
        String encode = codec.encode(url);
        System.out.println("encode = " + encode);
        System.out.println("decode = " + codec.decode(encode));

    }
}

class Codec {

    ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    String preFix = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder hash;



        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest(longUrl.getBytes());
            BigInteger bigInteger = new BigInteger(1, digest);
            hash = new StringBuilder(bigInteger.toString(16));
            while (hash.length() < 32) {
                hash.insert(0, 0);
            }
            map.put(hash.toString(), longUrl);
           // System.out.println("map = " + map);
            return preFix+ hash;

        } catch (NoSuchAlgorithmException ignored) {}

        return "";
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
      //  System.out.println("map = " + map);
        if (!map.isEmpty()) {
            return map.get(shortUrl.substring(preFix.length()));
        } else return "";
    }


}
