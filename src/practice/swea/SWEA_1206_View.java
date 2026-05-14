package practice.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1206_View {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();

            StringTokenizer st = new StringTokenizer(line);
            List<Integer> buildings = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                buildings.add(Integer.parseInt(st.nextToken()));
            }

            int totalView = 0;
            for (int i = 0; i < n; i++) {
                if (buildings.get(i) == 0)
                    continue;

                if (isViewClear(buildings, i)) {
                    int maxNeighbor = getMaxNeighborHeight(buildings, i);
                    totalView += buildings.get(i) - maxNeighbor;
                }
            }

            sb.append("#").append(t).append(" ").append(totalView).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }

    private static int getMaxNeighborHeight(List<Integer> buildings, int idx) {
        int start = Math.max(idx - 2, 0);
        int end = Math.min(idx + 2, buildings.size() - 1);

        int max = buildings.get(start);
        for (int i = start; i <= end; i++) {
            if (i == idx)
                continue;

            if (max < buildings.get(i))
                max = buildings.get(i);
        }

        return max;
    }

    private static boolean isViewClear(List<Integer> buildings, int idx) {
        int curHeight = buildings.get(idx);
        int start = Math.max(idx - 2, 0);
        int end = Math.min(idx + 2, buildings.size() - 1);

        for (int i = start; i <= end; i++) {
            if (i == idx)
                continue;

            if (curHeight < buildings.get(i))
                return false;
        }
        return true;
    }
}