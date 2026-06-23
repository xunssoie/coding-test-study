package practice.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Programmers_네트워크 {
    public static void main(String[] args) {

    }

    public static int solution(
            int n,
            int[][] computers
    ) {
        List<List<Integer>> adjLists = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adjLists.add(i, new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            int[] connected = computers[i];
            List<Integer> adjList = adjLists.get(i);
            for(int j = 0; j < n; j ++){
                if(j != i && connected[j] == 1){
                    adjList.add(j);
                }
            }
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        int answer = 0;

        for(int i = 0; i < n; i++){
            if(visited[i])
                continue;

            visited[i] = true;
            queue.offer(i);

            while(!queue.isEmpty()){
                Integer cur = queue.poll();

                List<Integer> nexts = adjLists.get(cur);
                for (Integer next : nexts) {
                    if(!visited[next]){
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}
