package practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범_검거 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            boolean[][] visited = new boolean[N][M];
            int[][] tunnel = new int[N][M];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++){
                    tunnel[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Queue<int[]> queue = new ArrayDeque<>();

            int time = 1;
            int answer = 1;

            // 상, 하, 좌, 우
            int[] di = new int[]{-1, 1, 0, 0};
            int[] dj = new int[]{0, 0, -1, 1};

            visited[R][C] = true;
            queue.offer(new int[]{R,C});
            while(time < L && !queue.isEmpty()){
                int queueSize = queue.size();
                for(int s = 0; s < queueSize; s++){
                    int[] cur = queue.poll();

                    for(int i = 0; i < 4; i++){
                        int nextI = cur[0] + di[i];
                        int nextJ = cur[1] + dj[i];

                        // 좌표상 범위를 벗어나면 out
                        if (nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= M){
                            continue;
                        }

                        // 현재 파이프와 비교할 파이프 가져오기
                        int curPipe = tunnel[cur[0]][cur[1]];
                        int nextPipe = tunnel[nextI][nextJ];

                        // 파이프가 없으면 out
                        if(nextPipe == 0){
                            continue;
                        }

                        if(!visited[nextI][nextJ]){
                            if(i == 0 && checkUpPossible(curPipe, nextPipe)){
                                // 상 비교
                                visited[nextI][nextJ] = true;
                                queue.offer(new int[]{nextI, nextJ});
                                answer++;
                            }else if(i == 1 && checkDownPossible(curPipe, nextPipe)){
                                // 하 비교
                                visited[nextI][nextJ] = true;
                                queue.offer(new int[]{nextI, nextJ});
                                answer++;

                            }else if(i == 2 && checkLeftPossible(curPipe, nextPipe)){
                                // 좌 비교
                                visited[nextI][nextJ] = true;
                                queue.offer(new int[]{nextI, nextJ});
                                answer++;

                            }else if(i == 3 && checkRightPossible(curPipe, nextPipe)){
                                // 우 비교
                                visited[nextI][nextJ] = true;
                                queue.offer(new int[]{nextI, nextJ});
                                answer++;
                            }
                        }
                    }
                }
                time++;
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }

    private static boolean checkRightPossible(int curPipe, int nextPipe) {
        return (curPipe == 1 || curPipe == 3 || curPipe == 4 || curPipe == 5)
                && (nextPipe == 1 || nextPipe == 3 || nextPipe == 6 || nextPipe == 7);
    }

    private static boolean checkLeftPossible(int curPipe, int nextPipe) {
        return (curPipe == 1 || curPipe == 3 || curPipe == 6 || curPipe == 7)
                && (nextPipe == 1 || nextPipe == 3 || nextPipe == 4 || nextPipe == 5);
    }

    private static boolean checkDownPossible(int curPipe, int nextPipe) {
        return (curPipe == 1 || curPipe == 2 || curPipe == 5 || curPipe == 6)
                && (nextPipe == 1 || nextPipe == 2 || nextPipe == 4 || nextPipe == 7);
    }

    private static boolean checkUpPossible(int curPipe, int nextPipe) {
        return (curPipe == 1 || curPipe == 2 || curPipe == 4 || curPipe == 7)
                && (nextPipe == 1 || nextPipe == 2 || nextPipe == 5 || nextPipe == 6);
    }
}
