package test.哈希表.middle;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by mengyue on 2019/3/22.
 */
public class TinyURL的加密与解密 {


    private Map<String, String> mapping = new HashMap<>();

    @Test
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        String shuffle = String.valueOf(longUrl.hashCode());

        String shortUrl = "http://tinyurl.com/" + shuffle;

        mapping.put(shortUrl, longUrl);

        return shortUrl;
    }

    @Test
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        return mapping.get(shortUrl);

    }

}
