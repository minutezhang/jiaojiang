package companies.twosigma.mitbbs;

/**
 * @author: zhang
 * @date: Mar 21, 2015 10:19:40 PM
 */
public class FizzBuzz {
    /*
     Based on a traditional English children's game
    Print the numbers 1..100
    For multiples of 3, print "Fizz" instead of the number
    For multiples of 5, print "Buzz" instead of the number
    For multiples of 3 and 5, print "FizzBuzz" instead of the number
     */
    public static String getFizzBuzz(int n) {
        StringBuffer ret = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    ret.append("fizzbuzz ");
                } else {
                    ret.append("fizz ");
                }
            } else if (i % 5 == 0) {
                ret.append("buzz ");
            } else {
                ret.append(i + " ");
            }
        }

        ret.setLength(ret.length() - 1);
        return ret.toString();
    }
}
