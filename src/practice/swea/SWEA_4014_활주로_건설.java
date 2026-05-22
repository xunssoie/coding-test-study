package practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014_활주로_건설 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for (int tc = 1; tc <= testCase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int gridSize = Integer.parseInt(st.nextToken());
            int slopeLength = Integer.parseInt(st.nextToken());

            int[][] grid = new int[gridSize][gridSize];

            for (int row = 0; row < gridSize; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < gridSize; col++) {
                    grid[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int buildableCount = 0;

            // 행 검사
            for (int row = 0; row < gridSize; row++) {
                int[] rowHeights = grid[row];

                boolean isBuildable = true;

                boolean[] slopeUsed = new boolean[gridSize];
                for (int col = 0; col < gridSize; col++) {
                    slopeUsed[col] = true;
                }

                int prevHeight = rowHeights[0];
                for (int col = 1; col < gridSize; col++) {
                    if (prevHeight != rowHeights[col]) {
                        if (Math.abs(prevHeight - rowHeights[col]) > 1) {
                            isBuildable = false;
                            break;
                        }
                        if (Math.abs(prevHeight - rowHeights[col]) == 1) {
                            if (prevHeight - rowHeights[col] > 0) {
                                if (checkPossibleWay1stCase(rowHeights, slopeUsed, col, slopeLength)) {
                                    prevHeight = rowHeights[col];
                                    continue;
                                } else {
                                    isBuildable = false;
                                    break;
                                }
                            } else {
                                if (checkPossibleWay2ndCase(rowHeights, slopeUsed, col, slopeLength)) {
                                    prevHeight = rowHeights[col];
                                    continue;
                                } else {
                                    isBuildable = false;
                                    break;
                                }
                            }
                        }
                    }
                    prevHeight = rowHeights[col];
                }
                if (isBuildable) {
                    buildableCount++;
                }
            }

            // 열 검사
            for (int col = 0; col < gridSize; col++) {
                int[] colHeights = new int[gridSize];
                for (int row = 0; row < gridSize; row++) {
                    colHeights[row] = grid[row][col];
                }

                boolean isBuildable = true;
                boolean[] slopeUsed = new boolean[gridSize];
                for (int row = 0; row < gridSize; row++) {
                    slopeUsed[row] = true;
                }
                int prevHeight = colHeights[0];
                for (int row = 1; row < gridSize; row++) {
                    if (prevHeight != colHeights[row]) {
                        if (Math.abs(prevHeight - colHeights[row]) > 1) {
                            isBuildable = false;
                            break;
                        }
                        if (Math.abs(prevHeight - colHeights[row]) == 1) {
                            if (prevHeight - colHeights[row] > 0) {
                                if (checkPossibleWay1stCase(colHeights, slopeUsed, row, slopeLength)) {
                                    prevHeight = colHeights[row];
                                    continue;
                                } else {
                                    isBuildable = false;
                                    break;
                                }
                            } else {
                                if (checkPossibleWay2ndCase(colHeights, slopeUsed, row, slopeLength)) {
                                    prevHeight = colHeights[row];
                                    continue;
                                } else {
                                    isBuildable = false;
                                    break;
                                }
                            }
                        }
                    }
                    prevHeight = colHeights[row];
                }
                if (isBuildable) {
                    buildableCount++;
                }
            }
            answer.append("#").append(tc).append(" ").append(buildableCount).append("\n");
        }
        answer.setLength(answer.length() - 1);
        System.out.print(answer);
    }

    private static boolean checkPossibleWay1stCase(int[] heights, boolean[] slopeUsed, int idx, int slopeLength) {
        int curHeight = heights[idx];

        if (idx + slopeLength - 1 > heights.length - 1) {
            return false;
        }

        for (int i = idx; i < idx + slopeLength; i++) {
            if (!slopeUsed[i]) {
                return false;
            }
            if (heights[i] != curHeight) {
                return false;
            }
        }

        for (int i = idx; i < idx + slopeLength; i++) {
            slopeUsed[i] = false;
        }

        return true;
    }

    private static boolean checkPossibleWay2ndCase(int[] heights, boolean[] slopeUsed, int idx, int slopeLength) {
        int prevHeight = heights[idx - 1];

        if (idx - slopeLength < 0) {
            return false;
        }

        for (int i = idx - 1; i > idx - slopeLength - 1; i--) {
            if (!slopeUsed[i]) {
                return false;
            }
            if (heights[i] != prevHeight) {
                return false;
            }
        }

        for (int i = idx - 1; i > idx - slopeLength - 1; i--) {
            slopeUsed[i] = false;
        }

        return true;
    }
}