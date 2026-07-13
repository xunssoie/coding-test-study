package practice.personal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class topological_sort {
    public int[] topologicalSort(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        // 진입 차수
        int[] indegree = new int[n];

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        // 진입 차수 = 0인 노드(시작 노드)를 큐에 넣고 시작
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int[] answer = new int[n];
        int i = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            answer[i++] = cur;

            for (Integer next : graph.get(cur)) {
                indegree[next]--;

                // 0인 자식도 부모로 시작 가능
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }

        if(i != n){
            return new int[0];
        }
        return answer;
    }
}
