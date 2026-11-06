package practice.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_2005_파스칼의_삼각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] pascal = new int[N][N];
            pascal[0][0] = 1;
            for(int i = 1; i < N; i++){
                for(int j = 0; j < N; j++){
                    int left, right;

                    if(j-1 == -1){
                        left = 0;
                    }else{
                        left = pascal[i-1][j-1];
                    }

                    if(j == i){
                        right = 0;
                    }else{
                        right = pascal[i-1][j];
                    }

                    pascal[i][j] = left+right;
                }
            }

            StringBuilder subAnswer = new StringBuilder();
            for(int i = 0; i < N; i++){
                for(int j = 0; j <= i; j++){
                    subAnswer.append(pascal[i][j]).append(" ");
                }
                subAnswer.setLength(subAnswer.length()-1);
                subAnswer.append("\n");
            }

            answer.append("#").append(t).append("\n").append(subAnswer);
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
