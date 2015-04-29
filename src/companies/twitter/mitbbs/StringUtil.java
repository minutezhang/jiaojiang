package companies.twitter.mitbbs;

import java.util.*;

/**
 * @author: zhang
 * @since: Feb 10, 2013 9:54:11 PM
 */
public class StringUtil {

    public static boolean doesMatch(String s, String p) {
        return doesMatchHelper(s, 0, p, 0);
    }

    public static boolean doesMatchHelper(String s, int ss, String p, int ps) {
        if (p.length() == ps) {
            return s.length() == ss;
        }

        if (ps == p.length() - 1 || p.charAt(ps + 1) != '*') {
            return (s.charAt(ss) == p.charAt(ps) || p.charAt(ps) == '.' && ss + 1 < s.length()) && doesMatchHelper(s, ss + 1, p, ps + 1);
        }

        // the next char is not '*'
        while ( s.charAt(ss) == p.charAt(ps) || p.charAt(ps) == '.' && ss + 1 < s.length()) {
            if (doesMatchHelper(s, ss, p, ps + 2)) {
                return true;
            }
            ss++;
        }

        return doesMatchHelper(s, ss, p, ps + 2);
    }

    public static int longestNonRepeatingSubstring(String s) {

        int start = 0, end = 0, longest = 0;

        int[] hasUsed = new int[256];

        for (; end < s.length(); end++) {
            if (hasUsed[s.charAt(end)] != 0) {
                if (end - start > longest ) {
                    longest = end - start;
                }
                for (int k = start; k < hasUsed[s.charAt(end)] - 1; k++) {
                    hasUsed[s.charAt(k)] = 0;
                }
                start =  hasUsed[s.charAt(end)];
            }
            hasUsed[s.charAt(end)] = end + 1;
        }

        if (end - start > longest) {
            longest = end - start;
        }

        return longest;

    }

    public static String getMinWindowNoDup(String s, String t) {
        int[] minMax = null;
        int length = 0, minLenth = Integer.MAX_VALUE;

        Map<Character, Integer> indices = new HashMap<Character, Integer>();

        for (int i = 0 ; i < t.length(); i++) {
            indices.put(t.charAt(i), -1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (indices.containsKey(c)) {
                if (indices.get(c) == -1) {
                    length++;
                }
                indices.put(c, i);

                if (length == t.length()) {
                    int[] tmp = getMinMax(indices.values());

                    if (tmp[1] - tmp[0] < minLenth) {
                        minLenth =  tmp[1] - tmp[0];
                        minMax = tmp;
                    }
                }
            }
        }

        return s.substring(minMax[0], minMax[1] + 1);
    }

    public static String getMinWindow(String s, String t) {
        int start = 0, end = 0, totalMatch = 0, minStart = 0, minEnd = 0, minLength = Integer.MAX_VALUE;

        Map<Character, Integer> hasMatched = new HashMap<Character, Integer>();
        Map<Character, Integer> numberOfChars = new HashMap<Character, Integer>();

        for (int i = 0, n = t.length(); i < n; i++) {
            char c = t.charAt(i);
            if (numberOfChars.containsKey(c)) {
                numberOfChars.put(c, numberOfChars.get(c) + 1);
            } else {
                numberOfChars.put(c, 1);
            }

            hasMatched.put(c, 0);
        }

        while (end < s.length()) {
            char cEnd = s.charAt(end);

            if (hasMatched.containsKey(cEnd)) {
                hasMatched.put(cEnd, hasMatched.get(cEnd) + 1);

                if (hasMatched.get(cEnd) <= numberOfChars.get(cEnd)) {
                    totalMatch++;
                } else {
                    while (start < end) {
                        char cStart = s.charAt(start);

                        if (hasMatched.containsKey(cStart) && hasMatched.get(cStart) <= numberOfChars.get(cStart)) {
                            break;
                        }

                        start++;

                        if (hasMatched.containsKey(cStart)) {
                            hasMatched.put(cStart, hasMatched.get(cStart) - 1);
                        }
                    }
                }

                if (totalMatch == t.length() && end - start < minLength) {
                    minLength = end - start;
                    minStart = start;
                    minEnd = end;
                }
            }

            end++;
        }

       // below part is same as the above part
//        while (end < s.length()) {
//            char cEnd = s.charAt(end);
//
//            if (hasMatched.containsKey(cEnd)) {
//                hasMatched.put(cEnd, hasMatched.get(cEnd) + 1);
//
//                if (hasMatched.get(cEnd) <= numberOfChars.get(cEnd)) {
//                    totalMatch++;
//                    if (totalMatch == t.length()) {
//                        if (end - start < minLength) {
//                            minLength = end - start;
//                            minStart = start;
//                            minEnd = end;
//                        }
//                    }
//                } else {
//                    while (start < end) {
//                        char cStart = s.charAt(start);
//                        if (hasMatched.containsKey(cStart) && hasMatched.get(cStart) <= numberOfChars.get(cStart)) {
//                            if (totalMatch == t.length() && end - start < minLength) {
//                                    minLength = end - start;
//                                    minStart = start;
//                                    minEnd = end;
//                            }
//                            break;
//                        }
//                        start++;
//                        if (hasMatched.containsKey(cStart)) {    //equivalent to hasMatch.get(cSstart) > numberOfChars.get(cStart)
//                            hasMatched.put(cStart, hasMatched.get(cStart) - 1);
//                        }
//                    }
//                }
//            }
//
//            end++;
//        }



        return s.substring(minStart, minEnd + 1);
    }

    public static int[] getMinMax(Collection<Integer> indices) {
        int[] minMax = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

        for (int i: indices) {
            
            if (i < minMax[0]) {
                minMax[0] = i;
            }

            if ( i > minMax[1]){
                minMax[1] = i;
            }
        }

        return minMax;
    }

    public static String removeComment(String line) {
        StringBuffer sb = new StringBuffer();
        boolean shouldSkip = false, isDoubleSlash = false;

        for (int i = 0, n = line.length(); i < n; i++) {
            char nextC, c = line.charAt(i);
            if (!shouldSkip) {
                if(c == '/' && i + 1 < n && ((nextC = line.charAt(i + 1)) == '/' || nextC == '*')) {
                    shouldSkip = true;
                    isDoubleSlash = nextC == '/';
                    i++;
                } else {
                    sb.append(c);
                }
            } else {
                if (isDoubleSlash && (c == '\n' || c == '\r')) {
                    sb.append(c);
                    shouldSkip = false;
                } else if (!isDoubleSlash && c == '*' && i + 1 < n && line.charAt(i + 1) == '/') {
                    shouldSkip = false;
                    i++;
                }
            }
        }

        return sb.toString();
    }

    public static void testMinWindonw() {
        System.out.println(getMinWindowNoDup("adobecodebanc", "abc")); //"banc"
        System.out.println(getMinWindowNoDup("abbaodebanc", "abc")); //"banc"
        System.out.println(getMinWindow("adobecodebanc", "abc")); //"banc"
        System.out.println(getMinWindow("abbaodebanc", "abc")); //"banc"
        System.out.println(getMinWindow("acbbaca", "aba"));
    }

    public static void testDoesMath() {
        String[] s = {"abbbc", "ac", "abbc", "abcbcd"};
        String[] p = {"ab*c", "ab*c", "ab*bbc", "a.*c.*d"};
        for (int i = 0; i < s.length; i++) {
            System.out.println(doesMatch(s[i], p[i]));
        }
    }

    public static void testRemoveComment() {
        System.out.println(removeComment("abc//xyz\nwwe*/*sdfsd/*sdfda*/sd*/cvcd")); // it should print "abc\nwwe*sd*/cvcd"
    }

    public static void main(String[] args) {
//        testMinWindonw();
        testRemoveComment();
    }
}
