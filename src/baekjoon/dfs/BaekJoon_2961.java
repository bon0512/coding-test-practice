package baekjoon.dfs;

import java.util.Scanner;

public class BaekJoon_2961 {

    static int[][] taste;
    static int min = Integer.MAX_VALUE;
    static int N ;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        taste = new int[N][2];

        for (int i = 0; i < N; i++) {
            taste[i][0] = sc.nextInt();
            taste[i][1] = sc.nextInt();
        }

        dfs(0,1,0,0);

        System.out.println(min);
    }

    public static void dfs(int index, int sour, int bitter, int count){

        if(index==N){

            if(count>0){
                min = Math.min(min,Math.abs(sour-bitter));
            }

            return;
        }

        dfs(index+1,sour*taste[index][0],bitter+taste[index][1],count+1);
        dfs(index+1,sour,bitter,count);


    }
}
