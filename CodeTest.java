import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution
{
    public static void main(String args[] ) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split("\\s+");

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(parts[i]);
            ans[value] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(' ');
            sb.append(ans[i]);
        }

        System.out.print(sb.toString());
    }
}
