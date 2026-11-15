package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225_암호생성기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        for(int t = 0; t < 10; t++){
            int o = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            Queue<Integer> queue = new LinkedList<>();

            for(int i = 0; i < 8; i++){
                queue.add(Integer.parseInt(st.nextToken()));
            }

            for(int i = 0;;i++){
                int value = queue.poll();

                value = value - (i % 5 + 1);

                if(value <= 0){
                    value = 0;
                    queue.add(value);
                    break;
                }
                queue.add(value);
            }

            answer.append("#").append(o).append(" ");
            for(int i = 0; i < 8; i++){
                answer.append(queue.poll()).append(" ");
            }
            answer.setLength(answer.length() - 1);
            answer.append("\n");
        }
        answer.setLength(answer.length() - 1);
        System.out.print(answer);
    }
}
