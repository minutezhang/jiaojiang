package companies.walmartlab.mitbbs;

/**
 * @author: mizhang
 * @since: Oct 4, 2013 10:22:01 AM
 */
public class BalancedPartition {

    public static int balancedPartition(int[] data) {
        int sum = 0;

        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }

        int halfSum = sum >> 1;
        int[] bp = new int[halfSum + 1];
        int[] bp2 = new int[halfSum + 1];

        bp[0] = 1;
        if (data[0] > halfSum) {
            return data[0] + data[0] - sum;
        }

        bp[data[0]] = 1;

        for (int i = 1; i < data.length; i++) {
            if (data[i] > halfSum) {
                return data[i] + data[i] - sum;
            }
            for (int j = 0; j < bp.length; j++) {
                if (bp[j] == 1 || j - data[i] >= 0 && bp[j - data[i]] == 1) {
                    bp2[j] = 1;
                } else {
                    bp2[j] = 0;
                }
            }

            int[] tmp = bp2;
            bp2 = bp;
            bp = tmp;
        }

        int index = bp.length - 1;
        while (bp[index] == 0) {
            index--;
        }

        return sum - index - index;
    }

    public  static void test() {
        System.out.println(balancedPartition(new int[] {0, 14, 6, 3, 7}));        //2
        System.out.println(balancedPartition(new int[] {23, 13, 11, 25, 21, 26}));   //1
        System.out.println(balancedPartition(new int[] {23, 13, 10, 25, 21, 26}));   //0
        System.out.println(balancedPartition(new int[] {7, 24, 11, 26, 2, 15, 10}));   //1
        System.out.println(balancedPartition(new int[] {700, 24, 11, 26, 2, 15, 10}));  //612
        System.out.println(balancedPartition(new int[] {10, 24, 11, 26, 2, 15}));     //2
    }

    public static void main(String[] args) {
        test();
    }
}