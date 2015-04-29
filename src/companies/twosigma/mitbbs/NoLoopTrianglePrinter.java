package companies.twosigma.mitbbs;

/**
 * @author: zhang
 * @date: Mar 21, 2015 11:08:07 PM
 */
public class NoLoopTrianglePrinter {
    /*
    Without use of for or while loop, print the below triangle

*****
****
***
**
*
    end
     */
    public static String print(int n) {
        return n == 1 ? "*" : printHelp(n) + "\n" + print(n - 1); 
    }

    private static String printHelp(int n) {
        return n == 0 ? "" : "*" + printHelp(n - 1);
    }
}
