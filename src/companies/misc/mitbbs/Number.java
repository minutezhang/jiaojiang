package companies.misc.mitbbs;

import java.util.List;
import java.util.ArrayList;

/**
 * @author: zhang
 * @since: Apr 2, 2013 10:55:30 PM
 */
public class Number {
    protected List<Integer> digits;

    public Number(int number) {
        digits = new ArrayList<Integer>();

        if (number == 0) {
            digits.add(0);
            return;
        }

        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
    }

    public void print() {
        for (int i = digits.size() - 1; i >= 0; i--) {
            System.out.print(digits.get(i));
        }
        System.out.println();
    }

    public void increment() {
        int digit, index = 0;
        if ((digit = digits.get(index)) != 9)  {
            digits.set(index, digit + 1);
            return;
        }

        while (index < digits.size()) {
            if ( (digit = digits.get(index)) != 9 ) {
                digits.set(index, digit + 1);
                break;
            } else {
                digits.set(index, 0);
            }
            index++;
        }

        if (index == digits.size()) {
            digits.add(1);
        }
    }

    public void add(Number n) {
        int sum, carrier = 0, size = Math.min(digits.size(), n.digits.size());

        for (int i = 0; i < size; i++) {
            sum = digits.get(i) + n.digits.get(i) + carrier;
            if (sum > 9) {
                digits.set(i, sum - 10);
                carrier = 1;
            } else {
                digits.set(i, sum);
                carrier = 0;
            }
        }

        if (digits.size() == size) {
            for (int i = size; i < n.digits.size(); i++) {
                sum = carrier + n.digits.get(i);
                if (sum > 9) {
                    digits.add(sum - 10);
                    carrier = 1;
                } else {
                    digits.add(sum);
                }
            }
        } else {
            for (int i = size; i < digits.size(); i++) {
                sum = carrier + digits.get(i);
                if (sum > 9)  {
                    digits.set(i, sum - 10);
                    carrier = 1;
                } else {
                    digits.set(i, sum);
                    carrier = 0;
                }
            }
        }

        if (carrier == 1) {
            digits.add(1); 
        }
    }

    public static void testIncrement() {
        Number n = new Number(129);
        n.increment();
        n.print();

        n = new Number(0);
        n.increment();
        n.print();

        n = new Number(999);
        n.increment();
        n.print();
    }

    public static void testAdd() {
        Number n = new Number(99);
        n.add(new Number(1));
        n.print();

        n = new Number(99);
        n.add(new Number(98));
        n.print();

        n.add(new Number(111));
        n.print();
    }

    public static void main(String[] args) {
//        testIncrement();
        testAdd();
    }
}
