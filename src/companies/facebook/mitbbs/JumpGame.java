package companies.facebook.mitbbs;

import utils.Utils;

/**
 * @author: zhang
 * @since: Feb 3, 2014 12:18:06 AM
 */
public class JumpGame {
    /*
    Gien an array, 0 represents a river and 1 represents a rock. The initial velocity is 1. You can accelarete at each rock
    by speed 1 or you can stay with the current speed. With speed n, you can jump a rive with width n. What is the minimal
    jump for the given array
     */
    public static int minJump(int[] array) {
        return 0;
    }

    private static void test() {
        Utils.printTestln(minJump(new int[]{1,1,1,0,1,1,0,0}), 3);
        Utils.printTestln(minJump(new int[]{1,1,1,0,1,1,1,0}), 3);
    }

    public static void main(String[] args) {
        test();
    }
}
