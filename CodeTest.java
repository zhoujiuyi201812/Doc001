import java.io.*;
import java.util.*;

class Solution {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

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
            } while (c <= 32 && c != -1);

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > 32 && c != -1) {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String args[]) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();

        if (n <= 0) {
            System.out.print(0);
            return;
        }

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }

        long[] intervals = new long[n];
        long offset = 1000000000L;

        for (int i = 0; i < n; i++) {
            int b = fs.nextInt();
            int l = Math.min(a[i], b);
            int r = Math.max(a[i], b);
            intervals[i] = ((r + offset) << 32) | (l + offset);
        }

        Arrays.sort(intervals);

        int ans = 0;
        long point = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            long start = (intervals[i] & 0xffffffffL) - offset;
            long end = (intervals[i] >>> 32) - offset;

            if (start > point) {
                ans++;
                point = end;
            }
        }

        System.out.print(ans);
    }
}
