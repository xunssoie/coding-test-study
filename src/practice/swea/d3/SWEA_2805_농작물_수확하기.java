package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_2805_농작물_수확하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int c = N / 2;

            int[][] table = new int[N][N];

            for(int i = 0; i < N; i++){
                String row = br.readLine();
                for(int j = 0; j < N; j++){
                    table[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
                }
            }

            int sum = 0;
            for(int i = 0; i < N; i++){
                int d = Math.abs(i - c);
                for(int j = d; j <= N - 1 - d; j++){
                    sum += table[i][j];
                }
            }

            answer.append("#").append(t).append(" ").append(sum).append("\n");
        }
        answer.setLength(answer.length() - 1);
        System.out.print(answer);
    }
}
