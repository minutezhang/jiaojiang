package companies.google.wechat;

import utils.Utils;

import java.util.List;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Jul 11, 2016
 */
public class WordsFromString {
    /*
    Given a string,return the list of words. word is defined as the character squence between two spaces or two quotes.
    if space is contained between two quotes, the space will be considered as part of the word, e.g., string is
    "I have a "faux coat", return the list [I, have, a, faux coat]
     */
    public static List<String> wordsFromString(String sentence) {
        List<String> ret = new ArrayList<String>();

        StringBuilder sb = new StringBuilder();
        boolean quoted = false;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c == '"') {
                if (quoted) {
                    if (sb.length() != 0) {
                        ret.add(sb.toString());
                        sb.setLength(0);
                    }
                }
                // adc"de" is not valid
                quoted = !quoted;
            } else if (c == ' ' && !quoted) {
                if (sb.length() != 0) {
                    ret.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(c);
            }
        }

        if (sb.length() != 0) {
            ret.add(sb.toString());
        }

        return ret;
    }

    public static void main(String[] args) {
        Utils.printListln(wordsFromString("I have a faux coat"));
        Utils.printListln(wordsFromString("  I have   a    faux coat"));
        Utils.printListln(wordsFromString("I have a \"faux coat\""));
    }
}
