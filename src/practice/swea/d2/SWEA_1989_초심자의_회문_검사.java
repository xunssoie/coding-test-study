package practice.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1989_초심자의_회문_검사 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            String input = br.readLine();

            Stack<String> stack = new Stack<>();

            boolean flag = true;
            for(int i = 0; i < input.length(); i++){
                if(input.length() % 2 == 1 && i == input.length()/2)
                    continue;

                if(i < input.length()/2)
                    stack.push(String.valueOf(input.charAt(i)));

                if(i >= input.length()/2) {
                    String x = stack.pop();

                    if(!x.equals(String.valueOf(input.charAt(i)))){
                        flag = false;
                        break;
                    }
                }
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
