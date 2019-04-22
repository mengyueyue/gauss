package 字典数.hard;

/**
 * Created by mengyue on 2018/8/1.
 */
public class 前缀和后缀搜索 {

    public static void main(String[] args) {

        String[] strings = new String[]{"pop"};
        WordFilter obj = new WordFilter(strings);
        int param_1 = obj.f("", "op");
        System.out.println(param_1);
    }


    static class WordFilter {

        private String[] words;

        public WordFilter(String[] words) {
            this.words = words;
        }

        public int f(String prefix, String suffix) {
            String trim = "";
            for (int i = 0; i < words.length; i++) {
                char[] array = words[i].toCharArray();
                if (trim.equals(prefix) && trim.equals(suffix)) {
                    return i;
                }
                if (trim.equals(prefix)) {
                    return eq(array, suffix.toCharArray(), false) ? i : -1;
                }
                if (trim.equals(suffix)) {
                    return eq(array, prefix.toCharArray(), true) ? i : -1;
                }
                return eq(array, suffix.toCharArray(), false) && eq(array, prefix.toCharArray(), true) ? i : -1;
            }
            return -1;
        }

        /**
         * @param wordArray 被匹配单词char数组
         * @param array     前缀或后缀的char数组
         * @param pre       表示是否是前缀
         * @return
         */
        private boolean eq(char[] array, char[] wordArray, boolean pre) {
            if (wordArray.length > array.length) {
                return false;
            }
            if (pre) {
                for (int i = 0; i < wordArray.length; i++) {
                    if (array[i] != wordArray[i]) {
                        return false;
                    }
                }
            } else {

                for (int i = wordArray.length - 1, j = array.length - 1; i >= 0; i--, j--) {
                    if (array[j] != wordArray[i]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}


