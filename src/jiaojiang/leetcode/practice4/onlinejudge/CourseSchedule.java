package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

/**
 * @author zhang
 *
 * Created on Mar 8, 2016
 */
public class CourseSchedule {
    /*
    There are a total of n courses you have to take, labeled from 0 to n - 1.

    Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is
    expressed as a pair: [0,1]

    Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

    For example:

    2, [[1,0]]

    There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

    2, [[1,0],[0,1]]

    There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0
    you should also have finished course 1. So it is impossible.

    Note:
    The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a
    graph is represented.

    click to show more hints.
    Hints:

        This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological
        ordering exists and therefore it will be impossible to take all courses.
        Topological Sort via DFS (https://class.coursera.org/algo-003/lecture/52) - A great video tutorial (21 minutes)
        on Coursera explaining the basic concepts of
        Topological Sort.
        Topological sort could also be done via BFS.
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        Map<Integer, Set<Integer>> prerequisiteMap = new HashMap<Integer, Set<Integer>>();
        Set<Integer> vertices = new HashSet<Integer>();

        for (int[] edge : prerequisites) {
            if (!prerequisiteMap.containsKey(edge[1])) {
                prerequisiteMap.put(edge[1], new HashSet<Integer>());
            }
            if (!prerequisiteMap.get(edge[1]).contains(edge[0])) {
                prerequisiteMap.get(edge[1]).add(edge[0]);
                degrees[edge[0]]++;
                vertices.add(edge[0]);
            }
        }

        Set<Integer>[] zeroDegrees = new HashSet[]{new HashSet<Integer>(), new HashSet<Integer>()};
        int index = 0;
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                zeroDegrees[index & 1].add(i);
            }
        }

        for (;  !zeroDegrees[index & 1].isEmpty(); index++) {
            zeroDegrees[(index + 1) & 1].clear();
            for (int i : zeroDegrees[index & 1]) {
                vertices.remove(i);
                if (prerequisiteMap.containsKey(i)) {
                    for (int j : prerequisiteMap.get(i)) {
                        degrees[j]--;
                        if (degrees[j] == 0) {
                            zeroDegrees[(index + 1) & 1].add(j);
                        }
                    }
                }
            }
        }

        return vertices.isEmpty();
    }
}
