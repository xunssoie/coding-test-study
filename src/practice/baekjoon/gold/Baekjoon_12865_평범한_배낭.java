package practice.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_12865_평범한_배낭 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 물건의 개수
        int K = Integer.parseInt(st.nextToken());   // 최대 무게

        int[] w = new int[N];   // 무게
        int[] v = new int[N];   // 가치
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][K+1];

        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < K+1; j++){
                dp[i][j] = dp[i-1][j];

                int weight = w[i-1];
                int value = v[i-1];

                if(weight <= j){
                    dp[i][j] = Math.max(
                            dp[i][j],
                            dp[i-1][j-weight] + value
                    );
                }
            }
        }

        System.out.print(dp[N][K]);
    }
}
