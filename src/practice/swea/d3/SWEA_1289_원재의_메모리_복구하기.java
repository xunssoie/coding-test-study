package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1289_원재의_메모리_복구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            String input = br.readLine();

            int sIdx = findStartIdx(input);

            int count = 0;
            boolean curZero = true;
            for(int i = sIdx; i < input.length(); i++){
                if (input.charAt(i) == '1' && curZero){
                    count++;
                    curZero = false;
                }

                if(input.charAt(i) == '0' && !curZero){
                    count++;
                    curZero = true;
                }
            }

            answer.append("#").append(t).append(" ").append(count).append("\n");
        }
        answer.setLength(answer.length() - 1);
        System.out.println(answer);
    }

    static int findStartIdx(String input) {
        for(int i = 0; i < input.length(); i++){
            if(Integer.parseInt(String.valueOf(input.charAt(i))) == 1){
                return i;
            }
        }
        return -1;
    }
}
