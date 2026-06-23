package practice.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Programmers_네트워크 {
    public static void main(String[] args) {

    }

    public static int solution(int n, int[][] computers) {
        List<List<Integer>> networks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            networks.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i && computers[i][j] == 1) {
                    networks.get(i).add(j);
                }
            }
        }

        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            Queue<Integer> queue = new ArrayDeque<>();
            visited[i] = true;
            queue.offer(i);

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : networks.get(cur)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}
