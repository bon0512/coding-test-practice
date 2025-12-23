package baekjoon.binarysearch;

import java.util.Scanner;

public class BaekJoon_1072 {

    static long X, Y, Z;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        Y = sc.nextInt();
        Z = (Y * 100 / X);
        long end = 1_000_000_000;
        long start = 1;
        long answer = -1;

        if(Z>=99){
            System.out.println(-1);
            return;
        }

        while (start <= end) {
            long mid = (start + end) / 2;

            long newZ = (Y+mid) * 100 / (X+mid);

            if (newZ > Z) {
                end = mid-1;
                answer = mid;
            } else {
                start = mid + 1;
            }

        }

        System.out.println(answer);
    }
}
