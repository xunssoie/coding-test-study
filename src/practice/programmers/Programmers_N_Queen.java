package practice.programmers;

public class Programmers_N_Queen {
    public static void main(String[] args) {

    }
    int n;
    int answer = 0;
    boolean[] cols;
    boolean[] digs1;
    boolean[] digs2;

    public int solution(int n) {
        this.n = n;
        this.cols = new boolean[n];
        this.digs1 = new boolean[2 * n - 1];
        this.digs2 = new boolean[2 * n - 1];
        dfs(0);
        return answer;
    }

    private void dfs(int row){
        if(row == n){
            answer++;
            return;
        }

        for(int col = 0; col < n; col++){
            int d1 = row - col + n - 1;
            int d2 = row + col;

            if(cols[col] || digs1[d1] || digs2[d2])
                continue;

            cols[col] = digs1[d1] = digs2[d2] = true;
            dfs(row+1);
            cols[col] = digs1[d1] = digs2[d2] = false;
        }
    }
}
