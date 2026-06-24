package practice.programmers;

public class Programmers_단어_변환 {

    boolean[] visited;
    String[] words;
    String target;
    int depth = Integer.MAX_VALUE;

    public int solution(
            String begin,
            String target,
            String[] words
    ){
        this.visited = new boolean[words.length];
        this.target = target;
        this.words = words;

        dfs(begin);
        return depth == Integer.MAX_VALUE ? 0 : depth;
    }

    private void dfs(String cur){
        if(cur.equals(target)){
            int curDepth = calDepth();

            if(curDepth < depth)
                depth = curDepth;

            return;
        }

        if(calDepth() > depth)
            return;

        for(int i = 0; i < words.length; i++){
            String next = words[i];

            if(replaceable(cur, next) && !visited[i]){
                visited[i] = true;
                dfs(next);
                visited[i] = false;
            }
        }
    }

    private boolean replaceable(
            String cur,
            String next
    ){
        int matchedCount = 0;
        for(int i = 0; i < cur.length(); i++){
            if(cur.charAt(i) == next.charAt(i))
                matchedCount++;
        }
        return matchedCount == cur.length()-1;
    }

    private int calDepth(){
        int usingCount = 0;
        for (boolean b : visited) {
            if(b)
                usingCount++;
        }
        return usingCount;
    }
}
