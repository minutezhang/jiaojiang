package companies.misc.mitbbs;

/**
 * @author: mizhang
 * @since: Aug 7, 2013 3:16:26 PM
 */
public class HousePainter {

    /*
     *  There are "N" houses, where N is some integer. Each house can be painted in either Red, Green or Blue. The
     * cost of coloring each house in each of the colors is different. Figure out how to color each house so no two
     * adjacent houses have the same color and the total cost of coloring all the houses is as low as possible.
    */

    // Assume H_{ic} is the cost of ith house with color c, T_{i, c} is the minimal total cost when ith house is painted with
    // color c. Then the minimal cost = min {
    //     H_{nR} + min{ T_{n - 1, G}, T_{n - 1, B} }
    //     H_{nG} + min{ T_{n - 1, R}, T_{n - 1, B} }
    //     H_{nB} + min{ T_{n - 1, R}, T_{n - 1, G} }
    //  }
    //
    public static int paintHouses(int[][] costs) {
        int[] minCost = new int[]{0, 0, 0};
        int[] tmpCost = new int[3];

        for (int[] cost : costs) {
            tmpCost[0] = cost[0] + Math.min(minCost[1], minCost[2]);
            tmpCost[1] = cost[1] + Math.min(minCost[0], minCost[2]);
            tmpCost[2] = cost[2] + Math.min(minCost[0], minCost[1]);
            System.arraycopy(tmpCost, 0, minCost, 0, 3);
        }
        return Math.min(minCost[0], Math.min(minCost[1], minCost[2]));
    }

    public static int[][] getCostArray() {
        return new int[][]{
                {1, 2, 3},
                {3, 2, 1},
                {1, 1, 1},
                {2, 1, 4}
        };
    }

    public static int[][] getCostArray2() {
        return new int[][] {
                {2, 2, 1},
                {1, 2, 3}
        };
    }

    public static int[][] getCostArray3() {
        return new int[][]{
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        };
    }

    public static int[][] getCostArray4() {
        return new int[][] {
                {1, 2, 2},
                {4, 10, 10}
        };
    }

    public static void test() {
        System.out.println(paintHouses(getCostArray()));     //4
        System.out.println(paintHouses(getCostArray2()));    //2
        System.out.println(paintHouses(getCostArray3()));    //4
        System.out.println(paintHouses(getCostArray4()));    //6  greedy does not work
    }

    public static void main(String[] args) {
        test();
    }
    
}
