package companies.twosigma.mitbbs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author: mizhang
 * @time: 2/12/15 10:02 PM
 */
public class MissingElementInArithmeticProgression {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        if (n > 2500 || n < 3) {
            throw new IllegalArgumentException("Wrong size");
        }

        line = br.readLine();
        String[] aps = line.split("\\W+");
        if (aps.length != n) {
            throw new IllegalArgumentException("Sizes do not match");
        }

        int[] ap = new int[n];
        for (int i = 0; i < n; i++) {
            ap[i] = Integer.parseInt(aps[i]);
            if (ap[i] > 1000000 || ap[i] < -1000000) {
                return;
            }
        }

        int delta = ap[1] > ap[0] ? Math.min(ap[1] - ap[0], ap[2] - ap[1]) : Math.max(ap[1] - ap[0], ap[2] - ap[1]);
        for (int i = 1; i < n; i++) {
            if (ap[i] - ap[i - 1] != delta) {
                System.out.println(ap[i - 1] + delta);
                return;
            }
        }
    }
}
