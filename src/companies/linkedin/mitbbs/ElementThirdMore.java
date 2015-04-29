package companies.linkedin.mitbbs;

import utils.Utils;

/**
 * @author: mizhang
 * @since: Oct 30, 2013 4:55:17 PM
 */
public class ElementThirdMore {
    /*
    Given an array, one element occurs more than N/3 times, where N is the length of the array. Find this element.
     */

    public static int find(int[] elements) {
        int[] count = new int[2];
        int[] element = new int[2];

        for (int i : elements) {
            if (count[0] == 0 && count[1] == 0 || count[0] == 0 && element[1] != i) {
                count[0]++;
                element[0] = i;
            } else if (count[1] == 0 && element[0] != i) {
                element[1] = i;
            } else if (count[0] != 0 && element[0] == i) {
                count[0]++;
            } else if (count[1] != 0 && element[1] == i) {
                count[1]++;
            } else {
                count[0]--;
                count[1]--;
            }
        }

        return count[0] == 0 ? element[1] : element[0];
    }

    public static void test() {
        Utils.printTestln(find(new int[]{6, 2, 2, 6, 3, 4, 6, 6, 6, 6}), 6);
        Utils.printTestln(find(new int[]{6, 2, 2, 4, 3, 4, 3, 6, 6, 6}), 6);
        Utils.printTestln(find(new int[]{4, 5, 6, 7, 8, 4, 4}), 4);
    }
    
    public static void main(String[] args) {
        test();
    }
}
