package practice.programmers;

import java.util.PriorityQueue;

public class Programmers_더_맵게 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
        System.out.println(solution(new int[]{10, 20, 30}, 7));
        System.out.println(solution(new int[]{0, 0, 0, 0}, 100));
        System.out.println(solution(new int[]{1, 2}, 5));
        System.out.println(solution(new int[]{1, 2}, 6));
        System.out.println(solution(new int[]{0, 0, 0}, 0));

    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.offer(s);
        }

        int i = 0;
        while(pq.size() >= 2){
            int a = pq.poll();
            int b = pq.poll();

            if(a >= K){
                return i;
            }

            pq.offer(a + 2 * b);
            i++;
        }

        if(pq.poll() < K){
            return -1;
        }else{
            return i;
        }
    }
}
