package suixianglu.graph.L;

import java.util.ArrayList;
import java.util.List;

public class l0797 {
    class Solution {
        private List<List<Integer>> routes = new ArrayList<>();
        private List<Integer> route = new ArrayList<>();
        int[][] graph;

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            this.graph = graph;
            route.add(0);
            DFS(0);
            return routes;
        }

        private void DFS(int index) {
            if (index == graph.length - 1) {
//                routes.add(List.copyOf(route));
                routes.add(new ArrayList<Integer>(route));
            }

            for (int i = 0; i < graph[index].length; i++) {
                int nextNode = graph[index][i];
                route.add(nextNode);
                DFS(nextNode);
                route.remove(route.size() - 1);
            }
        }
    }
}
