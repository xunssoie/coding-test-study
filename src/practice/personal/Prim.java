package practice.personal;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {

    // 인접 리스트: graph[u] = {인접 정점, 간선 가중치} 목록
    static List<int[]>[] graph;

    // 프림 알고리즘: MST(최소 신장 트리)의 총 가중치 반환
    static long prim(int n, int start){
        boolean[] visited = new boolean[n]; // MST에 포함된 정점 표시

        // 트리에서 뻗어나가는 간선 중 가중치가 가장 작은 것부터 꺼냄 {정점, 가중치}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));

        pq.offer(new int[]{start, 0});

        long answer = 0;
        int count = 0;

        while (!pq.isEmpty()){
            int[] cur = pq.poll();

            int u = cur[0];
            int w = cur[1];

            // 이미 트리에 포함된 정점이면 스킵 (사이클 방지)
            if(visited[u])
                continue;

            // 최소 간선으로 정점을 트리에 편입하고 가중치 누적
            visited[u] = true;
            answer += w;
            count++;

            // 아직 트리 밖인 인접 정점들을 후보 간선으로 추가
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
