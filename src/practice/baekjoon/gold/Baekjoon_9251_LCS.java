package practice.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_9251_LCS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();

        int[][] dp = new int[s1.length+1][s2.length+1];
        for(int i = 1; i < s1.length+1; i++) {
            char c1 = s1[i-1];
            for(int j = 1; j < s2.length+1; j++) {
                char c2 = s2[j-1];

                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(
                            dp[i-1][j],
                            dp[i][j-1]
                    );
                }
            }
        }
        System.out.print(dp[s1.length][s2.length]);
    }
}
