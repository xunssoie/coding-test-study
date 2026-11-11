package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_2806_N_Queen {

    static int N;
    static int count;
    static boolean[] cols;
    static boolean[] digs1;
    static boolean[] digs2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            count = 0;
            cols = new boolean[N];
            digs1 = new boolean[2 * N - 1];
            digs2 = new boolean[2 * N - 1];

            dfs(0);

            answer.append("#").append(t).append(" ").append(count).append("\n");
        }
        answer.setLength(answer.length() - 1);
        System.out.print(answer);
    }

    private static void dfs(int row) {
        if(row == N){
            count++;
            return;
        }

        for(int i = 0; i < N; i++){
            int d1 = row - i + N - 1;
            int d2 = row + i;

            if(cols[i] || digs1[d1] || digs2[d2])
                continue;

            cols[i] = digs1[d1] = digs2[d2] = true;
            dfs(row+1);
            cols[i] = digs1[d1] = digs2[d2] = false;
        }
    }
}
