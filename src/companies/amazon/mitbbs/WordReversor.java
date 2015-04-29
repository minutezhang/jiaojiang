package companies.amazon.mitbbs;

/**
 * @author: zhang
 * @since: Jul 26, 2010 10:18:42 PM
 */
public class WordReversor {

    public static String reverseWord(String input) {
        StringBuffer sb = new StringBuffer();

        int from = input.length() - 1;
        int to = input.length();

        for (; from >= 0; from--) {
            if(input.charAt(from) == ' ') {
                copy(sb, input, from + 1, to);
                sb.append(' ');
                to = from;
            }
        }

        copy(sb, input, from + 1, to);

        return sb.toString();
    }

    public static void copy(StringBuffer sb, String input, int from, int to) {
        for (int i = from; i < to; i++) {
            sb.append(input.charAt(i));
        }

    }

    public static void main(String[] argv) {
        String input = "hello world hello xiaohuiqing";
        System.out.println(reverseWord(input));
    }
}
