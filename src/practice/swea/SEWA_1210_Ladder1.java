package practice.swea;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SEWA_1210_Ladder1 {

    public static final int SIZE = 100;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= 10; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] ladder = new int[SIZE][SIZE];

            int startI = 0;
            int startJ = 0;

            for(int i = 0; i < SIZE; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < SIZE; j++){
                    int value = Integer.parseInt(st.nextToken());

                    if (value == 2){
                        startI = i;
                        startJ = j;
                    }

                    ladder[i][j] = value;
                }
            }

            int[] di = {0, 0, -1};
            int[] dj = {-1, 1, 0};

            boolean[][] visited =  new boolean[SIZE][SIZE];
            Queue<Point> queue = new LinkedList<>();

            queue.add(new Point(startI, startJ));
            visited[startI][startJ] = true;

            int answer = 0;
            while(!queue.isEmpty()){
                Point p = queue.poll();

                int i = p.x;
                int j = p.y;

                for(int k = 0; k < 3; k++){
                    int newI = i + di[k];
                    int newJ = j + dj[k];

                    if(newI >= 0 && newI < SIZE && newJ >= 0 && newJ < SIZE){
                        if(!visited[newI][newJ] && ladder[newI][newJ] == 1){
                            visited[newI][newJ] = true;
                            queue.add(new Point(newI, newJ));
                            answer = newJ;
                            break;
                        }
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append('\n');
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }
}
