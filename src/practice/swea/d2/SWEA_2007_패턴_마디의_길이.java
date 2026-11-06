package practice.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class SWEA_2007_패턴_마디의_길이 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            String target = br.readLine();

            for(int i = 1; i <= 10; i++){
                HashSet<String> set = new HashSet<>();
                String part = target.substring(0,i);
                for(int j = 0; j < target.length()-i; j+=i){
                    set.add(target.substring(j, j+i));
                }

                if(set.size() == 1){
                    answer.append("#").append(t).append(" ").append(part.length()).append("\n");
                    break;
                }
            }
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
