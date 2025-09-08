package baekjoon.implementation;

import java.util.Scanner;

public class BaekJoon_1018 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        char[][] arr = new char[row][col];

        for (int i = 0; i < row; i++) {
            String line = sc.nextLine().trim();
            for (int j = 0; j < col; j++) {
                arr[i][j] = line.charAt(j);
            }
        }


        int min = Integer.MAX_VALUE;


        for (int i = 0; i <= row-8; i++) {
            for (int j = 0; j <= col-8; j++) {

                int count1 =0;
                int count2 =0;

                for (int k = i; k < i+8; k++) {
                    for (int l = j; l < j+8; l++) {

                        if((k+l)%2==0){
                            if(arr[k][l] != 'W') count1++;
                            if(arr[k][l] != 'B') count2++;
                        }else{
                            if(arr[k][l] != 'B')count1++;
                            if(arr[k][l] != 'W')count2++;
                        }


                    }
                }
                min = Math.min(min,Math.min(count1, count2));

            }
        }

        System.out.println(min);
    }
}
