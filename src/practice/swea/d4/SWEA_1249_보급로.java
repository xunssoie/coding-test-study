package practice.swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SWEA_1249_보급로 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] dx = {0, -1, 0, +1};
        int[] dy = {-1, 0, +1, 0};

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];
            for(int i = 0; i < N; i++){
                String row = br.readLine();
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
                }
            }

            int[][] dist = new int[N][N];
            for(int i = 0; i < N; i++){
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            Queue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

            priorityQueue.offer(new int[]{0, 0, 0});

            while(!priorityQueue.isEmpty()){
                int[] curNode = priorityQueue.poll();

                int curX = curNode[0];
                int curY = curNode[1];
                int curDist = curNode[2];

                if(dist[curX][curY] < curDist)
                    continue;

                for(int i = 0; i < 4; i++){
                    int nX = curX + dx[i];
                    int nY = curY + dy[i];

                    if(!inRange(nX, nY, N))
                        continue;

                    if(curDist + map[nX][nY]< dist[nX][nY]){
                        dist[nX][nY] = curDist + map[nX][nY];
                        priorityQueue.offer(new int[]{nX, nY, dist[nX][nY]});
                    }
                }

            }
            answer.append("#").append(t).append(" ").append(dist[N-1][N-1]).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }

    private static boolean inRange(int x, int y, int n){
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
