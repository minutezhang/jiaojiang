package companies.twosigma.mitbbs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/11/15 2:44 PM
 */
public class JumbleSort {
    /*
    从stdin读入一行String，String中同时包括单词和数字，以空格分开。需要将输入进行排序，要求：（1）字母和数字分别顺序排序（2）输入中原本是字母/数字的地方依然是字母/数字。

    比如输入：d 3 c 2 1 a 输出为 a 1 c 2 3 d

    输入：add 6 abb at 输出为 abb 6 add at
     */

    public static String mixSort(String input) {
        List<String> words = new ArrayList<String>();
        List<Integer> numbers = new ArrayList<Integer>();

        String[] elements = input.split("\\s+");
        for (int i = 0; i < elements.length; i++) {
            try {
                int element = Integer.parseInt(elements[i]);
                numbers.add(element);
                elements[i] = "n";
            } catch (NumberFormatException e) {
                words.add(elements[i]);
                elements[i] = "w";
            }
        }

        Collections.sort(words);
        Collections.sort(numbers);

        StringBuffer ret = new StringBuffer();
        for (int i = 0, j = 0; i + j < elements.length;) {
            if (elements[i + j] == "n") {
                ret.append(numbers.get(i)).append(' ');
                i++;
            } else {
                ret.append(words.get(j)).append(' ');
                j++;
            }
        }

        ret.setLength(Math.max(0, ret.length() - 1));

        return ret.toString();
    }

    public static void test() {
        System.out.println(mixSort("d 3 c 2 1 a") + "#");      //a 1 c 2 3 d
        System.out.println(mixSort("") + "#");      //a 1 c 2 3 d
        System.out.println(mixSort("d 3     c 2 1 a") + "#"); //a 1 c 2 3 d
        System.out.println(mixSort("add 6 abb at") + "#");   //abb 6 add at
        System.out.println(mixSort("1 4 5 6 -2 8 9") + "#");   //abb 6 add at
    }


    public static void main(String[] args) {
        test();
    }


}
