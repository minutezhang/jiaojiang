package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhang
 *
 * Created on Jun 26, 2016
 */
@SuppressWarnings("unchecked")
public class WordSearchII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, char[][].class, String[].class);
            Test.assertEquals(Arrays.asList("eat","oath"), (List<String>)method.invoke(null, new char[][] {
                    {'o','a','a','n'},
                    {'e','t','a','e'},
                    {'i','h','k','r'},
                    {'i','f','l','v'}}, new String[]{"oath","pea","eat","rain"}));

            Test.assertEquals(Arrays.asList("aa"), (List<String>)method.invoke(null, new char[][]{{'a', 'a'}},
                    new String[]{"aa"}));

            Test.assertEquals(Arrays.asList("a"), (List<String>)method.invoke(null, new char[][]{{'a'}}, new String[]{"a", "a"}));

            Test.assertEquals(Arrays.asList(), (List<String>)method.invoke(null, new char[][]{{'a', 'a'}}, new String[]{"aaa"}));

            Test.assertEquals(Arrays.asList("aabbbbabbaababaaaabababbaaba",
                    "abaabbbaaaaababbbaaaaabbbaab",
                    "ababaababaaabbabbaabbaabbaba"),
                    (List<String>)method.invoke(null, new char[][]{
                        "baabab".toCharArray(),
                        "abaaaa".toCharArray(),
                        "abaaab".toCharArray(),
                        "ababba".toCharArray(),
                        "aabbab".toCharArray(),
                        "aabbba".toCharArray(),
                        "aabaab".toCharArray()},
                    new String[]{"bbaabaabaaaaabaababaaaaababb",
                         "aabbaaabaaabaabaaaaaabbaaaba",
                         "babaababbbbbbbaabaababaabaaa",
                         "bbbaaabaabbaaababababbbbbaaa",
                         "babbabbbbaabbabaaaaaabbbaaab",
                         "bbbababbbbbbbababbabbbbbabaa",
                         "babababbababaabbbbabbbbabbba",
                         "abbbbbbaabaaabaaababaabbabba",
                         "aabaabababbbbbbababbbababbaa",
                         "aabbbbabbaababaaaabababbaaba",
                         "ababaababaaabbabbaabbaabbaba",
                         "abaabbbaaaaababbbaaaaabbbaab",
                         "aabbabaabaabbabababaaabbbaab",
                         "baaabaaaabbabaaabaabababaaaa",
                         "aaabbabaaaababbabbaabbaabbaa",
                         "aaabaaaaabaabbabaabbbbaabaaa",
                         "abbaabbaaaabbaababababbaabbb",
                         "baabaababbbbaaaabaaabbababbb",
                         "aabaababbaababbaaabaabababab",
                         "abbaaabbaabaabaabbbbaabbbbbb",
                         "aaababaabbaaabbbaaabbabbabab",
                         "bbababbbabbbbabbbbabbbbbabaa",
                         "abbbaabbbaaababbbababbababba",
                         "bbbbbbbabbbababbabaabababaab",
                         "aaaababaabbbbabaaaaabaaaaabb",
                         "bbaaabbbbabbaaabbaabbabbaaba",
                         "aabaabbbbaabaabbabaabababaaa",
                         "abbababbbaababaabbababababbb",
                         "aabbbabbaaaababbbbabbababbbb",
                         "babbbaabababbbbbbbbbaabbabaa"}));

            long start = System.nanoTime();
            Test.assertEquals(Arrays.asList(Utils.getStringArray("WordSearchII2_expected.data")),
                    (List<String>)method.invoke(null, new char[][]{"seenew".toCharArray(),
                                                        "tmriva".toCharArray(),
                                                        "obsibd".toCharArray(),
                                                        "wmysen".toCharArray(),
                                                        "ltsnsa".toCharArray(),
                                                        "iezlgn".toCharArray()},
                        Utils.getStringArray("WordSearchII2.data")));
            System.out.println("It took " + (System.nanoTime() - start) / 1000000 + " millis to finish the " + methodName + " test case");

            start = System.nanoTime();
            Test.assertEquals(Arrays.asList("aaaaaaaaaaaaaacd",
                        "aaaaaaaaaaaaaaae",
                        "aaaaaaaaaaaaaade",
                        "aaaaaaaaaaaaaabf",
                        "aaaaaaaaaaaaaaab",
                        "aaaaaaaaaaaaaaaa",
                        "aaaaaaaaaaaaaacg",
                        "aaaaaaaaaaaaaaad",
                        "aaaaaaaaaaaaaabc",
                        "aaaaaaaaaaaaaaac",
                        "aaaaaaaaaaaaaadh",
                        "aaaaaaaaaaaaaaei",
                        "aaaaaaaaaaaaaacb",
                        "aaaaaaaaaaaaaaed",
                        "aaaaaaaaaaaaaadc"),
                    (List<String>)method.invoke(null, new char[][]{"aaaa".toCharArray(),
                        "aaaa".toCharArray(),
                        "aaaa".toCharArray(),
                        "aaaa".toCharArray(),
                        "bcde".toCharArray(),
                        "fghi".toCharArray(),
                        "jklm".toCharArray(),
                        "nopq".toCharArray(),
                        "rstu".toCharArray(),
                        "vwxy".toCharArray(),
                        "zzzz".toCharArray()},
                    Utils.getStringArray("WordSearchII.data")));
            System.out.println("It took " + (System.nanoTime() - start) / 1000000 + " millis to finish the " + methodName + " test case");


        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
