package practice.swea;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_5105_미로의_거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] maze = new int[N][N];

            int startI = 0;
            int startJ = 0;

            for(int i = 0; i < N; i++){
                String row = br.readLine();
                for(int j = 0; j < N; j++){
                    String value = String.valueOf(row.charAt(j));

                    if(value.equals("2")){
                        startI = i;
                        startJ = j;
                    }

                    maze[i][j] = Integer.parseInt(value);
                }
            }

            boolean[][] visited = new boolean[N][N];
            Queue<Point> queue = new LinkedList<>();
            Point point = new Point(startI, startJ);
            queue.add(point);
            visited[startI][startJ] = true;

            int level = -1;
            boolean flag = false;
            while(!queue.isEmpty()){
                int currentLevelSize = queue.size();

                for(int i = 0; i < currentLevelSize; i++){
                    Point target = queue.poll();

                    if(maze[target.x][target.y] == 3){
                        flag = true;
                        sb.append("#").append(t + 1).append(" ").append(level).append("\n");
                        queue.clear();
                        break;
                    }

                    // 상 = target.x - 1, target.y
                    if(target.x - 1 >= 0 && maze[target.x - 1][target.y] != 1 && !visited[target.x - 1][target.y]){
                        visited[target.x - 1][target.y] = true;
                        queue.add(new Point(target.x - 1, target.y));
                    }

                    // 하 = target.x + 1, target.y
                    if(target.x + 1 <= N-1 && maze[target.x + 1][target.y] != 1 && !visited[target.x + 1][target.y]){
                        visited[target.x + 1][target.y] = true;
                        queue.add(new Point(target.x + 1, target.y));
                    }

                    // 좌 = target.x, target.y - 1
                    if(target.y - 1 >= 0 && maze[target.x][target.y - 1] != 1 && !visited[target.x][target.y - 1]){
                        visited[target.x][target.y - 1] = true;
                        queue.add(new Point(target.x, target.y - 1));
                    }

                    // 우 = target.x, target.y + 1
                    if(target.y + 1 <= N-1 && maze[target.x][target.y + 1] != 1 && !visited[target.x][target.y + 1]){
                        visited[target.x][target.y + 1] = true;
                        queue.add(new Point(target.x, target.y + 1));
                    }
                }
                level++;
            }

            if(!flag){
                sb.append("#").append(t + 1).append(" ").append(0).append("\n");
            }
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }
}