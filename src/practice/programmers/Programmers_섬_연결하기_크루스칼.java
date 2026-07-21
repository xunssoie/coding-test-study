package practice.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Programmers_섬_연결하기_크루스칼 {
    int[] parent;
    int[] rank;

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (Comparator.comparingInt(c -> c[2])));

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int count = 0;

        for (int[] cost : costs) {
            if(union(cost[0], cost[1])) {
                answer += cost[2];
                count++;
                if(count == n-1){
                    break;
                }
            }
        }
        return answer;
    }

    private int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private boolean union(int a, int b){
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
}
