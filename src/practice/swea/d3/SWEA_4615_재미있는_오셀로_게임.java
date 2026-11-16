package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4615_재미있는_오셀로_게임 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 0 = 돌 X, 1 = 흑돌, 2 = 백돌
            int[][] map = new int[N][N];
            int h = N / 2;
            map[h-1][h-1] = map[h][h] = 2;
            map[h-1][h] = map[h][h-1] = 1;

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                int color = Integer.parseInt(st.nextToken());

                map[x][y] = color;

                isColorChanged(map, x, y);
            }

            int black = 0;
            int white = 0;
            for(int i = 0; i < map.length; i++){
                for(int j = 0; j < map.length; j++){
                    if(map[i][j] == 1){
                        black++;
                    }
                    if(map[i][j] == 2){
                        white++;
                    }
                }
            }

            answer.append("#").append(t).append(" ").append(black).append(" ").append(white).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.println(answer);
    }

    private static void isColorChanged(int[][] map, int x, int y){
        int color = map[x][y];

        int[] dx = {-1, -1, -1, 0, +1, +1, +1, 0};
        int[] dy = {-1, 0, +1, +1, +1, 0, -1, -1};

        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            while(inRange(nx, ny, map.length) && map[nx][ny] == 3 - color){
                nx += dx[i];
                ny += dy[i];
            }

            if(inRange(nx, ny, map.length) && map[nx][ny] == color){
                nx -= dx[i];
                ny -= dy[i];
                while(nx != x || ny != y){
                    map[nx][ny] = color;
                    nx -= dx[i];
                    ny -= dy[i];
                }
            }
        }
    }

    private static boolean inRange(int x, int y, int n){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
