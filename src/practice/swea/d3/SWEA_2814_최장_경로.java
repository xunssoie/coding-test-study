package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2814_최장_경로 {

    static int N;
    static int M;
    static boolean[][] matrix;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            matrix = new boolean[N][N];
            visited = new boolean[N];
            max = 0;

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                matrix[x-1][y-1] = true;
                matrix[y-1][x-1] = true;
            }

            for(int i = 0; i < N; i++){
                visited[i] = true;
                dfs(i,0);
                visited[i] = false;
            }
            answer.append("#").append(t).append(" ").append(max+1).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }

    static void dfs(int node, int cur){
        if(cur > max){
            max = cur;
        }

        for(int i = 0; i < N; i++){
            if(matrix[node][i] && !visited[i]){
                visited[i] = true;
                dfs(i,cur+1);
                visited[i] = false;
            }
        }
    }
}
