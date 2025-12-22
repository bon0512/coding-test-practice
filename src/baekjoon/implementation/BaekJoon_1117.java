package baekjoon.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_1117 {
    static long W, H, f, c, x1, x2, y1, y2;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        W = sc.nextLong();
        H = sc.nextLong();
        f = sc.nextLong();
        c = sc.nextLong();
        x1 = sc.nextLong();
        y1 = sc.nextLong();
        x2 = sc.nextLong();
        y2 = sc.nextLong();

        long painted = (x2 - x1) * (y2 - y1) * (c + 1);

        if (f <= W / 2) {
            if (f > x1) {
                long overlap = Math.min(x2, f) - x1;
                if (overlap > 0) {
                    painted += overlap * (y2 - y1) * (c + 1);
                }
            }
        } else {
            if (W > f + x1) {
                long overlap = Math.min(x2 + f, W) - (f + x1);
                if (overlap > 0) {
                    painted += overlap * (y2 - y1) * (c + 1);
                }
            }
        }
        long answer = (W * H) - painted;
        System.out.println(answer);

        //겹치는 구간 설정
        // long overlap = Math.min(f, (W - f));
        // 이 구간은 무조건 한번은 있다. long widthBand = x2-x1;
        // 겹치는 부분을 한번더 더해주어야한다.
        // long extraBand = Math.min(overlap,x2) - x1;
        // if(extraBand<0) extraBand = 0;
        // long totalWidth = extraBand+widthBand;
        // long paint = totalWidth * (y2-y1)*(c+1);
        // long answer = W*H - paint;
        // System.out.println(answer);
    }
}