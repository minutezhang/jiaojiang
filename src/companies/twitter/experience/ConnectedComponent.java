package companies.twitter.experience;

import java.util.*;

/**
 * @author: mizhang
 * @version: 6/25/13 5:30 PM
 */

/*
  Given a list of edges, return the list of connected components
 */
public class ConnectedComponent {
    public static List<Set<Integer>> getConnectedComponent(int[][] edges) {
        Map<Integer, Set<Integer>> ret = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Integer> components = new HashMap<Integer, Integer>();
        int count = 0;

        for (int[] edge : edges) {
            if (components.containsKey(edge[0]) && components.containsKey(edge[1])) {
                if (components.get(edge[0]) != components.get(edge[1])) {
                    Set<Integer> set0 = ret.get(components.get(edge[0]));
                    Set<Integer> set1 = ret.get(components.get(edge[1]));

                    set0.addAll(set1);
                    for (Integer i : set1) {
                        components.put(i, edge[0]);
                    }

                    ret.remove(components.get(edge[1]));
                }
            } else if (components.containsKey(edge[0])){
                components.put(edge[1], components.get(edge[0]));
                ret.get(components.get(edge[0])).add(edge[1]);
            } else if (components.containsKey(edge[1])) {
                components.put(edge[0], components.get(edge[1]));
                ret.get(components.get(edge[1])).add(edge[0]);
            } else {
                components.put(edge[0], count);
                components.put(edge[1], count);
                Set<Integer> comp = new HashSet<Integer>();
                comp.add(edge[0]);
                comp.add(edge[1]);
                ret.put(count, comp);
                count++;
            }
        }

        return new ArrayList<Set<Integer>>(ret.values());
    }

    public static void test() {
        int[][] edges = new int[][] {
                {1, 2}, {2, 3}, {3, 4}, {6, 7}, {5, 6}
        };


        for (Set<Integer> s : getConnectedComponent(edges)){
            for (int j : s) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test();
    }

}
