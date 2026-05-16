
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String args[] ) {
        Scanner sc = new Scanner(System.in);

        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double r1 = sc.nextDouble();

        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double r2 = sc.nextDouble();

        double dx = x1 - x2;
        double dy = y1 - y2;
        double d = Math.sqrt(dx * dx + dy * dy);

        double ans;

        if (d >= r1 + r2) {
            ans = 0.0;
        } else if (d <= Math.abs(r1 - r2)) {
            double r = Math.min(r1, r2);
            ans = Math.PI * r * r;
        } else {
            double v1 = (d * d + r1 * r1 - r2 * r2) / (2 * d * r1);
            double v2 = (d * d + r2 * r2 - r1 * r1) / (2 * d * r2);

            v1 = Math.max(-1.0, Math.min(1.0, v1));
            v2 = Math.max(-1.0, Math.min(1.0, v2));

            double a1 = Math.acos(v1);
            double a2 = Math.acos(v2);

            double area1 = r1 * r1 * a1;
            double area2 = r2 * r2 * a2;
            double area3 = 0.5 * Math.sqrt((-d + r1 + r2) * (d + r1 - r2) * (d - r1 + r2) * (d + r1 + r2));

            ans = area1 + area2 - area3;
        }

        System.out.printf("%.6f", ans);
    }
}
