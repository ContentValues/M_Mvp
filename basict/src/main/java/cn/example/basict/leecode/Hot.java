package cn.example.basict.leecode;

import java.util.HashSet;

/**
 * Author：created by SugarT
 * Time：2019/12/15 20
 */
public class Hot {

    public static void main(String args[]) {

//       int[]guess = {1,2,3};
//       int[]answer = {1,2,3};
//
//        System.out.println(game(guess,answer));


        System.out.println(reverseString("abc".toCharArray()));


//        System.out.println(countSubstrings("aaa"));

    }


    public static int game(int[] guess, int[] answer) {

        int count = 0;
        for (int i = 0, j = 0; i < guess.length && j < answer.length; i++, j++) {

            if (guess[i] == answer[j]) {
                ++count;
            }
        }
        return count;

    }


    public static int countSubstrings(String origin) {

        int count = 0;
        for (int i = 0; i < origin.length(); i++) {
            String str = "";
            for (int j = i; j < origin.length(); j++) {
                str = str + origin.charAt(j);
                if (str.equals(String.valueOf(reverseString(str.toCharArray())))) {
                    ++count;
                }
            }
        }
        return count;
    }


    /**
     * 字符串反转
     *
     * @param s1
     * @return
     */
    public static char[] reverseString(char[] s1) {

        char[] temp = s1;
        for (int i = 0; i < temp.length / 2; i++) {
            char character = temp[i];
            temp[i] = temp[temp.length - 1 - i];
            temp[temp.length - 1 - i] = character;
        }
        return temp;
    }

    /**
     * 判断是否是回文字符串
     * 解法1  把原字符串反转 再和原字符串比较
     * 解法2  比较前后字符是否相等
     *
     * @param s
     * @return
     */
    public static boolean isRalindrome(String s) {

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        String longPalind = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String str = s.substring(i,j+1);
                if (isRalindrome(str)) {
                    if (str.length() > max) {
                        max = str.length();
                        longPalind = str;
                    }
                }
            }
        }
        return longPalind;
    }

}
