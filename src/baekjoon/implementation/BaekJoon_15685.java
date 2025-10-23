package baekjoon.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BaekJoon_15685 {

    static int N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static List<Integer> dir;
    static boolean[][] grid = new boolean[101][101];
    static int answer =0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        while (N-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();

            dir = new ArrayList<>();

            dir.add(d);

            for (int i = 1; i <= g; i++) {
                for (int j = dir.size() - 1; j >= 0; j--) {
                    int temp = dir.get(j);
                    temp = (temp + 1) % 4;
                    dir.add(temp);
                }
            }

            int startX = x;
            int startY = y;

            grid[startY][startX] = true;

            for (int i = 0; i < dir.size(); i++) {
                int tempDir = dir.get(i);
                int ny = startY + dy[tempDir];
                int nx = startX + dx[tempDir];
                if(ny>=0 && nx>=0 && ny<101 & nx<101){
                    grid[ny][nx] =true;

                    startX = nx;
                    startY = ny;
                }

            }


        }

        for (int i = 0; i <100; i++) {
            for (int j = 0; j < 100; j++) {
                if(grid[i][j] && grid[i+1][j] && grid[i][j+1] && grid[i+1][j+1]){
                    answer++;
                }
            }
        }


        System.out.println(answer);

    }
}
