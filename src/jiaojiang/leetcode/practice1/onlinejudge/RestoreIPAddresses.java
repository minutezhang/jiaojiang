package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;

/**
 * @author: mizhang
 * @since: May 3, 2013 1:38:03 PM
 */
public class RestoreIPAddresses {
    /*
    Given a string containing only digits, restore it by returning all possible valid IP address combinations.

    For example:
    Given "25525511135",

    return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
     */
    public static ArrayList<String> restoreIpAddresses(String s) {
        return restoreIpAddresses(s, 0, 0);
    }

    public static ArrayList<String> restoreIpAddresses(String s, int start, int nSeg) {
        ArrayList<String> ret = new ArrayList<String>();

        if (s.length() <= start) {
            return ret;
        }
        
        int num = 0, nextStartRange = Math.min(3, s.length() - start), index;

        if (s.charAt(start) == '0') {
            nextStartRange = 1;
        }

        if (nSeg == 3) {
            for (index = 0; index < nextStartRange && (num = num * 10 + s.charAt(start + index) - '0') < 256; index++);
            if (index + start < s.length()) {
                return ret;
            }
            ret.add(String.valueOf(num));
            return ret;
        }

        for (index = 0; index < nextStartRange && (num = num * 10 + s.charAt(start + index) - '0') < 256; index++) {
            for (String ip : restoreIpAddresses(s, start + index + 1, nSeg + 1)) {
                ret.add(num + "." + ip);
            }
        }

        return ret;
    }

    public static void test() {
        for (String s : restoreIpAddresses("25525511135")) {
            System.out.print(s + ", ");
        }

        System.out.println();

        for (String s : restoreIpAddresses("010010")) {
            System.out.print(s + ", ");
        }

    }

    public static void main(String[] args) {
        test();
    }


}
