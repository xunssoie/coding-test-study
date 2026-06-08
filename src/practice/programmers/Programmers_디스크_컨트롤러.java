package practice.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Programmers_디스크_컨트롤러 {
    public static void main(String[] args) {
        // 1) 공식 예제 → 9
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));

        // 2) 작업 1개 (반환시간 = 소요시간) → 5
        System.out.println(solution(new int[][]{{0, 5}}));

        // 3) 동시 도착, SJF 검증 (1,3,6)/3 = 3.33 → 3
        System.out.println(solution(new int[][]{{0, 1}, {0, 2}, {0, 3}}));

        // 4) 유휴 구간 발생 (디스크가 노는 시간 처리) → 3
        System.out.println(solution(new int[][]{{0, 3}, {5, 3}}));

        // 5) 요청시각 비정렬 + 동률 짧은 작업 우선 → 4
        System.out.println(solution(new int[][]{{1, 4}, {0, 2}, {3, 1}, {2, 5}}));
    }

    public static int solution(int[][] jobs){
        // 도착 시간 순서대로 우선순위 큐에 삽입
        PriorityQueue<Task> taskPq = new PriorityQueue<>(Comparator.comparingInt(a -> a.arrivalTime));
        for (int[] job : jobs) {
            taskPq.add(new Task(job[0], job[1]));
        }

        // 우선순위를 반영해서 처리 가능한 작업 대기 큐
        PriorityQueue<Task> waitingPq = new PriorityQueue<>( (a, b) ->{
            if(a.processingTime == b.processingTime)
                return a.arrivalTime - b.arrivalTime;
            return a.processingTime - b.processingTime;
        });

        int answer = 0;
        int time = 0;
        while(!waitingPq.isEmpty() || !taskPq.isEmpty()){
            // 현재시간 기준 작업 가능한 작업 큐에 넣기
            while(!taskPq.isEmpty() && taskPq.peek().arrivalTime <= time){
                Task task = taskPq.poll();
                waitingPq.offer(task);
            }

            // 현재시간 기준 작업 가능한 작업이 없다면, 가장 가까운 작업 시간대로 점프
            if (waitingPq.isEmpty() && !taskPq.isEmpty()){
                time = taskPq.peek().arrivalTime;
                while(!taskPq.isEmpty() && taskPq.peek().arrivalTime <= time){
                    Task task = taskPq.poll();
                    waitingPq.offer(task);
                }
            }

            Task task = waitingPq.poll();
            time += task.processingTime;
            answer += time - task.arrivalTime;
        }

        return answer/jobs.length;
    }

    static class Task{
        int arrivalTime;
        int processingTime;

        public Task(int arrivalTime, int processingTime) {
            this.arrivalTime = arrivalTime;
            this.processingTime = processingTime;
        }
    }
}
