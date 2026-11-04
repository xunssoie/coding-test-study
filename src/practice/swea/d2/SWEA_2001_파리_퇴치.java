package practice.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001_파리_퇴치 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];
            for(int i = 0; i < N; i++){
                StringTokenizer row = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(row.nextToken());
                }
            }

            int max = 0;
            for(int j = 0; j <= N-M; j++){
                for(int i = 0; i <= N-M; i++){
                    int sum = 0;
                    for(int k = j; k < j+M; k++){
                        for(int l = i; l < i+M; l++){
                            sum += map[k][l];
                        }
                    }
                    if(sum > max)
                        max = sum;
                }
            }
            answer.append("#").append(t).append(" ").append(max).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
