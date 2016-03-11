package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.*;

/**
 * @author zhang
 *
 * Created on Feb 28, 2016
 */
public class MinimumHeightTrees {
    /*
     For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a
     rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
     Given such a graph, write a function to find all the MHTs and return a list of their root labels.

    Format
    The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of
    undirected edges (each edge is a pair of labels).

    You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the
    same as [1, 0] and thus will not appear together in edges.

    Example 1:

    Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

            0
            |
            1
           / \
          2   3

    return [1]

    Example 2:

    Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

         0  1  2
          \ | /
            3
            |
            4
            |
            5

    return [3, 4]

    Note:

    (1) According to the definition of tree on Wikipedia: Òa tree is an undirected graph in which any two vertices
    are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.Ó

    (2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

    HINTS:
    How many MHTs can a graph have at most?
     */
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return new ArrayList<Integer>(Arrays.asList(new Integer[]{0}));
        }

        Map<Integer, Set<Integer>> adjacent = new HashMap<Integer, Set<Integer>>();
        int[] degrees = new int[n];
        Set<Integer> vertices = new HashSet<Integer>();

        for (int[] edge: edges) {
            if (!adjacent.containsKey(edge[0])) {
                adjacent.put(edge[0], new HashSet<Integer>());
            }
            adjacent.get(edge[0]).add(edge[1]);

            if (!adjacent.containsKey(edge[1])) {
                adjacent.put(edge[1], new HashSet<Integer>());
            }
            adjacent.get(edge[1]).add(edge[0]);

            vertices.add(edge[0]);
            vertices.add(edge[1]);
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }

        Set<Integer>[] leaves = new Set[]{new HashSet<Integer>(), new HashSet<Integer>()};
        int index = 0;
        for (Integer vertex : vertices) {
            if (degrees[vertex] == 1) {
                leaves[index].add(vertex);
            }
        }

        while (vertices.size() > 0) {
            leaves[(index + 1) &1].clear();
            vertices.removeAll(leaves[index & 1]);

            for (int v : leaves[index & 1]) {
                for (int e : adjacent.get(v)) {
                    degrees[e]--;
                    if (degrees[e] == 1) {
                        leaves[(index + 1) & 1].add(e);
                    }
                }
            }
            index++;
        }
        
        return new ArrayList<Integer>(leaves[(index + 1)&1]);
    }
}
