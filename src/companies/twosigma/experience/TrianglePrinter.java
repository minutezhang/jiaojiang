package companies.twosigma.experience;

/**
 * @author: zhang
 * @date: Mar 23, 2015 9:02:54 PM
 */
public class TrianglePrinter {
    /*
    Gien an double, which is the length of edge of a triangle, print the triangle. Assume X is a pixel with 1 by 1 size
     */
    public static String print(double length) {
        StringBuffer ret = new StringBuffer();
        double width = 2 / Math.sqrt(3.0);
        for (double i = 1; i < length * Math.sqrt(3.0) / 2 + 1; i++) {
            ret.append(printLine(width * i, length));
        }

        return ret.toString();
    }

    private static String printLine(double width, double length) {
        StringBuffer line = new StringBuffer();
        int nWhites = (int) Math.round((length - width) / 2);
        for (int i = 0; i < nWhites; i++) {
            line.append(' ');
        }
        for (int i = 1; i <= width; i++) {
            line.append('x');
        }
        line.append('\n');
        
        return line.toString();
    }
}
