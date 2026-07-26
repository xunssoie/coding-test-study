package practice.personal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    // 인접 리스트: graph[node] = {목적지, 간선 비용} 목록
    List<int[]>[] graph;

    // start 정점에서 모든 정점까지의 최단 거리 배열 반환 (음수 간선 없어야 함)
    int[] dijkstra(int n, int start){
        int[] dist = new int[n];

        // 아직 도달 못한 정점은 무한대, 시작점은 0
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // 현재까지 비용이 가장 작은 정점부터 꺼내는 최소 힙 {비용, 정점}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, start});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cost = cur[0];
            int node = cur[1];

            // 이미 더 짧은 경로로 확정된 정점이면 스킵 (오래된 항목)
            if(cost > dist[node])
                continue;

            // 인접 간선 완화(relaxation): 더 짧은 경로를 찾으면 갱신
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
