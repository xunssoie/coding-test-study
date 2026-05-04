package practice.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1226_미로_1 {

    public static final int LENGTH = 16;

    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < 10; t++) {
            int n = Integer.parseInt(br.readLine());

            int startI = 0;
            int startJ = 0;

            int targetI = 0;
            int targetJ = 0;

            int[][] maze = new int[LENGTH][LENGTH];

            for(int i = 0; i < LENGTH; i++){
                String row = br.readLine();
                for(int j = 0; j < LENGTH; j++){
                    int value = Integer.parseInt(String.valueOf(row.charAt(j)));

                    maze[i][j] = value;

                    if(value == 2){
                        startI = i;
                        startJ = j;
                    }

                    if(value == 3){
                        targetI = i;
                        targetJ = j;
                    }
                }
            }

            boolean[][] visited = new boolean[LENGTH][LENGTH];

            Queue<int[]> queue = new LinkedList<>();
            visited[startI][startJ] = true;
            queue.offer(new int[]{startI, startJ});

            boolean flag = false;
            while(!queue.isEmpty()){
                int[] cur = queue.poll();

                if(cur[0] == targetI && cur[1] == targetJ){
                    flag = true;
                    break;
                }

                for(int i = 0; i < 4; i++){
                    int nextI = cur[0] + dx[i];
                    int nextJ = cur[1] + dy[i];

                    if(nextI >= 0 && nextJ >= 0 && nextI < LENGTH && nextJ < LENGTH && maze[nextI][nextJ] != 1 && !visited[nextI][nextJ]){
                        queue.offer(new int[]{nextI, nextJ});
                        visited[nextI][nextJ] = true;
                    }
                }
            }

            if(flag){
                sb.append("#").append(n).append(" ").append(1).append("\n");
            }else{
                sb.append("#").append(n).append(" ").append(0).append("\n");
            }
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }
}
