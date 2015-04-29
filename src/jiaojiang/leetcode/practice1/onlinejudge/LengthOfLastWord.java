package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: mizhang@akamai.com
 */
public class LengthOfLastWord {
    /*
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of non-space characters only.

    For example,
    Given s = "Hello World",
    return 5.
     */
    public static int lengthOfLastWord(String s) {
        String trimmed = s.trim();

        if (trimmed.isEmpty()) {
            return 0;
        }

        String[] words = trimmed.split("\\s+");
        return words[words.length - 1].length();
    }

    public static int lengthOfLastWord2(String s) {
        int l = 0;
        boolean newWord = true;
        for (int i = 0, n = s.length(); i < n; i++) {
            if (s.charAt(i) == ' ') {
                newWord = true;
            } else if (newWord){
                l = 1;
                newWord = false;
            } else {
                l++;
            }
        }

        return l;
    }

    public static void test() {
        System.out.println(lengthOfLastWord(" "));  //0
        System.out.println(lengthOfLastWord("    day ")); //3
        System.out.println(lengthOfLastWord("Hello World")); //5
        System.out.println(lengthOfLastWord("Today is a nice day")); //3
        System.out.println(lengthOfLastWord("day")); //3

        System.out.println();

        System.out.println(lengthOfLastWord2(" "));  //0
        System.out.println(lengthOfLastWord2("    day ")); //3
        System.out.println(lengthOfLastWord2("Hello World")); //5
        System.out.println(lengthOfLastWord2("Today is a nice day")); //3
        System.out.println(lengthOfLastWord2("day")); //3
    }

    public static void main(String[] args) {
        test();
    }
}
