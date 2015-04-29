package companies.misc.mitbbs;

import java.util.Random;

/**
 * @author: zhang
 * @since: Apr 4, 2013 9:15:07 PM
 */
public class RandomGenerator {

    private final static Random r = new Random();

    public static int get01() {
        return r.nextInt(2);
    }

    public static int get(int n) {
        int nn, ret;
        do {
            nn = n;
            ret = 0;
            while (nn > 0) {
                ret = (ret << 1) + get01();
                nn >>= 1;
            }
        } while (ret >= n);

        return ret;
    }

    public static void main(String[] args) {
        int[] count = new int[10];
        for (int i = 0; i < 100000; i++) {
            count[get(10)]++;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(i + " : " + count[i]);
        }
    }
}
