package practice.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Programmers_배달 {
    public static void main(String[] args) {
        int[][] road1 = new int[][] {
                {1, 2, 1},
                {2, 3, 3},
                {5, 2, 2},
                {1, 4, 2},
                {5, 3, 1},
                {5, 4, 2}
        };
        int[][] road2 = new int[][] {
                {1, 2, 1},
                {1, 3, 2},
                {2, 3, 2},
                {3, 4, 3},
                {3, 5, 2},
                {3, 5, 3},
                {5, 6, 1}
        };
        System.out.println("answer1 = " + solution(5, road1, 3));
        System.out.println("answer2 = " + solution(6, road2, 4));
    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        for (int[] r : road) {
            int a = r[0], b = r[1], c = r[2];
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        pq.offer(new int[]{0, 1});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int node = cur[1];

            if (cost > dist[node])
                continue;

            for (int[] edge : graph.get(node)) {
                int to = edge[0];
                int toCost = edge[1];

                if (dist[node] + toCost < dist[to]) {
                    dist[to] = dist[node] + toCost;
                    pq.offer(new int[]{dist[to], to});
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
}
