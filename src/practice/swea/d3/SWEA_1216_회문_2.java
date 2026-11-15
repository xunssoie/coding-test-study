package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1216_회문_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= 10; t++) {
            int o = Integer.parseInt(br.readLine());

            char[][] boards = new char[100][100];

            for (int i = 0; i < 100; i++) {
                String rows = br.readLine();
                for (int j = 0; j < 100; j++) {
                    boards[i][j] = rows.charAt(j);
                }
            }

            int max = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    for (int k = max; k <= 100 - j; k++) {
                        if (isPalindrome(boards, i, j, k)) {
                            max = k;
                        }
                    }
                }
            }

            char[][] nBoards = new char[100][100];

            for(int i = 0; i < 100; i++){
                for(int j = 0; j < 100; j++){
                    nBoards[i][j] = boards[j][i];
                }
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    for (int k = max; k <= 100 - j; k++) {
                        if (isPalindrome(nBoards, i, j, k)) {
                            max = k;
                        }
                    }
                }
            }

            answer.append("#").append(o).append(" ").append(max).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }

    private static boolean isPalindrome(char[][] boards, int i, int j, int N){
        Stack<Character> stack = new Stack<>();

        for(int k = 0; k < N; k++){
            char value = boards[i][j];

            if(N % 2 == 1 && k == N/2){
                j++;
                continue;
            }

            if(k < N / 2){
                stack.push(value);
            }else{
                if(stack.pop() != value)
                    return false;
            }
            j++;
        }
        return true;
    }
}
