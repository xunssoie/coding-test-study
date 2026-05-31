package practice.personal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class HashSetExample01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++){
            Integer value = Integer.parseInt(st.nextToken());

            if(set.contains((value))){
                answer++;
                set.remove(value);
            }
        }
        System.out.println("answer = " + answer);
    }
}
