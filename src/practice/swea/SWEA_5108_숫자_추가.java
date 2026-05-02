package practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5108_숫자_추가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < N; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());

                int index = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                list.add(index,  value);
            }

            answer.append("#").append(t+1).append(" ").append(list.get(L)).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
