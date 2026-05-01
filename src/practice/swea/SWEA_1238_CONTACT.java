package practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238_CONTACT {

    private static final int MAX_NODE = 100;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 10; t++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int dataLength = Integer.parseInt(st.nextToken());
            int startNode = Integer.parseInt(st.nextToken());

            // 간선을 (from, to) 쌍으로 저장하는 리스트
            List<Pair> pairs = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < dataLength / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                Pair pair = new Pair(from, to);

                // 동일한 간선이 중복 저장되는 것을 방지
                if (!pairs.contains(pair)) {
                    pairs.add(pair);
                }
            }

            boolean[] visited = new boolean[MAX_NODE + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(startNode);
            visited[startNode] = true;

            // 가장 깊은 레벨에서 방문한 노드들을 보관
            List<Integer> lastLevel = new ArrayList<>();
            lastLevel.add(startNode);

            // 레벨 단위로 처리
            while (!queue.isEmpty()) {
                // 루프 진입 시점의 큐 크기 = 현재 레벨에 속한 노드 수
                int levelSize = queue.size();
                List<Integer> currentLevel = new ArrayList<>();

                // 현재 레벨의 노드를 모두 꺼내 다음 레벨의 노드를 큐에 추가
                for (int i = 0; i < levelSize; i++) {
                    int current = queue.poll();

                    // 현재 노드와 연결된 인접 노드 = 다음 레벨 후보
                    List<Integer> neighbors = findNeighbors(pairs, current);
                    for (int next : neighbors) {
                        // 미방문 노드만 큐에 추가
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.add(next);
                            currentLevel.add(next);
                        }
                    }
                }

                if (!currentLevel.isEmpty()) {
                    lastLevel = currentLevel;
                }
            }

            int max = lastLevel.get(0);
            for (int node : lastLevel) {
                if (max < node) {
                    max = node;
                }
            }

            sb.append("#" + (t + 1) + " ").append(max).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    static class Pair {
        int from;
        int to;

        Pair(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return this.from == pair.from && this.to == pair.to;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }

    static List<Integer> findNeighbors(List<Pair> pairs, int target) {
        List<Integer> neighbors = new ArrayList<>();

        for (Pair pair : pairs) {
            if (pair.from == target) {
                neighbors.add(pair.to);
            }
        }

        return neighbors;
    }
}