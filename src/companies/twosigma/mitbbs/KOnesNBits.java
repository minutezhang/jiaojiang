package companies.twosigma.mitbbs;

import java.util.List;
import java.util.ArrayList;

/**
 * @author: zhang
 * @date: Mar 19, 2015 7:20:58 PM
 */
public class KOnesNBits {
    /*
    print out all the n bit long binary number with exactly k 1s
     */
    public static List<Integer> kOnesNBits(int k, int n) {
        List<Integer> ret = new ArrayList<Integer>();
        kOnesNBits(k, n, 0, 0, 0, ret);
        
        return ret;
    }

    private static void kOnesNBits(int k, int n, int number, int nk, int nn, List<Integer> ret) {
        if (nn > n || nk > k) {
            return;
        }

        if (nk == k && n == nn) {
            ret.add(number);
        } else {
            kOnesNBits(k, n, number << 1, nk, nn + 1, ret);
            kOnesNBits(k, n, (number << 1) + 1, nk + 1, nn + 1, ret);
        }
    }
}
