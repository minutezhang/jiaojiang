package companies.twitter.mitbbs;

import utils.Utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @author: zhang
 * @since: Dec 25, 2013 11:00:38 PM
 */
public class BalanceNumber {
    public static List<int[]> findBalanceNumbers(int[][] array) {
        int[] rowLeft = new int[array[0].length];
        int[] colUp = new int[array.length];
        int sum;

        Map<Integer, List<Integer>> indices = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < colUp.length; i++) {
            rowLeft[0] = 0;
            for (int j = 1; j < rowLeft.length; j++) {
                rowLeft[j] = array[i][j - 1] + rowLeft[j - 1];
            }
            sum = 0;
            for (int j = rowLeft.length - 1; j >= 0; j--) {
                if (sum == rowLeft[j]) {
                    if (!indices.containsKey(j)) {
                        indices.put(j, new ArrayList<Integer>());
                    }
                    indices.get(j).add(i);
                }
                sum += array[i][j];
            }
        }

        List<int[]> ret  = new ArrayList<int[]>();
        
        for (int k : indices.keySet()) {
            colUp[0] = 0;
            for (int i = 1; i < colUp.length; i++) {
                colUp[i] = colUp[i - 1] + array[i - 1][k];
            }
            sum = 0;
            for (int i = colUp.length - 1; i >= 0; i--) {
                if (sum == colUp[i]) {
                    ret.add(new int[]{i, k});
                }
                sum += array[i][k];
            }
        }

        return ret;
    }


    private static void test() {
        int[][] array = new int[][]{
                {4, 2, 3, 4},
                {4, 3, 2, 2},
                {1, 0, -1, 4},
                {3, 2, 1, 6}
        };
        for (int[] index : findBalanceNumbers(array)) {
            System.out.println(index[0] + ", " + index[1]);
        }
    }

    public static void main(String[] args) {
        test();
    }
}
