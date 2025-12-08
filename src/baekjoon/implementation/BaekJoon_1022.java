package baekjoon.implementation;

import java.util.Scanner;

public class BaekJoon_1022 {

    static int r1, c1, r2, c2;
    static int[][] grid;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();

        int sizeY = r2 - r1 + 1;
        int sizeX = c2 - c1 + 1;
        grid = new int[sizeY][sizeX];
    }
}
