package practice.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974_스도쿠_검증 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            int[][] sudoku = new int[9][9];

            for(int i = 0; i < 9; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++){
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean flag = true;

            // 행 검사
            for(int i = 0; i < 9; i++){
                boolean[] exist = new boolean[9];
                for(int j = 0; j < 9; j++){
                    int num = sudoku[i][j];
                    exist[num-1] = true;
                }
                for(int j = 0; j < 9; j++){
                    if(!exist[j]){
                        flag = false;
                        break;
                    }
                }
                if(!flag)
                    break;
            }

            if(!flag){
                answer.append("#").append(t).append(" ").append(0).append("\n");
                continue;
            }

            // 열 검사
            for(int i = 0; i < 9; i++){
                boolean[] exist = new boolean[9];
                for(int j = 0; j < 9; j++){
                    int num = sudoku[j][i];
                    exist[num-1] = true;
                }
                for(int j = 0; j < 9; j++){
                    if(!exist[j]){
                        flag = false;
                        break;
                    }
                }
                if(!flag)
                    break;
            }

            if(!flag){
                answer.append("#").append(t).append(" ").append(0).append("\n");
                continue;
            }

            // 3x3 검사
            for(int i = 0; i < 9; i += 3){
                for(int j = 0; j < 9; j += 3){
                    boolean[] exist = new boolean[9];
                    for(int x = i; x < i+3; x++){
                        for(int y = j; y < j+3; y++){
                            int num = sudoku[x][y];
                            exist[num-1] = true;
                        }
                    }
                    for(int k = 0; k < 9; k++){
                        if(!exist[k]){
                            flag = false;
                            break;
                        }
                    }
                    if(!flag)
                        break;
                }
                if(!flag)
                    break;
            }

            if(flag){
                answer.append("#").append(t).append(" ").append(1).append("\n");
            }else{
                answer.append("#").append(t).append(" ").append(0).append("\n");
            }
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
