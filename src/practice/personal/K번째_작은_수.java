package practice.personal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class K번째_작은_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pr = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pr.offer(Integer.parseInt(st.nextToken()));
            if(pr.size() > k){
                pr.poll();
            }
        }

        System.out.print(pr.poll());
    }
}
