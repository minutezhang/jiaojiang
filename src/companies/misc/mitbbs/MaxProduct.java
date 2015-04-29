package companies.misc.mitbbs;

/**
 * @author: mizhang
 * @since: Sep 5, 2013 3:56:46 PM
 */
public class MaxProduct {

    public static int maxProduct(int[] data) {

        int maxProd = Integer.MIN_VALUE, prod = 1, start = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) {
                if (prod < 0) {
                    prod = findMax(data, start, i, prod);
                }

                maxProd = Math.max(Math.max(prod, maxProd), 0);
                start = i + 1;
                prod = 1;
            } else {
                prod *= data[i];
            }
        }

        return Math.max(maxProd, findMax(data, start, data.length, prod));
    }

    private static int findMax(int[] data, int start, int end, int prod) {

        if (end - start == 1 || prod > 0) {
            return prod;
        }

        int i = start, j = end - 1, leftProd = data[i], rightProd = data[end - 1];
        while (i < end && data[i] > 0) {
            leftProd *= data[++i];
        }

        while (j > i && data[j] > 0) {
            rightProd *= data[--j];
        }

        return leftProd > rightProd ? prod / leftProd : prod / rightProd;
    }


    public static long maxProduct2(int[] data) {

        int start = 0, firstNegative = Integer.MIN_VALUE, secondNegative = Integer.MIN_VALUE;

        long firstProd = 0, secondProd = 0, lastProd = 0, prod = 1, maxProd = 0;

        while (start < data.length) {
            while (start < data.length && data[start] != 0) {
                int i = start;
                while (i < data.length && data[i] > 0) {
                    prod *= data[i];
                }

                if (i > start) {
                    firstProd = prod;
                    firstNegative = data[i];
                }

            }
            start++;
        }

        return prod;
    }

    public static void test() {
        System.out.println(maxProduct(new int[]{6, -3, -10, 0, 2}));  //180
        System.out.println(maxProduct(new int[]{-1, -3, -10, 0, 60}));  //60
        System.out.println(maxProduct(new int[]{-2, -3, 0, -2, -40}));  //80
        System.out.println(maxProduct(new int[]{-2, 0, -3, 0, -2, 0, -40}));  //0
        System.out.println(maxProduct(new int[]{-2}));  //-2
        System.out.println(maxProduct(new int[]{9, 10, 15, 24, -1, 5, 6, 7, -2, 10, 19, 29}));  //1360800

        System.out.println(maxProduct2(new int[]{6, -3, -10, 0, 2}));  //180
        System.out.println(maxProduct2(new int[]{-1, -3, -10, 0, 60}));  //60
        System.out.println(maxProduct2(new int[]{-2, -3, 0, -2,-40}));  //80
        System.out.println(maxProduct2(new int[]{-2, 0, -3, 0, -2, 0, -40}));  //0
        System.out.println(maxProduct2(new int[]{-2}));  //-2
        System.out.println(maxProduct2(new int[]{9, 10, 15, 24, -1, 5, 6, 7, -2, 10, 19, 29}));  //1360800
    }

    public static void main(String[] args) {
        test();
    }
}
