package practice.programmers;

public class Programmers_등굣길 {
    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2, 2}}));
    }

    private static final int MOD = 1_000_000_007;

    public static int solution(int m, int n, int[][] puddles) {
        boolean[][] isPuddles = new boolean[m][n];

        for (int[] puddle : puddles) {
            int i = puddle[0]-1;
            int j = puddle[1]-1;

            isPuddles[i][j] = true;
        }

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            if(isPuddles[i][0]){
                for(int k = i; k < m; k ++){
                    isPuddles[k][0] = true;
                }
                break;
            }
            dp[i][0] = 1;
        }

        for(int j = 0; j < n; j++){
            if(isPuddles[0][j]){
                for(int k = j; k < n; k++){
                    isPuddles[0][k] = true;
                }
                break;
            }
            dp[0][j] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                int up = isPuddles[i-1][j] ? 0 : dp[i-1][j];
                int down = isPuddles[i][j-1] ? 0 : dp[i][j-1];

                dp[i][j] = (up + down) % MOD;
            }
        }

        return dp[m-1][n-1];
    }
}
