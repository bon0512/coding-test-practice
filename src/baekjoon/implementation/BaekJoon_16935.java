package baekjoon.implementation;


import java.util.Scanner;

/**
 * 16935 배열 돌리기 3
 */
public class BaekJoon_16935 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();
        int count = sc.nextInt();

        int[][] array = new int[row][col];
        int[] counts = new int[count];

        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                array[y][x] = sc.nextInt();
            }
        }
        for (int i = 0; i < counts.length; i++) {
            counts[i] = sc.nextInt();
        }


        for (int i = 0; i < counts.length; i++) {

            if (counts[i] == 1) {
                array = numberOne(array);
            } else if (counts[i] == 2) {
                array = numberTwo(array);

            } else if (counts[i] == 3) {
                array = numberThree(array);

            } else if (counts[i] == 4) {

                array = numberFour(array);
            } else if (counts[i] == 5) {

                array = numberFive(array);
            } else if (counts[i] == 6) {
                array = numberSix(array);
            }

        }

        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[0].length; x++) {
                System.out.print(array[y][x] + " ");
            }
            System.out.println();
        }



    }


    public static int[][] numberOne(int[][] array) {
        int[][] temp = new int[array.length][array[0].length];

        int tempRow = array.length;

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                temp[row][col] = array[tempRow - 1 - row][col];
            }
        }
        return temp;
    }

    public static int[][] numberTwo(int[][] array) {
        int[][] temp = new int[array.length][array[0].length];

        int tempCol = array[0].length;

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                temp[row][col] = array[row][tempCol - 1 - col];
            }
        }
        return temp;
    }

    public static int[][] numberThree(int[][] array) {


        int[][] temp = new int[array[0].length][array.length];

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {

                temp[col][array.length - row - 1] = array[row][col];
            }

        }

        return temp;
    }

    public static int[][] numberFour(int[][] array) {

        int[][] temp = new int[array[0].length][array.length];

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {

                temp[array[0].length - col - 1][row] = array[row][col];

            }

        }

        return temp;
    }

    public static int[][] numberFive(int[][] array) {
        int[][] temp = new int[array.length][array[0].length];

        int halfRow = array.length / 2;
        int halfCol = array[0].length / 2;
        int row = array.length;
        int col = array[0].length;


        for (int y = halfRow; y < row; y++) {
            for (int x = 0; x < halfCol; x++) {
                temp[y-halfRow][x] = array[y][x];
            }
        }
        for (int y = 0; y < halfRow; y++) {
            for (int x = 0; x < halfCol; x++) {
                temp[y][x + halfCol] = array[y][x];
            }
        }

        for (int y = 0; y < halfRow; y++) {
            for (int x = halfCol; x < col; x++) {
                temp[y + halfRow][x] = array[y][x];
            }
        }

        for (int y = halfRow; y < row; y++) {
            for (int x = halfCol; x < col; x++) {
                temp[y][x - halfCol] = array[y][x];
            }
        }
        return temp;
    }

    public static int[][] numberSix(int[][] array) {
        int[][] temp = new int[array.length][array[0].length];

        int halfRow = array.length / 2;
        int halfCol = array[0].length / 2;
        int row = array.length;
        int col = array[0].length;

        for (int y = 0; y < halfRow; y++) {
            for (int x = 0; x < halfCol; x++) {

                temp[halfRow + y][x] = array[y][x];
            }

        }
        for (int y = halfRow; y < row; y++) {
            for (int x = 0; x < halfCol; x++) {
                temp[y][halfCol+x] = array[y][x];
            }
        }

        for (int y = halfRow; y < row; y++) {
            for (int x = halfCol; x < col; x++) {
                temp[y-halfRow][x] = array[y][x];

            }
        }

        for(int y = 0;y<halfRow;y++){
            for (int x = halfCol; x < col; x++) {
                temp[y][x-halfCol] = array[y][x];

            }
        }

        return temp;
    }
}
