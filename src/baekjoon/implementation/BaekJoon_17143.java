package baekjoon.implementation;

import java.util.Scanner;

/**
 * 낚시왕
 * <a href="https://www.acmicpc.net/problem/17143">낙시왕</a>
 */
public class BaekJoon_17143 {

    static int R, C, M;
    static int human;
    static int[][] grid;
    static int[][] sharkInformation;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        M = sc.nextInt();

        grid = new int[R + 1][C + 1];

        //상어 0.r, 1.c, 2.s(속력), 3.d (이동방향), 4.z 크기 , 5. 생존여부
        sharkInformation = new int[M + 1][6];

        human = 0;

        for (int i = 1; i <= M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            int z = sc.nextInt();

            sharkInformation[i][0] = r;
            sharkInformation[i][1] = c;
            sharkInformation[i][2] = s;
            sharkInformation[i][3] = d;
            sharkInformation[i][4] = z;
            sharkInformation[i][5] = 1; // 생존

            grid[r][c] = i;
        }

        int score = 0;

        while (human < C) {

            //1. 사람 가로로 1칸 움직임
            human++;


            //2. 사람과 가까운 열에 위치한 상어를 잡는다.
            for (int i = 1; i <= R; i++) {

                if (grid[i][human] != 0) {

                    //상어 죽음 처리 및 낚시 점수 플러스
                    int sharkNumber = grid[i][human];
                    sharkInformation[sharkNumber][5] = 0;
                    int size = sharkInformation[sharkNumber][4];
                    grid[i][human] = 0;

                    score += size;

                    break;
                }
            }


            //3. 상어 이동
            for (int i = 1; i <= M; i++) {
                if (sharkInformation[i][5] == 0) continue;

                int sharkY = sharkInformation[i][0];
                int sharkX = sharkInformation[i][1];
                int dir = sharkInformation[i][3];
                int speed = sharkInformation[i][2];

                if (dir == 1 || dir == 2) {
                    speed %= (R - 1) * 2; //하나빼주면 처음부터 끝까지감 이거를 2번 곱하면 왕복 즉 왕복으로 나눠주면 이동거리가 나옴
                } else {
                    speed %= (C - 1) * 2;
                }

                for (int j = 1; j <= speed; j++) {

                    //상어 이동
                    //방향 1이거나 2일때
                    if (dir == 1 || dir == 2) {
                        //직진했을때 벽에 부딫히면 전진하지말고 후진 해주고 방향 전환해줘야한다.
                        if (dir == 1) {
                            if (sharkY == 1) {
                                dir = 2;
                                sharkY = 2;
                                continue;
                            }
                            sharkY--;
                        } else {
                            if (sharkY == R) {
                                dir = 1;
                                sharkY = R - 1;
                                continue;
                            }
                            sharkY++;
                        }
                    }
                    //방향이 3,4일때
                    else {
                        if (dir == 3) {
                            if (sharkX == C) {
                                dir = 4;
                                sharkX = C - 1;
                                continue;
                            }
                            sharkX++;
                        } else {
                            if (sharkX == 1) {
                                dir = 3;
                                sharkX = 2;
                                continue;
                            }
                            sharkX--;
                        }

                    }
                }
                sharkInformation[i][0] = sharkY;
                sharkInformation[i][1] = sharkX;
                sharkInformation[i][3] = dir;
            }

            grid = new int[R + 1][C + 1];

            //4. 상어 겹쳤을때 중복 제거
            for (int i = 1; i <= M; i++) {
                if (sharkInformation[i][5] == 0) continue;

                int y = sharkInformation[i][0];
                int x = sharkInformation[i][1];
                int size = sharkInformation[i][4];

                // 해당 칸에 상어가 없다면
                if (grid[y][x] == 0) {
                    grid[y][x] = i;
                }
                // 이미 상어가 있다면
                else {
                    int other = grid[y][x];
                    if (sharkInformation[other][4] < size) {
                        sharkInformation[other][5] = 0; // 기존 상어 죽음
                        grid[y][x] = i;
                    } else {
                        sharkInformation[i][5] = 0; // 현재 상어 죽음
                    }
                }
            }



        }
        System.out.println(score);
    }
}
