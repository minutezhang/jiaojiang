package companies.misc.mitbbs;

/**
 * @author: zhang
 * @since: Apr 3, 2013 10:09:37 PM
 */
public class FirstMissingNumber {
    public static int findFirstMissing(int[] list) {
        for(int i = 0; i < list.length; i++) {
            while (list[i] != i + 1 && list[i] - 1 < list.length) {
                int tmp = list[list[i] - 1];
                list[list[i] - 1] = list[i];
                list[i] = tmp;
            }
        }

        for(int i = 0; i < list.length; i++) {
            if (list[i] != i + 1) {
                return i + 1;
            }
        }

        return list.length + 1;

    }

    public static void testFFM() {
        System.out.println(findFirstMissing(new int[]{3,2,7,8,1}));
        System.out.println(findFirstMissing(new int[]{5,4,3,2,1}));
        System.out.println(findFirstMissing(new int[]{1,2,4,5,6}));
    }

    public static void main(String[] args) {
        testFFM();
    }
    
}
