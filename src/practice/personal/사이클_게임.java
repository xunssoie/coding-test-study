package practice.personal;

public class 사이클_게임 {

    public static void main(String[] args) {
        int solution1 = solution(3, new int[][]{{0, 1}, {1, 2}, {0, 2}});
        int solution2 = solution(4, new int[][]{{0, 1}, {2, 3}, {1, 2}});
        int solution3 = solution(4, new int[][]{{0, 1}, {1, 2}, {2, 0}, {0, 3}});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }

    static int[] parents;
    static int[] rank;

    public static int solution(int n, int[][] edges) {
        parents = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            int e1 = edge[0];
            int e2 = edge[1];

            if(!union(e1, e2)){
                return i;
            }
        }
        return -1;
    }

    public static int find(int x){
        if(parents[x] == x){
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public static boolean union(int a, int b){
        int ra = find(a);
        int rb = find(b);

        if(ra == rb)
            return false;

        if(rank[ra] > rank[rb]){
            parents[rb] = ra;
        }else if(rank[ra] < rank[rb]){
            parents[ra] = rb;
        }else{
            parents[rb] = ra;
            rank[ra]++;
        }
        return true;
    }
}
