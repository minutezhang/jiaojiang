package jiaojiang.leetcode.facebook.onlinejudge;

import java.util.*;

/**
 * @author zhang
 *
 * Created on Sep 3, 2016
 */
public class GraphValidTree {
    /*
    Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a
    function to check whether these edges make up a valid tree.
    For example:
    Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
    Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
    Hint:

        Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
        According to the definition of tree on Wikipedia: Òa tree is an undirected graph in which any two vertices
        are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.Ó

    Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is
    the same as [1, 0] and thus will not appear together inedges.
     */
    public static boolean validTree(int n, int[][] edges) {
        Set<Integer>[] adjacencies = new Set[n];
        for (int i = 0; i < n; i++) {
            adjacencies[i] = new HashSet<Integer>();
        }

        for (int[] edge : edges) {
            adjacencies[edge[0]].add(edge[1]);
            adjacencies[edge[1]].add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] hasVisited = new boolean[n];
        int numVisited = 1;

        queue.add(0);
        hasVisited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (int neighbor : adjacencies[node]) {
                if (hasVisited[neighbor]) {
                    return false;
                }
                queue.add(neighbor);
                adjacencies[neighbor].remove(node);
                hasVisited[neighbor] = true;
                numVisited++;
            }
        }

        return numVisited == n;
    }
}
