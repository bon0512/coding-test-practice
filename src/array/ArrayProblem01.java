package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayProblem01 {

    public static void main(String[] args) {
        int[][] line = new int[][]{{0,1,-1},{1,0,-1},{1,0,1}};
        long maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        long minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;

        //모든 직선 쌍에 대해 반복
        // 교점 좌표 구하기
        // 정수 좌표만 저장
        List<long[]> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long x = (line[i][1] * line[j][2] - line[j][1] * line[i][2]) / (line[i][0] * line[j][1] - line[j][0] * line[i][1]);
                long y = (line[j][0] * line[i][2] - line[i][0] * line[j][2]) / (line[i][0] * line[j][1] - line[j][0] * line[i][1]);

                if (x % 1 != 0 && y % 1 != 0) {
                    points.add(new long[]{x,y});

                    maxX = Math.max(maxX,x);
                    maxY = Math.max(maxY,y);
                    minX = Math.min(minX,x);
                    minY = Math.min(minY,y);


                }
            }
        }

        int width = (int) (maxX -minX +1);
        int height = (int) (maxY - minY+1);

        char[][] arr = new char[height][width];
        for (char[] chars : arr) {
            Arrays.fill(chars,'.');
        }
        for (long[] point : points) {
            int row = (int)(maxY - point[1]);
            int col = (int)(point[0] - minX);
            arr[row][col]='*';
        }

        String[] result = new String[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            result[i] = new String(arr[i]);
        }


    }
}
