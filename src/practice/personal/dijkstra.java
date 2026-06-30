package practice.personal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class dijkstra {

    List<int[]>[] graph;

    int[] dijkstra(int n, int start){
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, start});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cost = cur[0];
            int node = cur[1];

            if(cost > dist[node])
                continue;

            for (int[] edge : graph[node]) {
                int to = edge[0];
                int toCost = edge[1];

                if(dist[node] + toCost < dist[to]){
                    dist[to] = dist[node] + toCost;
                    pq.offer(new int[]{dist[to], to});
                }
            }
        }
        return dist;
    }
}
