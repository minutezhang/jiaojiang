package companies.misc.mitbbs;

import java.util.List;
import java.util.ArrayList;

/**
 * @author: zhang
 * @since: Apr 3, 2013 11:27:39 PM
 */
public class PrimeFactorization {
    public static List<Integer> getUniquePrimeFactor(int number) {
        List<Integer> factors = new ArrayList<Integer>();

        boolean[] flag = new boolean[number - 2];

        for (int i = 0; i < flag.length; i++) {
            if (!flag[i]) {
                int index, j = 2;
                while ( (index = (i + 2) * j++) < number ) {
                    flag[index - 2] = true;
                }

                if (index == number) {
                    factors.add(i + 2);
                }
            }
        }

        return factors;
    }

    public static List<Integer> getPrimeFactorization(int number) {
        List<Integer> factors = getUniquePrimeFactor(number);

        for (int i = 0, n = factors.size(); i < n; i++) {
            int f = factors.get(i);
            number /= f;
            while (number % f == 0) {
                number /= f;
                factors.add(f);
            }
        }

        return factors;
    }

    public static void testUPF() {
        for (int i : getUniquePrimeFactor(1000)) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int i : getUniquePrimeFactor(1024)) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int i : getUniquePrimeFactor(999)) {
            System.out.print(i + "\t");
        }
        System.out.println();

//        for (int i : getUniquePrimeFactor(1002934563)) {
//            System.out.print(i + "\t");
//        }
//        System.out.printTestln();
    }

    public static void testPF() {
        for (int i : getPrimeFactorization(1000)) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int i : getPrimeFactorization(1024)) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int i : getPrimeFactorization(999)) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        testPF();
    }
}
