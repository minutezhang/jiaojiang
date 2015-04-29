package companies.amazon.mitbbs;

/**
 * @author: zhang
 * @since: Jul 26, 2010 10:07:24 PM
 */
public class Palindromic {
    public static boolean isPalindromic(int integer) {
        byte[] barray = new byte[32];
        int length = 0;
        while (integer > 0) {
            barray[length++] = (byte)(integer%10);
            integer /= 10;
        }

        for (int i = 0, n = length / 2 - 1; i < n; i++) {
            if(barray[i] != barray[length - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] argv) {
        int a = 123454321;
        System.out.println(isPalindromic(a));
        a = 12344321;
        System.out.println(isPalindromic(a));
        a = 1234;
        System.out.println(isPalindromic(a));
    }
}
