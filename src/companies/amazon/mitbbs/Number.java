package companies.amazon.mitbbs;

/**
 * @author: zhang
 * @since: Aug 1, 2010 11:00:08 PM
 */
public class Number {

    public static String convert2Roman(int integer) {
        String[][] roman = {{"I", "IV", "V", "IX"}, {"X", "XL", "L", "XC"}, {"C", "CD", "D", "CM"}};
        String thousand = "M";

        StringBuffer output = new StringBuffer();
        int digit;
        int base = 1000;

        //thousand
        digit = integer / base;
        integer -= digit * base;
        for (int i = 0; i < digit; i++) {
            output.append(thousand);
        }

        for (int index = 2; index >= 0; index--) {
            base /= 10;
            digit = integer / base;
            integer -= digit * base;
            
            if (digit == 4) {
                output.append(roman[index][1]);
                continue;
            }
            if (digit == 9) {
                output.append(roman[index][3]);
                continue;
            }

            if (digit >= 5) {
                output.append(roman[index][2]);
                digit -= 5;
            }
            
            for (int i = 0; i < digit; i++) {
                output.append(roman[index][0]);
            }
        }

        return output.toString();
    }

    public static void main(String[] argv) {
        System.out.println(convert2Roman(84));
    }
}
