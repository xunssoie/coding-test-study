package practice.personal;

public class union_find {
    public static void main(String[] args) {

    }

    class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n+1];
            rank = new int[n+1];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x){
            // 자기 자신이 부모 = Root
            if(x == parent[x]){
                return x;
            }

            return parent[x] = find(parent[x]);
        }

        // 두 무리를 병합
        boolean union(int a, int b){
            // 입력 원소의 부모 찾기
            int ra = find(a);
            int rb = find(b);

            // 부모가 같다면
            if(ra == rb)
                return false;

            if(rank[ra] > rank[rb]){
                parent[rb] = ra;
            }else if(rank[ra] < rank[rb]){
                parent[ra] = rb;
            }else{
                parent[rb] = ra;
                rank[ra]++;
            }

            return true;
        }
    }
}
