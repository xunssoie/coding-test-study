package practice.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1926_간단한_369게임 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++){
            answer.append(numOrClap(i)).append(" ");
        }

        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }

    private static String numOrClap(int input){
        String target = String.valueOf(input);
        int digit = target.length();

        StringBuilder output = new StringBuilder();
        for(int i = 0; i < digit; i++){
            int t = target.charAt(i);
            if(t == '3' || t == '6' || t == '9')
                output.append("-");
        }

        if(output.toString().isEmpty()){
            return target;
        }else{
            return output.toString();
        }
    }
}
