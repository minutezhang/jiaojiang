package companies.misc.mitbbs;

import utils.Utils;

/**
 * @author: zhang
 * @since: Dec 10, 2013 10:51:33 PM
 */
public class FirstAndSecondLargest {
    /*
    find the first and second largest number from an integer array. Assume the length of the array is power of 2
     */
    public static int[] find1st2ndLargest(int[] data) {
        int[] buffer = new int[data.length - 1];

        int index = 0;
        for (int i = 0; i < data.length; i += 2) {
            buffer[index++] = Math.max(data[i], data[i + 1]);
        }

        return null;
    }

    private static void test() {
        Utils.printTestArrayln(find1st2ndLargest(new int[]{10,9,5,4,11,100,120,110}), new int[]{120, 110});
    }

    public static void main(String[] args) {
        test();
    }
}
