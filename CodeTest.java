
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution
{
    public static void main(String args[] )
    {
        Scanner sc = new Scanner(System.in);
        java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>();
        while (sc.hasNextInt()) list.add(sc.nextInt());

        int days;
        int n;
        int[] state;

        if (list.size() >= 10 && list.get(0) == list.size() - 2) {
            n = list.get(0);
            state = new int[n];
            for (int i = 0; i < n; i++) state[i] = list.get(i + 1);
            days = list.get(n + 1);
        } else {
            days = list.get(0);
            n = list.size() - 1;
            state = new int[n];
            for (int i = 0; i < n; i++) state[i] = list.get(i + 1);
        }

        days %= 14;

        for (int d = 0; d < days; d++) {
            int[] next = new int[n];
            for (int i = 0; i < n; i++) {
                int left = i == 0 ? 0 : state[i - 1];
                int right = i == n - 1 ? 0 : state[i + 1];
                next[i] = left == right ? 0 : 1;
            }
            state = next;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(" ");
            sb.append(state[i]);
        }
        System.out.print(sb.toString());
    }
}
