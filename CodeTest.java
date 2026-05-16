import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int radioCap = sc.nextInt();
        int numLiq = sc.nextInt();
        int mass = sc.nextInt();

        int[] vol = new int[numLiq];
        int[] wt = new int[numLiq];
        int[] energy = new int[numLiq];

        for (int i = 0; i < numLiq; i++) vol[i] = sc.nextInt();
        for (int i = 0; i < numLiq; i++) wt[i] = sc.nextInt();
        for (int i = 0; i < numLiq; i++) energy[i] = sc.nextInt();

        long[][] dp = new long[radioCap + 1][mass + 1];

        for (int i = 0; i < numLiq; i++) {
            for (int v = radioCap; v >= vol[i]; v--) {
                for (int m = mass; m >= wt[i]; m--) {
                    dp[v][m] = Math.max(dp[v][m], dp[v - vol[i]][m - wt[i]] + energy[i]);
                }
            }
        }

        System.out.println(dp[radioCap][mass]);
    }
}
