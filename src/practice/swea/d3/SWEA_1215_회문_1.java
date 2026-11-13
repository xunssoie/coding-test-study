package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1215_회문_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());

            char[][] map1 = new char[8][8];
            for (int i = 0; i < 8; i++) {
                String row = br.readLine();
                for (int j = 0; j < 8; j++) {
                    map1[i][j] = row.charAt(j);
                }
            }

            int count = 0;

            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8 - N + 1; j++){
                    if(isPalindrome(map1, i, j, N)){
                        count++;
                    }
                }
            }

            char[][] map2 = new char[8][8];
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    map2[i][j] = map1[j][i];
                }
            }

            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8 - N + 1; j++){
                    if(isPalindrome(map2, i, j, N)){
                        count++;
                    }
                }
            }

            answer.append("#").append(t).append(" ").append(count).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }

    static boolean isPalindrome(char[][] map, int i, int j, int N){
        Stack<Character> stack = new Stack<>();

        for(int k = 0; k < N; k++){
            char value = map[i][j];

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
