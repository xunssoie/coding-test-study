package practice.programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Programmers_여행경로 {
    public static void main(String[] args) {
    }

    boolean[] visited;
    String[] answer;
    String[][] tickets;

    public String[] solution(String[][] tickets) {
        this.visited = new boolean[tickets.length];
        this.answer = new String[tickets.length + 1];
        this.tickets = tickets;

        answer[0] = "ICN";
        dfs("ICN", 0);
        return answer;
    }

    private boolean dfs(String from, int depth) {
        if (depth == tickets.length) {
            return true;
        }

        List<ToIdx> toIdxes = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(from) && !visited[i]) {
                toIdxes.add(new ToIdx(tickets[i][1], i));
            }
        }

        toIdxes.sort(Comparator.comparing(t -> t.to));

        for (ToIdx toIdx : toIdxes) {
            visited[toIdx.idx] = true;
            answer[depth + 1] = toIdx.to;

            if (dfs(toIdx.to, depth + 1)) {
                return true;
            }

            visited[toIdx.idx] = false;
        }
        return false;
    }

    record ToIdx(
            String to,
            int idx
    ) {
    }
}