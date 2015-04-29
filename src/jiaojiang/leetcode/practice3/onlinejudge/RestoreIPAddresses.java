package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/11/15 11:55 PM
 */
public class RestoreIPAddresses {
    /*
    Given a string containing only digits, restore it by returning all possible valid IP address combinations.

    For example:
    Given "25525511135",

    return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
     */
    public static List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        restoreIpAddresses(s, 0, "", 0, ret);

        return ret;
    }

    private static void restoreIpAddresses(String s, int start, String prefix, int numOctets, List<String> ips) {
        if (s.length() - start > (4 - numOctets) * 3 || s.length() - start < 4 - numOctets) {
            return;
        }

        if (start == s.length() && numOctets == 4) {
            ips.add(prefix);
            return;
        }

        if (s.charAt(start) == '0') {
            restoreIpAddresses(s, start + 1, start > 0 ? prefix + ".0": "0", numOctets + 1, ips);
        } else {
            for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
                String octet = s.substring(start, start + i);
                if (Integer.parseInt(octet) < 256) {
                    restoreIpAddresses(s, start + i, start > 0 ? prefix + "." + octet : octet, numOctets + 1, ips);
                }
            }
        }
    }
}
