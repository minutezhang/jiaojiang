package tests;

/**
 * @author: mizhang
 * @time: 2/24/15 2:59 PM
 */
public class CompareDouble {

    public static void main(String[] args) {
        System.out.println("== Compare Double ==");
        Double pZero = new Double(0);
        Double nZero = new Double(-0.0);
        Double ppZero = new Double(0.0);
        System.out.println(pZero.equals(nZero));
        System.out.println(pZero.equals(ppZero));

        System.out.println(Double.compare(-0.0, 0.0));
        System.out.println(Double.compare(0.0, 0.0));
        System.out.println(-0.0 == 0.0);
        System.out.println(0.0 == 0.0);
    }
}
