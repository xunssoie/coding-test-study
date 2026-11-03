package practice.swea.d1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2070_큰_놈_작은_놈_같은_놈 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a<b){
                answer.append("#").append(t).append(" ").append("<").append("\n");
            } else if (a>b) {
                answer.append("#").append(t).append(" ").append(">").append("\n");
            }else{
                answer.append("#").append(t).append(" ").append("=").append("\n");
            }
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
