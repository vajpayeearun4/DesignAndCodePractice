package final_prep.dsa.array.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/course-schedule/submissions/2146359287/
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] item : prerequisites) {
            int course = item[0];
            int pre = item[1];
            adjList.get(pre).add(course);
        }
        int[] state = new int[numCourses];
        Arrays.fill(state, 0);
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (dfs(i, adjList, state)) {
                    return false;
                }
            }
        }
        return true;

    }

    boolean dfs(int node, List<List<Integer>> adjList, int[] state) {
        state[node] = 1;

        for (int neighbour : adjList.get(node)) {
            if (state[neighbour] == 1) {
                return true;
            }
            if (state[neighbour] == 0) {
                if (dfs(neighbour, adjList, state)) {
                    return true;
                }
            }
        }

        state[node] = 2;
        return false;
    }
}
