package practice.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247_최적_경로 {

    public static int N;
    public static int[][] pts;
    public static boolean[] visited;
    public static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            pts = new int[N + 2][2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N + 2; i++) {
                pts[i][0] = Integer.parseInt(st.nextToken());
                pts[i][1] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[N + 2];
            min = Integer.MAX_VALUE;

            dfs(0, 0, 0);

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }

    public static int manhattanDist(int a, int b){
        return Math.abs(pts[a][0] - pts[b][0]) + Math.abs(pts[a][1] - pts[b][1]);
    }

    public static void dfs(int cur, int sum, int depth){
        if(sum >= min)
            return;

        if(depth == N){
            min = Math.min(min, sum + manhattanDist(cur, 1));
            return;
        }

        for(int i = 2; i < N + 2; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, sum + manhattanDist(cur, i), depth+1);
                visited[i] = false;
            }
        }
    }
}
