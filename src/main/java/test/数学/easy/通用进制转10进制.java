package test.数学.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengyue on 2019/4/2.
 *
 *
 * https://segmentfault.com/a/1190000010516708
 *
 * https://www.jianshu.com/p/3156cc5d6ae3
 *
 */
public class 通用进制转10进制 {


    @Test
    public void testLongUrl2Short() {
        Base62UrlShorter shorter = new Base62UrlShorter();
        String longUrl = "https://movie.douban.com/subject/26363254/";
        String shortUrl = shorter.shorten(longUrl);
        System.out.println("short url:" + shortUrl);
        System.out.println(shorter.lookup(shortUrl));
    }


    class Base62UrlShorter {

        public final String BASE_62_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        public final int BASE = BASE_62_CHAR.length();


        private long autoIncrId = 10000;

        Map<Long, String> longUrlIdMap = new HashMap<>();

        public long incr() {
            return autoIncrId++;
        }

        public String shorten(String longUrl) {
            long id = incr();
            //add to mapping
            longUrlIdMap.put(id, longUrl);
            return toBase62(id);
        }

        public String lookup(String shortUrl) {
            long id = toBase10(shortUrl);
            return longUrlIdMap.get(id);
        }


        /**
         * 利用二进制转十进制的方法：
         * <p>
         * 从右向左遍历二进制数据 然后 每个数*62的N次方，N从0开始,每个数也从0开始 ，
         * 在这里用了String.indexOf 其实是代表了BASE_62_CHAR 中的顺序（下标）代表了每一个字符的数的大小
         * <p>
         * 举例：三进制转十进制 21 ——》 2*3^1 + 1*3^0 = 7
         *
         * @param base62
         * @return
         */
        public long toBase10(String base62) {


            char[] chars = new StringBuffer(base62).reverse().toString().toCharArray();

            long result = 0;

            int pow = 0;

            for (char c : chars) {

                result += BASE_62_CHAR.indexOf(c) * (long) Math.pow(BASE, pow);

                pow++;
            }

            return result;

        }


        public String toBase62(long number) {

            StringBuffer sb = new StringBuffer();

            if (number == 0) {
                sb.append(BASE_62_CHAR.charAt(0));
            }
            while (number > 0) {

                sb.append(BASE_62_CHAR.charAt((int) (number % BASE)));

                number = number / BASE;
            }

            return sb.reverse().toString();
        }
    }

}
