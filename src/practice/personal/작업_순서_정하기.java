package practice.personal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class 작업_순서_정하기 {
    public int[] solution(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
            indegree[prerequisite[1]]++;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int[] answer = new int[n];
        int i = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            answer[i++] = cur;

            for (Integer next : graph.get(cur)) {
                indegree[next]--;

                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }

        if(i != n){
            return new int[0];
        }
        return answer;
    }
}
