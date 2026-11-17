package practice.programmers.lv3;

public class Programmers_네트워크 {
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1,1,0},{1,1,1},{0,1,1}}));
    }

    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i,computers);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int node, int[][] computers){
        visited[node] = true;
        for(int i = 0; i < computers.length; i++){
            if(!visited[i] && computers[node][i] == 1){
                visited[i] = true;
                dfs(i,computers);
            }
        }
    }
}
