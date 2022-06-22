package jiaojiang.leetcode.practice5.onlinejudge;

public class RemoveBoxes {
    /**
     * You are given several boxes with different colors represented by different positive numbers.
     * <p>
     * You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (i.e., composed of k boxes, k >= 1), remove them and get k * k points.
     * <p>
     * Return the maximum points you can get.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: boxes = [1,3,2,2,2,3,4,3,1]
     * Output: 23
     * Explanation:
     * [1, 3, 2, 2, 2, 3, 4, 3, 1]
     * ----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
     * ----> [1, 3, 3, 3, 1] (1*1=1 points)
     * ----> [1, 1] (3*3=9 points)
     * ----> [] (2*2=4 points)
     * <p>
     * Example 2:
     * <p>
     * Input: boxes = [1,1,1]
     * Output: 9
     * <p>
     * Example 3:
     * <p>
     * Input: boxes = [1]
     * Output: 1
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= boxes.length <= 100
     * 1 <= boxes[i] <= 100
     */
    public static int removeBoxes(int[] boxes) {
        int maxPoint = 0;
        for (int i = 0; i < boxes.length; ) {
            int j;
            for (j = i + 1; j < boxes.length && boxes[j] == boxes[i]; ++j) ;
            int[] newBoxes = new int[boxes.length - j + i];
            System.arraycopy(boxes, 0, newBoxes, 0, i);
            System.arraycopy(boxes, j, newBoxes, i, boxes.length - j);
            maxPoint = Math.max((j - i) * (j - i) + removeBoxes(newBoxes), maxPoint);
            i = j;
        }
        return maxPoint;
    }
}
