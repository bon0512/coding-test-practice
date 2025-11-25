package baekjoon.dp;

import java.util.Scanner;

public class BaekJoon_17404 {

    static int N;
    static int[][] mem;
    static int[][] houseColor;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        houseColor = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            houseColor[i][0] = sc.nextInt();
            houseColor[i][1] = sc.nextInt();
            houseColor[i][2] = sc.nextInt();
        }

        //첫 번째 집에서 색깔을 정하고 시작한다. R,G,B중  하나 선택하고 시작
        for (int first = 0; first < 3; first++) {

            mem = new int[N + 1][3];

            /**
             * 첫번째집 컬러가 빨간색일때 first 0 color 0
             * 첫번째찝 컬러가 초록색일때 first 1 color 1
             * 파란색도 마찬가지
             * 나머지는 선택 못하게 최대값 부여
             */
            for (int color = 0; color < 3; color++) {
                if (first == color) mem[1][color] = houseColor[1][color];
                else mem[1][color] = 1000 * 1000;
            }

            for (int i = 2; i <= N; i++) {
                mem[i][0] = Math.min(mem[i - 1][1], mem[i - 1][2]) + houseColor[i][0];
                mem[i][1] = Math.min(mem[i - 1][0], mem[i - 1][2]) + houseColor[i][1];
                mem[i][2] = Math.min(mem[i - 1][1], mem[i - 1][0]) + houseColor[i][2];

            }

            mem[N][first] = 10000000;

            answer = Math.min(answer,Math.min(Math.min(mem[N][0], mem[N][1]), mem[N][2]));

        }

        System.out.println(answer);
    }
}
