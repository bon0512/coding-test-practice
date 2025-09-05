package baekjoon.implementation;


import java.util.Scanner;

/**
 *  20055번 컨베이어 벨트 위의 로봇
 */
public class BaekJoon_20055 {
    static int[] belt;
    static boolean[] robot;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        belt = new int[n * 2];
        robot = new boolean[n];
        int round = 0;

        for (int i = 0; i < 2 * n; i++) {
            belt[i] = sc.nextInt();
        }

        while (true) {
            round++;

            // 1. 벨트 회전
            rotateBelt(n);

            // 2. 로봇 이동
            moveRobot(n);

            // 3. 로봇 올리기
            onRobot(n);

            // 4. 내구도 검사
            if (countZero() >= k) break;
        }

        System.out.println(round);
    }

    private static void rotateBelt(int n) {
        int temp = belt[2 * n - 1];
        for (int i = 2 * n - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = temp;

        for (int i = n - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        robot[n - 1] = false;
    }

    private static void moveRobot(int n) {
        for (int i = n - 2; i >= 0; i--) {
            if (!robot[i + 1] && robot[i] && belt[i + 1] > 0) {
                robot[i + 1] = true;
                robot[i] = false;
                belt[i + 1]--;
            }
        }
        robot[n - 1] = false;
    }

    private static void onRobot(int n) {
        if (!robot[0] && belt[0] > 0) {
            robot[0] = true;
            belt[0]--;
        }
    }

    private static int countZero() {
        int count = 0;
        for (int durability : belt) {
            if (durability == 0) count++;
        }
        return count;
    }
}
