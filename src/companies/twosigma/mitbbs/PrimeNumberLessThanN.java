package companies.twosigma.mitbbs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/12/15 10:25 PM
 */
public class PrimeNumberLessThanN {
    static int getNumberOfPrimes(int N) {
        if (N <= 3) {
            return N - 2;
        }
        List<Integer> primes = new ArrayList<Integer>();
        for (int i = 3; i < N; i += 2) {
            if (isPrime(i, primes)) {
                primes.add(i);
            }
        }
        return primes.size() + 1;
    }

    private static boolean isPrime(int n, List<Integer> primes) {
        int end = (int)Math.sqrt(n);
        for (int i = 0; i < primes.size() && primes.get(i) <= end; i++) {
            if (n % primes.get(i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(getNumberOfPrimes(100));
        System.out.println(getNumberOfPrimes(1000000));
    }
}
