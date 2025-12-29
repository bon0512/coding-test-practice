package baekjoon.backtracking;


import java.util.Scanner;

/**
 * 무기공학
 * <a href="https://www.acmicpc.net/problem/18430">...</a>
 */
public class BaekJoon_18430 {

    static int N, M;
    static int[][] price;
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;
    static int tempAnswer = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        price = new int[N][M];

        if(N<2 || M<2){
            System.out.println(0);
            return ;
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                price[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[N][M];
        backTracking(0,0);
        System.out.println(answer);

    }

    private static void backTracking(int centerY, int centerX) {
        if (centerY >= N) {
            answer = Math.max(tempAnswer, answer);
            return;
        }

        if (centerX >= M) {
            backTracking(centerY + 1, 0);
            return;
        }

        //안만들고 그냥 넘어가기

        backTracking(centerY,centerX+1);

        if(visited[centerY][centerX]){
            return;
        }

        //첫번째 ㄱ 모양
        if (centerX - 1 >= 0 && centerY + 1 < N) {
            if (!visited[centerY][centerX] && !visited[centerY][centerX - 1] && !visited[centerY + 1][centerX]) {
                visited[centerY][centerX] = true;
                visited[centerY][centerX - 1] = true;
                visited[centerY + 1][centerX] = true;
                tempAnswer += price[centerY][centerX] * 2 + price[centerY][centerX - 1] + price[centerY + 1][centerX];
                backTracking(centerY, centerX + 1);

                tempAnswer -= price[centerY][centerX] * 2 + price[centerY][centerX - 1] + price[centerY + 1][centerX];

                visited[centerY][centerX] = false;
                visited[centerY][centerX - 1] = false;
                visited[centerY + 1][centerX] = false;
            }
        }

        //두번째 모양
        if (centerY - 1 >= 0 && centerX - 1 >= 0) {
            if (!visited[centerY][centerX] && !visited[centerY][centerX - 1] && !visited[centerY - 1][centerX]) {
                visited[centerY][centerX] = true;
                visited[centerY][centerX - 1] = true;
                visited[centerY - 1][centerX] = true;

                tempAnswer += price[centerY][centerX] * 2 + price[centerY][centerX - 1] + price[centerY - 1][centerX];
                backTracking(centerY, centerX + 1);
                tempAnswer -= price[centerY][centerX] * 2 + price[centerY][centerX - 1] + price[centerY - 1][centerX];

                visited[centerY][centerX] = false;
                visited[centerY][centerX - 1] = false;
                visited[centerY - 1][centerX] = false;
            }
        }

        //세번째 모양 ㄴ 모양

        if (centerY - 1 >= 0 && centerX + 1 < M) {
            if (!visited[centerY][centerX] && !visited[centerY][centerX + 1] && !visited[centerY - 1][centerX]) {
                visited[centerY][centerX] = true;
                visited[centerY][centerX + 1] = true;
                visited[centerY - 1][centerX] = true;

                tempAnswer += price[centerY][centerX] * 2 + price[centerY][centerX + 1] + price[centerY - 1][centerX];
                backTracking(centerY, centerX + 1);
                tempAnswer -= price[centerY][centerX] * 2 + price[centerY][centerX + 1] + price[centerY - 1][centerX];

                visited[centerY][centerX] = false;
                visited[centerY][centerX + 1] = false;
                visited[centerY - 1][centerX] = false;
            }
        }

        //네번째 ㄱ 반대 모양

        if (centerY + 1 <N && centerX + 1 < M) {
            if (!visited[centerY][centerX] && !visited[centerY][centerX + 1] && !visited[centerY + 1][centerX]) {
                visited[centerY][centerX] = true;
                visited[centerY][centerX + 1] = true;
                visited[centerY + 1][centerX] = true;

                tempAnswer += price[centerY][centerX] * 2 + price[centerY][centerX + 1] + price[centerY + 1][centerX];
                backTracking(centerY, centerX + 1);
                tempAnswer -= price[centerY][centerX] * 2 + price[centerY][centerX + 1] + price[centerY + 1][centerX];

                visited[centerY][centerX] = false;
                visited[centerY][centerX + 1] = false;
                visited[centerY + 1][centerX] = false;
            }
        }

    }
}
