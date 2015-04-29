package companies.twosigma.mitbbs;

/**
 * @author: zhang
 * @date: Mar 22, 2015 8:26:43 PM
 */
public class ITOA {
    /*
    int myitoa(char *buf, int size, unsigned int value, char padding) {
    test cases:
        5 345 @ ---> @@345
        5 12345 @ ---> 12345
        5 0 @ ---> @@@@0
        5 123456 @ ---> buffer is too short
     */
    public static boolean myitoa(char[] buf, int size, int value, char padding) {
        do{
            buf[size - 1] = (char)('0' + (value % 10));
            size--;
            value /= 10;
        } while (size > 0 && value > 0);

        for (; size > 0; buf[--size] = padding);

        return value == 0;
    }
}
