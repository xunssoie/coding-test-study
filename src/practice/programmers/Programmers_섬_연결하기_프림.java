package practice.programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Programmers_섬_연결하기_프림 {
    public int solution(int n, int[][] costs) {
        boolean[] visited = new boolean[n];

        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int w = cost[2];

            graph.get(from).add(new int[]{to, w});
            graph.get(to).add(new int[]{from, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int[]{0, 0});

        int answer = 0;

        while (!pq.isEmpty()){
            int[] cur = pq.poll();

            int u = cur[0];
            int w = cur[1];

            if(visited[u])
                continue;

            visited[u] = true;
            answer += w;

            for (int[] next : graph.get(u)) {
                int nu = next[0];
                int nw = next[1];

                if(!visited[nu]){
                    pq.offer(new int[]{nu, nw});
                }
            }
        }
        return answer;
    }
}
