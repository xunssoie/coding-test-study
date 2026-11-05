package practice.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1961_숫자_배열_회전 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];
            for(int i = 0; i < N; i++){
                StringTokenizer row = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(row.nextToken());
                }
            }

            answer.append("#").append(t).append("\n");

            int[][] r90 = rotate(map, N);
            int[][] r180 = rotate(r90, N);
            int[][] r270 = rotate(r180, N);

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    answer.append(r90[i][j]);
                }
                answer.append(" ");
                for(int j = 0; j < N; j++){
                    answer.append(r180[i][j]);
                }
                answer.append(" ");
                for(int j = 0; j < N; j++){
                    answer.append(r270[i][j]);
                }
                answer.append("\n");
            }
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }

    private static int[][] rotate(int[][] map, int N){
        int[][] r = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                r[i][j] = map[N-1-j][i];
            }
        }
        return r;
    }
}
