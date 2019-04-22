package test.图.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mengyue
 * @date 2019/3/18
 */
public class CourseSchedule {


    public static void main(String[] args) {

        int numCourses = 3;

        int[][] prerequisites = new int[][]{{0, 1}, {1, 2}};

        System.out.println(Arrays.deepToString(prerequisites));

        GraphWay graph = new GraphWay();

        graph.canFinish(numCourses, prerequisites);

    }

}

//领结表方式
class GraphWay {


    boolean canFinish(int numCourses, int[][] prerequisites) {

        Queue<Integer> queue = new LinkedList<>();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        int counter = 0;

        // 0 依赖 1
        for (int i = 0; i < prerequisites.length; i++) {

            int course = prerequisites[i][0];

            int pre = prerequisites[i][1];

            graph.get(pre).add(course);

            inDegree[course]++;

        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {

            int zeroPoint = queue.poll();

            counter++;

            for (Integer i : graph.get(zeroPoint)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }

            }

        }

        return numCourses == counter;
    }

}


//DFS方式深度遍历
class DFSWay {


    boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];

            graph.get(course).add(pre);

        }

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visited)) return false;
        }

        return true;
    }

    boolean dfs(int cur, ArrayList<ArrayList<Integer>> graph, int[] visited) {


        if (visited[cur] == 1) return true;

        if (visited[cur] == 2) return false;

        visited[cur] = 1;

        for (Integer i : graph.get(cur)) {
            if (dfs(i, graph, visited)) return true;
        }

        visited[cur] = 2;
        return false;
    }


}
