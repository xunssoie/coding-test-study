package practice.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_카카오프렌즈_컬러링북 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (getStartPoint(m, n, picture, visited) != null) {
            Queue<int[]> queue = new LinkedList<>();

            int[] start = getStartPoint(m, n, picture, visited);
            visited[start[0]][start[1]] = true;
            queue.offer(start);

            int sizeOfOneArea = 1;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                int cm = cur[0];
                int cn = cur[1];

                for (int i = 0; i < 4; i++) {
                    if ((cm + dx[i] >= 0 && cm + dx[i] < m) && (cn + dy[i] >= 0 && cn + dy[i] < n)) {
                        if (picture[cm + dx[i]][cn + dy[i]] == picture[cm][cn]) {
                            if (!visited[cm + dx[i]][cn + dy[i]]) {
                                visited[cm + dx[i]][cn + dy[i]] = true;
                                queue.offer(new int[]{cm + dx[i], cn + dy[i]});
                                sizeOfOneArea++;
                            }
                        }
                    }
                }
            }
            if (sizeOfOneArea > maxSizeOfOneArea) {
                maxSizeOfOneArea = sizeOfOneArea;
            }
            numberOfArea++;
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static int[] getStartPoint(
            int m,
            int n,
            int[][] picture,
            boolean[][] visited
    ) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
