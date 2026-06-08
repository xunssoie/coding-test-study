package practice.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Programmers_이중우선순위큐 {
    public static void main(String[] args) {
        // 예제 1: 모든 원소가 삭제되어 빈 큐 → [0, 0]
        System.out.println("answer= " + Arrays.toString(
                solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
        // 기대값: [0, 0]

        // 예제 2: 최종 [최댓값, 최솟값] = [333, -45]
        System.out.println("answer= " + Arrays.toString(
                solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
        // 기대값: [333, -45]

        // 엣지 1: 삽입 없이 삭제만 → 모두 무시 → [0, 0]
        System.out.println("answer= " + Arrays.toString(
                solution(new String[]{"D 1", "D -1"})));
        // 기대값: [0, 0]

        // 엣지 2: 원소 1개일 때 최댓값=최솟값
        System.out.println("answer= " + Arrays.toString(
                solution(new String[]{"I 42"})));
        // 기대값: [42, 42]

        // 엣지 3: 중복값 처리 — 같은 값이 여러 개일 때 삭제 동작 확인
        System.out.println("answer= " + Arrays.toString(
                solution(new String[]{"I 7", "I 7", "I 7", "D 1", "D -1"})));
        // 기대값: [7, 7]

        // 엣지 4: 빈 큐 상태에서 D가 섞여 들어와도 정상 무시되는지
        System.out.println("answer= " + Arrays.toString(
                solution(new String[]{"I 5", "D 1", "D 1", "I 10", "I 20", "D -1"})));
        // 기대값: [20, 20]
    }

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        PriorityQueue<Integer> ipq = new PriorityQueue<>((a, b) -> b-a);

        for(int i = 0; i < operations.length; i++){
            StringTokenizer st = new StringTokenizer(operations[i]);

            String op = st.nextToken();
            Integer val = Integer.parseInt(st.nextToken());

            if(op.equals("I")) {
                pq.offer(val);
                ipq.offer(val);
            }else{
                if (pq.isEmpty()){
                    continue;
                }
                if(val == 1){
                    // 최대값 제거
                    Integer max = ipq.poll();
                    pq.remove(max);
                }else{
                    // 최소값 제거
                    Integer min = pq.poll();
                    ipq.remove(min);
                }
            }
        }
        if (ipq.isEmpty()){
            return new int[]{0,0};
        }else{
            return new int[]{ipq.poll(), pq.poll()};
        }
    }
}
