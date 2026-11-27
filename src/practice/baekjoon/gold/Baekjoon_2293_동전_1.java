package practice.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2293_동전_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[n+1][k+1];

        // 0원을 만드는 경우의 수는 coin[i]를 제출하지 않는 경우의 수 1개가 존재!
        for(int i = 1; i < n+1; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < n+1; i++){
            int coin = coins[i-1];
            for(int j = 1; j < k+1; j++){
                dp[i][j] = dp[i-1][j];

                if(coin <= j){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coin];
                }
            }
        }

        System.out.print(dp[n][k]);
    }
}
