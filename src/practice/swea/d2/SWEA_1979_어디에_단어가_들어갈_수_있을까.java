package practice.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1979_어디에_단어가_들어갈_수_있을까 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] puzzle = new int[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    puzzle[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int total = 0;

            for(int x = 0; x < N; x++){
                for(int i = 0; i <= N-K; i++){
                    boolean flag = true;
                    for(int j = i; j < i+K; j++){
                        if(puzzle[x][j] == 0){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        if((i == 0) && (i+K != N) && (puzzle[x][i+K] == 0)) {
                            total++;
                        }else if((i != 0) && (i+K != N) && (puzzle[x][i-1] == 0) && (puzzle[x][i+K] == 0)){
                            total++;
                        }else if((i != 0) && (i+K == N) && (puzzle[x][i-1] == 0)){
                            total++;
                        }else if((i == 0) && (i+K == N)){
                            total++;
                        }
                    }
                }
            }

            for(int x = 0; x < N; x++){
                for(int i = 0; i <= N-K; i++){
                    boolean flag = true;
                    for(int j = i; j < i+K; j++){
                        if(puzzle[j][x] == 0){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        if((i == 0) && (i+K != N) && (puzzle[i+K][x] == 0)) {
                            total++;
                        }else if((i != 0) && (i+K != N) && (puzzle[i-1][x] == 0) && (puzzle[i+K][x] == 0)){
                            total++;
                        }else if((i != 0) && (i+K == N) && (puzzle[i-1][x] == 0)){
                            total++;
                        }else if((i == 0) && (i+K == N)){
                            total++;
                        }
                    }
                }
            }
            answer.append("#").append(t).append(" ").append(total).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
