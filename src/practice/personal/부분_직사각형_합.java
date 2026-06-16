package practice.personal;

import java.util.Arrays;

public class 부분_직사각형_합 {
    public static void main(String[] args) {
        int[][] board = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] queries = {
                {1, 1, 2, 2},   // 기대값 12
                {2, 2, 3, 3},   // 기대값 28
                {1, 1, 3, 3}    // 기대값 45
        };

        long[] result = solution(board, queries);
        System.out.print(Arrays.toString(result)); // 기대: [12, 28, 45]
    }

    public static long[] solution(
            int[][] board,
            int[][] queries
    ){
        long[][] dp = new long[board.length + 1][board[0].length + 1];
        for(int i = 0; i < board.length + 1; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i < board[0].length; i++){
            dp[0][i] = 0;
        }

        for(int i = 1; i <= board.length; i++){
            for(int j = 1; j <= board[0].length; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + board[i-1][j-1];
            }
        }

        long[] answer = new long[queries.length];
        int i = 0;
        for (int[] query : queries) {
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];

            long sum = dp[r2][c2] - dp[r1-1][c2] - dp[r2][c1-1] + dp[r1-1][c1-1];
            answer[i] = sum;
            i++;
        }
        return answer;
    }
}
