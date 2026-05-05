package practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1219_길찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < 10; t ++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int I =  Integer.parseInt(st.nextToken());

            List<Path> paths = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < I; i++){
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                Path path =  new Path(start, end);
                paths.add(path);
            }

            boolean flag = false;

            boolean[] visited = new boolean[100];
            Queue<Integer> queue = new LinkedList<>();

            int cur = 0;
            visited[cur] = true;
            queue.offer(cur);

            while(!queue.isEmpty()){
                cur = queue.poll();

                if(cur == 99){
                    flag = true;
                    break;
                }

                List<Integer> nextPath = getPossiblePath(paths, cur);

                for (Integer i : nextPath) {
                    if(!visited[i]){
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }

            if(!flag){
                sb.append("#").append(N).append(" ").append(0).append("\n");
            }else{
                sb.append("#").append(N).append(" ").append(1).append("\n");
            }
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }

    static List<Integer> getPossiblePath(List<Path> paths, int cur){

        List<Integer> possiblePath = new ArrayList<>();
        for (Path path : paths) {
            if(path.start == cur){
                possiblePath.add(path.end);
            }
        }
        return possiblePath;
    }

    static class Path{
        int start;
        int end;

        public Path(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
