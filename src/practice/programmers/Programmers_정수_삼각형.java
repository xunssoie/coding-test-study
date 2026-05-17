package practice.programmers;

import java.io.IOException;

public class Programmers_정수_삼각형 {
    public static void main(String[] args) throws IOException {
        System.out.println("answer = " + solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    public static int solution(int[][] triangle) {
        int height = triangle.length;
        int[][] dp = new int[height][height];

        dp[0][0] = triangle[0][0];

        for (int row = 1; row < height; row++) {
            for (int col = 0; col < triangle[row].length; col++) {
                int cur = triangle[row][col];

                if (col == 0) {                                  // 왼쪽 가장자리: 위쪽 부모만 존재
                    dp[row][col] = dp[row - 1][0] + cur;
                    continue;
                }
                if (col == row) {                                // 오른쪽 가장자리: 왼쪽 위 부모만 존재
                    dp[row][col] = dp[row - 1][row - 1] + cur;
                    continue;
                }
                dp[row][col] = Math.max(dp[row - 1][col - 1], dp[row - 1][col]) + cur;
            }
        }

        int maxSum = 0;
        for (int sum : dp[height - 1]) {
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}