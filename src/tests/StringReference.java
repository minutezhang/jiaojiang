package tests;

/**
 * @author: mizhang
 * @time: 2/12/15 10:37 AM
 */
public class StringReference {

    public static void pass(StringBuffer sb) {
        sb.append('0');
    }

    public static void pass(int i) {
        i++;
    }

    public static void pass(String s) {
        s += '0';
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("1");
        pass(sb);
        System.out.println(sb);

        int i = 0;
        pass(i);
        System.out.println(i);

        String s = new String("1");
        pass(s);
        System.out.println(s);


        String ss = "1";
        pass(ss);
        System.out.println(ss);

        String sss = new String("1");
        String ssss = "1";

        System.out.println(s == sss);
        System.out.println(ss == ssss);

        ssss += "1";
        System.out.println(ss == ssss);
    }
}
