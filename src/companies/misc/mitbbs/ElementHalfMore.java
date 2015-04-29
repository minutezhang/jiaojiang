package companies.misc.mitbbs;

import utils.Utils;

/**
 * @author: mizhang
 * @since: Oct 30, 2013 4:29:04 PM
 */
public class ElementHalfMore {
    /*
    Given an array, there is one element that occurs more than N/2 times, where N is the size of the array, find this
    element

    Solution: if two elemenet picked up from the array are different, remove both of them does not change the fact that
    the element occurs more then N/2 still occurs more than (N - 2)/2 times in the new array 
     */
    public static int find(int[] elements) {

        int element = 0, count = 0;

        for (int i : elements) {
            if (count == 0) {
                element = i;
            } else {
                if (element == i) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return element;
    }

    public static void test() {
        Utils.printTestln(find(new int[]{6, 2, 2, 6, 3, 4, 6, 6, 6, 6}), 6);
        Utils.printTestln(find(new int[]{6, 2, 2, 6, 6, 4, 6}), 6);
        Utils.printTestln(find(new int[]{6, 2, 2, 6, 3, 2, 2}), 2);
    }

    public static void main(String[] args) {
        test();
    }
}
