package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.*;

/**
 * @author: zhang
 * @since: May 29, 2013 9:20:13 PM
 */
public class WordLadderII {
    /*
    Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary
    For example,

    Given:
    start = "hit"
    end = "cog"
    dict = ["hot","dot","dog","lot","log"]

    Return

      [
        ["hit","hot","dot","dog","cog"],
        ["hit","hot","lot","log","cog"]
      ]
    Note:

    All words have the same length.
    All words contain only lowercase alphabetic characters.
    */
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        Map<String, List<String>> parent = new HashMap<String, List<String>>();
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();

        boolean hasFound = false;
        int size = start.length(), count = 1;
        Set<String> hasVisited = new HashSet<String>();
        Queue<String> visited = new LinkedList<String>();
        visited.add(start);
        hasVisited.add(start);


        while (!visited.isEmpty() && !hasFound) {
            visited.add(null);
            String neighbor;
            Set<String> hasVisitedThisRound = new HashSet<String>();
            
            while ((neighbor = visited.remove()) != null) {
                for (int i = 0; i < size; i++) {
                    char[] chars = neighbor.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newStr = new String(chars);
                        if (end.equals(newStr)) {
                            hasFound = true;
                            ArrayList<ArrayList<String>> tmpLists = new ArrayList<ArrayList<String>>();
                            ArrayList<String> path = new ArrayList<String>();
                            path.add(end);
                            path.add(neighbor);
                            tmpLists.add(path);

                            while (!start.equals(path.get(path.size() - 1))) {
                                for (int j = 0, n = tmpLists.size(); j < n; j++) {
                                    ArrayList<String> l = tmpLists.get(j);
                                    List<String> parents = parent.get(l.get(l.size() - 1));

                                    for (int k = 1; k < parents.size(); k++) {
                                        ArrayList<String> l2 = new ArrayList<String>(l);
                                        l2.add(parents.get(k));
                                        tmpLists.add(l2);
                                    }

                                    l.add(parents.get(0));
                                }
                            }

                            for (ArrayList<String> l : tmpLists) {
                                for (int j = 0; j < (count + 1)/2; j++) {
                                    String s = l.get(j);
                                    l.set(j, l.get(count - j));
                                    l.set(count - j, s);
                                }
                            }
                            ret.addAll(tmpLists);
                        } else if (!hasFound && !hasVisited.contains(newStr) && dict.contains(newStr)){

                            if (!hasVisitedThisRound.contains(newStr)) {
                                visited.add(newStr);
                                hasVisitedThisRound.add(newStr);
                            }
                            
                            if (!parent.containsKey(newStr)) {
                                parent.put(newStr, new ArrayList<String>());
                            }
                            parent.get(newStr).add(neighbor);

                        }
                    }
                }
            }
            hasVisited.addAll(hasVisitedThisRound);
            count++;
        }

        return ret;
    }

    public static HashSet<String> getDict() {
        String[] dictArray = new String[] {
            "ted","tex","red","tax","tad","den","rex","pee"
        };

        HashSet<String> dict = new HashSet<String>();
        for (String s : dictArray) {
            dict.add(s);
        }

        return dict;
    }

    public static void test() {
        HashSet<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");

        for (ArrayList<String> list : findLadders("hit", "cog", dict)) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

        System.out.println("----------");   //[["red","ted","tad","tax"],["red","ted","tex","tax"],["red","rex","tex","tax"]]

        for (ArrayList<String> list : findLadders("red", "tax", getDict())) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test();
    }
}
