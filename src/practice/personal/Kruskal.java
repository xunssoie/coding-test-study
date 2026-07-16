package practice.personal;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {

    static int[] parent, rank;

    static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b){
        int ra = find(a);
        int rb = find(b);

        if(ra == rb){
            return false;
        }

        if(rank[ra] < rank[rb]){
            int t = ra;
            ra = rb;
            rb = t;
        }

        parent[rb] = ra;

        if(rank[ra] == rank[rb]){
            rank[ra]++;
        }

        return true;
    }

    static long kruskal(int V, int[][] edges){
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));

        parent = new int[V];
        rank = new int[V];

        for(int i = 0; i < V; i++){
            parent[i] = i;
        }

        long cost = 0;
        int count = 0;

        for (int[] edge : edges) {
            if(union(edge[0], edge[1])){
                cost += edge[2];
                count++;
                if(count == V - 1)
                    break;
            }
        }
        return cost;
    }
}
