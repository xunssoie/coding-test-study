package practice.programmers.lv3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Programmers_퍼즐_조각_채우기 {

    boolean[][] gVisited;
    boolean[][] tVisited;

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        int N = game_board.length;
        int M = game_board.length;

        List<List<int[]>> targetBoardPoints = new ArrayList<>();
        List<List<int[]>> availableTablePoints = new ArrayList<>();

        gVisited = new boolean[N][M];
        tVisited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(game_board[i][j] == 0 && !gVisited[i][j]){
                    List<int[]> boardPoints = extract(game_board, i, j, 0, gVisited);

                    targetBoardPoints.add(boardPoints);
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(table[i][j] == 1 && !tVisited[i][j]){
                    List<int[]> boardPoints = extract(table, i, j, 1, tVisited);

                    availableTablePoints.add(boardPoints);
                }
            }
        }

        boolean[] used = new boolean[availableTablePoints.size()];

        for(int i = 0; i < targetBoardPoints.size(); i++){
            List<int[]> targetBoardPoint = targetBoardPoints.get(i);
            List<int[]> normalizedBoardPoint = normalizePoint(targetBoardPoint);

            for(int j = 0; j < availableTablePoints.size(); j++){
                List<int[]> availableTablePoint = availableTablePoints.get(j);
                List<int[]> normalizedAvailableTablePoint = normalizePoint(availableTablePoint);

                if(used[j])
                    continue;

                if(matchTwoPoint(normalizedBoardPoint, normalizedAvailableTablePoint)){
                    used[j] = true;
                    answer += normalizedBoardPoint.size();
                    break;
                }
            }
        }

        return answer;
    }

    private List<int[]> extract(int[][] map, int i, int j, int q, boolean[][] visited) {
        int[] dx = {0, -1, 0, +1};
        int[] dy = {-1, 0, +1, 0};

        List<int[]> output = new ArrayList<>();

        Stack<int[]> stack = new Stack<>();

        visited[i][j] = true;
        stack.push(new int[]{i, j});

        while(!stack.isEmpty()){
            int[] pop = stack.pop();

            int x = pop[0];
            int y = pop[1];

            output.add(new int[]{x, y});

            for(int c = 0; c < 4; c++){
                int nx = x + dx[c];
                int ny = y + dy[c];

                if(inRange(map.length, nx, ny) && !visited[nx][ny] && map[nx][ny] == q){
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }
        }

        return output;
    }

    private boolean inRange(int n, int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private List<int[]> normalizePoint(List<int[]> targetBoardPoint) {
        targetBoardPoint.sort(Comparator.comparingInt((int[] x) -> x[0]).thenComparingInt(x -> x[1]));

        int baseX = targetBoardPoint.getFirst()[0];
        int baseY = targetBoardPoint.getFirst()[1];

        List<int[]> output = new ArrayList<>();

        output.add(new int[]{0,0});

        for(int i = 1; i < targetBoardPoint.size(); i++){
            int x = targetBoardPoint.get(i)[0];
            int y = targetBoardPoint.get(i)[1];

            output.add(new int[]{baseX-x, baseY-y});
        }

        return output;
    }

    private boolean matchTwoPoint(List<int[]> normalizedBoardPoint, List<int[]> normalizedAvailableTablePoint) {
        if (normalizedBoardPoint.size() != normalizedAvailableTablePoint.size()) {
            return false;
        }

        List<int[]> current = normalizedBoardPoint;
        for (int i = 0; i < 4; i++) {
            if (isSame(current, normalizedAvailableTablePoint)) {
                return true;
            }
            current = normalizePoint(rotate(current));
        }
        return false;
    }

    private boolean isSame(List<int[]> a, List<int[]> b) {
        for (int j = 0; j < a.size(); j++) {
            if (a.get(j)[0] != b.get(j)[0] || a.get(j)[1] != b.get(j)[1]) {
                return false;
            }
        }
        return true;
    }

    private List<int[]> rotate(List<int[]> points){
        List<int[]> output = new ArrayList<>();

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            output.add(new int[]{y, -x});
        }

        return output;
    }
}
