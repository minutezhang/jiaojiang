package companies.twosigma.mitbbs;

import java.util.Random;

/**
 * @author: zhang
 * @date: Mar 21, 2015 10:47:54 PM
 */
public class RandomPasswordGenerator {
    //Generate random password which has length [start, end] and has lower case letter, upper case letter
    public static String generate(int start, int end) {
        StringBuffer password = new StringBuffer();
        Random r = new Random();

        int length = r.nextInt(end - start + 1) + start;
        for (int i = 0; i < length; i++) {
            int letter = r.nextInt(52);
            password.append((char)(letter < 26 ? 'a' + letter : 'A' + letter - 26));
        }

        return password.toString();
    }
}
