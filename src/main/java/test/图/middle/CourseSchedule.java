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

        int numCourses = 4;

        //这数据是边缘列表 就是描述边的列表 index0 指向 index1 代表一个边
        int[][] prerequisites = new int[][]{{0, 1}, {1, 2} , {2,0} , {0,3}};

        System.out.println(Arrays.deepToString(prerequisites));

        GraphWay graph = new GraphWay();

        boolean result = graph.canFinish(numCourses, prerequisites);

        System.out.println(result);
    }

}

//领结表方式

/**
 *
 * 将边缘列表的方式 更改成为 领结表的方式
 *
 *
 */
class GraphWay {


    boolean canFinish(int numCourses, int[][] prerequisites) {
        //入度为0的点 存放的集合
        Queue<Integer> queue = new LinkedList<>();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {

            graph.add(new ArrayList<>());

        }
        //入度 就是指向我这个节点的
        int[] inDegree = new int[numCourses];

        int counter = 0;

        // 0 依赖 1
        for (int i = 0; i < prerequisites.length; i++) {

            int course = prerequisites[i][0];

            int pre = prerequisites[i][1];

            //在 index 为pre的地方 维护一个list 来维护依赖pre的元素
            graph.get(pre).add(course);

            //course这个元素的入度+1,最后统计能来到course的元素有多少个
            inDegree[course]++;

        }

        //inDegree[i] == 0 都是那种 向量的出发点
        for (int i = 0; i < numCourses; i++) {
            //insert into
            if (inDegree[i] == 0) queue.offer(i);

        }

        while (!queue.isEmpty()) {
            //返回 并且 删除
            int zeroPoint = queue.poll();

            counter++;
            //从领结表里取出 这个元素 领结的或者说是出度的节点集合
            for (Integer i : graph.get(zeroPoint)) {
                //将这些出度的点的依赖 也就是这个入度点减掉
                inDegree[i]--;
                //某个入度的节点集合里的节点 能入到这个节点的数量为0时 将此节点加入到queue中（也就是 入度为0的点 存放的集合 ）
                if (inDegree[i] == 0) {

                    queue.offer(i);

                }
            }
        }

        System.out.println(counter);
        System.out.println(numCourses);

        return numCourses == counter;
    }

}


//DFS方式深度遍历
class DFSWay {


    boolean canFinish(int numCourses, int[][] prerequisites) {

        //
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
    //利用深度遍历的方式 来检测这个图中 是否有环的存在
    //用一个数组 来维护访问过的节点
    boolean dfs(int cur, ArrayList<ArrayList<Integer>> graph, int[] visited) {


        if (visited[cur] == 1) return true;

        if (visited[cur] == 2) return false;

        visited[cur] = 1;

        //从领结表里取出 这个元素 领结的或者说是出度的节点集合
        for (Integer i : graph.get(cur)) {
            if (dfs(i, graph, visited)) return true;
        }

        visited[cur] = 2;
        return false;
    }


}
