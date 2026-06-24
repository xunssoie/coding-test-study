package practice.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class Programmers_게임_맵_최단거리 {
    public int solution(int[][] maps) {
        int n = maps.length;    // 행
        int m = maps[0].length; // 열

        boolean[][] visited = new boolean[n][m];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Path> queue = new ArrayDeque<>();
        visited[0][0] = true;
        queue.offer(new Path(0, 0, 1));

        while (!queue.isEmpty()) {
            Path cur = queue.poll();

            int curX = cur.x;
            int curY = cur.y;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if ((nextX >= 0 && nextX < n) && (nextY >= 0 && nextY < m) && maps[nextX][nextY] == 1) {
                    if (!visited[nextX][nextY]) {
                        if (nextX == n - 1 && nextY == m - 1) {
                            return cur.dist + 1;
                        }
                        visited[nextX][nextY] = true;
                        queue.offer(new Path(nextX, nextY, cur.dist + 1));
                    }
                }
            }
        }
        return -1;
    }

    class Path {
        int x;
        int y;
        int dist;

        Path(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
