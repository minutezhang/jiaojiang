package jiaojiang.leetcode.practice4.onlinejudge;

import utils.Utils;

import java.util.*;

/**
 * @author zhang
 *
 * Created on Jun 21, 2016
 */
public class CourseScheduleII {
    /*
     There are a total of n courses you have to take, labeled from 0 to n - 1.

    Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is
    expressed as a pair: [0,1]

    Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take
    to finish all courses.

    There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all
    courses, return an empty array.

    For example:

    2, [[1,0]]

    There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct
    course order is [0,1]

    4, [[1,0],[2,0],[3,1],[3,2]]

    There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both
    courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another
    correct ordering is[0,2,1,3].
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        Map<Integer, List<Integer>> dependencies = new HashMap<Integer, List<Integer>>();

        for (int[] prerequisite : prerequisites) {
            degrees[prerequisite[0]]++;
            List<Integer> conn = dependencies.get(prerequisite[1]);
            if (conn == null) {
                dependencies.put(prerequisite[1], conn = new ArrayList<Integer>());
            }
            conn.add(prerequisite[0]);
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> courseScheduleList = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int prerequisite = queue.remove();
            courseScheduleList.add(prerequisite);
            if (dependencies.get(prerequisite) != null) {
                for (int dependency : dependencies.get(prerequisite)) {
                    if (--degrees[dependency] == 0) {
                        queue.add(dependency);
                    }
                }
            }
        }

        if (courseScheduleList.size() != numCourses) {
            return new int[0];
        }
        
        int[] courseSchedule = new int[courseScheduleList.size()];
        for (int i = 0; i < courseSchedule.length; i++) {
            courseSchedule[i] = courseScheduleList.get(i);
        }
        return courseSchedule;
    }
}
