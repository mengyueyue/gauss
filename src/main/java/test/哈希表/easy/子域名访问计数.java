package test.哈希表.easy;

import java.util.*;

/**
 * Created by mengyue on 2018/8/30.
 */
public class 子域名访问计数 {

    /**
     *
     *
     *
     * 一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。

     给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。

     接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。

     示例 1:
     输入:
     ["9001 discuss.leetcode.com"]
     输出:
     ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
     说明:
     例子中仅包含一个网站域名："discuss.leetcode.com"。按照前文假设，子域名"leetcode.com"和"com"都会被访问，所以它们都被访问了9001次。
     示例 2
     输入:
     ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
     输出:
     ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
     说明:
     按照假设，会访问"google.mail.com" 900次，"yahoo.com" 50次，"intel.mail.com" 1次，"wiki.org" 5次。
     而对于父域名，会访问"mail.com" 900+1 = 901次，"com" 900 + 50 + 1 = 951次，和 "org" 5 次。
     注意事项：

     cpdomains 的长度小于 100。
     每个域名的长度小于100。
     每个域名地址包含一个或两个"."符号。
     输入中任意一个域名的访问次数都小于10000。
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(Arrays.toString(subdomainVisits(cpdomains).toArray()));
    }

    //[951 com, 900 google.mail.com, 1 intel.mail.com, 5 org, 5 wiki.org, 901 mail.com, 50 yahoo.com]
    //[951 com, 900 google.mail.com, 1 intel.mail.com, 5 org, 5 wiki.org, 901 mail.com, 50 yahoo.com]
    public static List<String> subdomainVisits(String[] cpdomains) {

        /**
         * 下面这个是别人的解决方法
         */
//        Map<String, Integer> map = new HashMap();
//        for (String cd : cpdomains) {
//            int i = cd.indexOf(' ');
//
//            int n = Integer.valueOf(cd.substring(0, i));
//
//            String s = cd.substring(i + 1);
//
//            for (i = 0; i < s.length(); ++i) {
//                if (s.charAt(i) == '.') {
//                    String d = s.substring(i + 1);
//                    map.put(d, map.getOrDefault(d, 0) + n);
//                }
//            }
//
//            map.put(s, map.getOrDefault(s, 0) + n);
//        }
//
//        List<String> res = new ArrayList();
//        for (String d : map.keySet()) res.add(map.get(d) + " " + d);
//        return res;
        /**
         * 下面这个是自己的解决方法
         */
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] s = cpdomain.split(" ");
            int i = Integer.valueOf(s[0]);
            String[] childStr = s[1].split("\\.");
            String cur = "";
            for (int j = childStr.length - 1; j >= 0; j--) {
                if (j == childStr.length - 1) {
                    cur = childStr[j] + cur;
                } else {
                    cur = childStr[j] + "." + cur;
                }
                map.put(cur, map.getOrDefault(cur, 0) + i);
            }
        }
        map.forEach((k, v) -> list.add(v + " " + k));
        return list;
    }
}
