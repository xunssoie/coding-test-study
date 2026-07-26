package practice.personal;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {

    // Union-Find(분리 집합): parent = 각 원소의 대표(루트), rank = 트리 높이 근사값
    static int[] parent, rank;

    // x가 속한 집합의 루트를 찾음 + 경로 압축(찾은 루트를 바로 부모로 연결)
    static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // 두 집합을 합침. 이미 같은 집합이면 false(사이클), 합쳤으면 true
    static boolean union(int a, int b){
        int ra = find(a);
        int rb = find(b);

        if(ra == rb){
            return false;
        }

        // rank가 낮은 트리를 높은 트리 밑에 붙이려고 ra가 더 높도록 스왑
        if(rank[ra] < rank[rb]){
            int t = ra;
            ra = rb;
            rb = t;
        }

        parent[rb] = ra;

        // 높이가 같을 때만 합친 쪽 트리 높이가 1 증가
        if(rank[ra] == rank[rb]){
            rank[ra]++;
        }

        return true;
    }

    // 크루스칼 알고리즘: MST(최소 신장 트리)의 총 비용 반환
    static long kruskal(int V, int[][] edges){
        // 간선을 가중치 오름차순으로 정렬 (edge = {정점a, 정점b, 가중치})
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));

        // 각 정점을 자기 자신을 루트로 하는 독립 집합으로 초기화
        parent = new int[V];
        rank = new int[V];

        for(int i = 0; i < V; i++){
            parent[i] = i;
        }

        long cost = 0;
        int count = 0;

        // 가벼운 간선부터, 사이클을 만들지 않는 간선만 선택
        for (int[] edge : edges) {
            if(union(edge[0], edge[1])){
                cost += edge[2];
                count++;
                // 간선 V-1개를 고르면 MST 완성 → 조기 종료
                if(count == V - 1)
                    break;
            }
        }
        return cost;
    }
}
