package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215_햄버거_다이어트 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[][] dp = new int[N+1][L+1];

            int[] grade = new int[N];
            int[] cal = new int[N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());

                int g = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                grade[i] = g; cal[i] = c;
            }

            for (int i = 1; i <= N; i++) {
                int g = grade[i - 1];
                int c = cal[i - 1];

                for (int j = 1; j <= L; j++) {
                    dp[i][j] = dp[i - 1][j];

                    if (j >= c) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - c] + g);
                    }
                }
            }

            answer.append("#").append(t).append(" ").append(dp[N][L]).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
