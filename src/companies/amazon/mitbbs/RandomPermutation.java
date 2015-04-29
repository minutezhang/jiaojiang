package companies.amazon.mitbbs;

import utils.Utils;

import java.util.Random;
import java.util.HashMap;

public class RandomPermutation {
    public static void getRandomPermutation(char[] input) {
        Random random = new Random();
        for(int i = 0; i < input.length; i++) {
            int index = random.nextInt(input.length - i);
            Utils.swap(input, i + index, i);
        }
    }

    public static void main(String[] argv) {
        char[] input = "abc".toCharArray();
        double totalNumber = 1000000.0;
        HashMap<String, Integer> maps = new HashMap<String, Integer>();
        for (int i = 0; i < (int)totalNumber; i++) {
            getRandomPermutation(input);
            String s = String.copyValueOf(input);
            if (!maps.containsKey(s)) {
                maps.put(s, 1);
            } else {
                maps.put(s, maps.get(s) + 1);    
            }
        }

        for (String s : maps.keySet()) {
            System.out.println(s + " : " + maps.get(s) / totalNumber );
        }
    }
}
