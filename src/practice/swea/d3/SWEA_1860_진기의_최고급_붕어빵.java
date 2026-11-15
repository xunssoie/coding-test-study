package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1860_진기의_최고급_붕어빵 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            boolean[] c = new boolean[11112];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                c[Integer.parseInt(st.nextToken())] = true;
            }

            boolean flag = true;
            int stock = 0;
            for(int i = 0; i < 11112; i++){
                if(i != 0 && i % M == 0){
                    stock += K;
                }

                if(c[i]){
                    if(stock == 0){
                        flag = false;
                        break;
                    }else{
                        stock--;
                    }
                }
            }

            if(flag){
                answer.append("#").append(t).append(" ").append("Possible").append("\n");
            }else{
                answer.append("#").append(t).append(" ").append("Impossible").append("\n");
            }
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
