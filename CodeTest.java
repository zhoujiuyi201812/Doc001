  import java.io.*;
import java.util.*;

class Solution {
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String args[]) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int k = fs.nextInt();

        if (n <= 0 || k <= 0) {
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }

        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (!q.isEmpty() && q.peekFirst() <= i - k) {
                q.pollFirst();
            }

            if (arr[i] < 0) {
                q.offerLast(i);
            }

            if (i >= k - 1) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(q.isEmpty() ? 0 : arr[q.peekFirst()]);
            }
        }

        System.out.print(sb.toString());
    }
}
