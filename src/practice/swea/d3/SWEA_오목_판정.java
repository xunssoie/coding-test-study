package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_오목_판정 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            char[][] map = new char[N][N];
            for(int i = 0; i < N; i++){
                String row = br.readLine();
                for(int j = 0; j < N; j++){
                    map[i][j] = row.charAt(j);
                }
            }

            boolean result = false;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] == 'o'){
                        if(isOMock(map, i, j)){
                            result = true;
                            break;
                        }
                    }
                }
                if(result)
                    break;
            }

            if(result){
                answer.append("#").append(t).append(" ").append("YES").append("\n");
            }else{
                answer.append("#").append(t).append(" ").append("NO").append("\n");
            }
        }
        answer.setLength(answer.length() - 1);
        System.out.print(answer);
    }

    private static boolean isOMock(char[][] map, int x, int y){
        int[] dx = {-1, -1, 0, +1, +1, +1, 0, -1};
        int[] dy = {0, +1, +1, +1, 0, -1, -1, -1};

        boolean result = false;
        for(int i = 0; i < 8; i++){
            int nx = x;
            int ny = y;
            for(int j = 0; j < 4; j++){
                nx += dx[i];
                ny += dy[i];

                if(!inRange(nx, ny, map.length) || !(map[nx][ny] == 'o')) {
                    break;
                }

                if(j == 3){
                    result = true;
                }
            }

            if (result)
                break;
        }
        return result;
    }

    private static boolean inRange(int x, int y, int n){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
