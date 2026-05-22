package practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247_최적_경로_V2 {
    /**
     * 기사는 '회사 -> 고객1 -> 고객2 -> ... -> 고객N -> 집' 동선으로 이동하는데,
     * 회사에서 출발해서 고객의 집을 모두 방문하고 집까지 오는 최단거리를 구하라
     *
     * DFS + 가지치기(거리의 누적 합이 탐색 시점의 최단거리 MIN 보다 작다면 탐색 종료)
     */
    public static int[][] positions;
    public static int N;
    public static boolean[] visited;
    public static int MIN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N+2];
            positions = new int[N+2][N+2];

            // positions[0]: 회사 좌표
            // positions[1]: 집 좌표
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N+2; i++){
                positions[i][0] = Integer.parseInt(st.nextToken());
                positions[i][1] = Integer.parseInt(st.nextToken());
            }

            MIN = Integer.MAX_VALUE;
            dfs(0, 0, 0);
            answer.append("#").append(t).append(" ").append(MIN).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }

    private static void dfs(int cur, int distance, int depth){
        if(distance > MIN){
            return;
        }

        if(depth == N){
            MIN = Math.min(MIN, distance + calDistance(cur, 1));
            return;
        }

        for(int i = 2; i < N+2; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, distance + calDistance(cur, i), depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int calDistance(int a, int b){
        return Math.abs(positions[a][0] - positions[b][0]) + Math.abs(positions[a][1] - positions[b][1]);
    }
}
