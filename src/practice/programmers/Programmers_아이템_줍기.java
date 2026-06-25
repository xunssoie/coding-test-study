package practice.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class Programmers_아이템_줍기 {

    public static final int N = 101;

    int[][] positions = new int[N][N];
    boolean[][] visited = new boolean[N][N];

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

    }

    public int solution(
            int[][] rectangle,
            int characterX,
            int characterY,
            int itemX,
            int itemY
    ) {
        // positions 초기화, 테두리면 1, 특정 직사각형의 내부면 -1
        initPositions(rectangle);

        // bfs 시작
        Queue<Path> queue = new ArrayDeque<>();
        visited[characterX*2][characterY*2] = true;
        queue.offer(new Path(characterX*2, characterY*2, 0));

        while(!queue.isEmpty()){
            Path cur = queue.poll();

            if(cur.x == itemX*2 && cur.y == itemY*2){
                return cur.dist / 2;
            }

            for(int i = 0; i < 4; i++){
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N){
                    if(positions[nextX][nextY] == 1 && !visited[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        queue.offer(new Path(nextX, nextY, cur.dist+1));
                    }
                }
            }
        }
        return -1;
    }

    public void initPositions(int[][] rectangles) {
        for (int[] r : rectangles) {
            for (int i = 2*r[0]; i <= 2*r[2]; i++) {
                for (int j = 2*r[1]; j <= 2*r[3]; j++) {
                    if (i == 2*r[0] || i == 2*r[2] || j == 2*r[1] || j == 2*r[3]) {
                        positions[i][j] = 1;
                    }
                }
            }
        }
        for (int[] r : rectangles) {
            for (int i = 2*r[0]+1; i < 2*r[2]; i++) {
                for (int j = 2*r[1]+1; j < 2*r[3]; j++) {
                    positions[i][j] = -1;
                }
            }
        }
    }

    class Path{
        int x;
        int y;
        int dist;

        Path(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
