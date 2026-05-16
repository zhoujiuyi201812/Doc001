package two;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());

        int[][] ans = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(parts[j]);
                if (v == 1) {
                    ans[i][j] = 0;
                    q.offer(new int[]{i, j});
                } else {
                    ans[i][j] = -1;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && ans[nx][ny] == -1) {
                    ans[nx][ny] = ans[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) sb.append(" ");
                sb.append(ans[i][j]);
            }
            if (i < m - 1) sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
