package baekjoon.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BaekJoon_15685_re {


    static int N;
    static int x, y, d, g;
    static boolean[][] grid;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        grid = new boolean[101][101];

        int answer = 0;

        while (N-- > 0) {
            x = sc.nextInt();
            y = sc.nextInt();
            d = sc.nextInt();
            g = sc.nextInt();

            List<Integer> dir = new ArrayList<>();
            dir.add(d);


            for (int i = 0; i < g; i++) {
                for (int j = dir.size() - 1; j >= 0; j--) {
                    Integer temp = dir.get(j);
                    temp = (temp + 1) % 4;
                    dir.add(temp);
                }
            }




            int startX = x;
            int startY = y;

            grid[startY][startX] = true;

            for (Integer tempDir : dir) {
                int nx = startX + dx[tempDir];
                int ny = startY + dy[tempDir];

                if (nx >= 0 && nx < 101 && ny >= 0 && ny < 101) {
                    grid[ny][nx] = true;
                    startX = nx;
                    startY = ny;
                }

            }

        }
        for (int i = 0; i <100; i++) {
            for (int j = 0; j <100; j++) {
                if(grid[i][j]&&grid[i+1][j]&&grid[i][j+1]&&grid[i+1][j+1]){
                    answer++;
                }

            }

        }
//        for (boolean[] booleans : grid) {
//            System.out.println(Arrays.toString(booleans));
//        }

        System.out.println(answer);

    }
}
