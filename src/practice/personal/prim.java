package practice.personal;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class prim {

    static List<int[]>[] graph;

    static long prim(int n, int start){
        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));

        pq.offer(new int[]{start, 0});

        long answer = 0;
        int count = 0;

        while (!pq.isEmpty()){
            int[] cur = pq.poll();

            int u = cur[0];
            int w = cur[1];

            if(visited[u])
                continue;

            visited[u] = true;
            answer += w;
            count++;

            for (int[] next : graph[u]) {
                int v = next[0];
                int nw = next[1];

                if(!visited[v]){
                    pq.offer(new int[]{v, nw});
                }
            }
        }

        return answer;
    }
}
