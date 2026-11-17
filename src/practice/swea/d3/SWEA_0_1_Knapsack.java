package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_0_1_Knapsack {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] v = new int[N];
            int[] c = new int[N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());

                v[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N+1][K+1];
            for(int i = 1; i <= N; i++){
                int vv = v[i-1];
                int cv = c[i-1];

                for(int j = 1; j <= K; j++){

                    dp[i][j] = dp[i-1][j];
                    if(j >= vv){
                        dp[i][j] = Math.max(
                                dp[i][j],
                                dp[i-1][j-vv] + cv
                        );
                    }
                }
            }

            answer.append("#").append(t).append(" ").append(dp[N][K]).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
