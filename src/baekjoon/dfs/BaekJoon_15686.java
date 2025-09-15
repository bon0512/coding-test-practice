package baekjoon.dfs;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon_15686 {

    static int[][] map ;
    static int N ;
    static  int M ;
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> home = new ArrayList<>();
    static int minDistance = Integer.MAX_VALUE;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] ==1){
                    home.add(new int[]{j,i});
                }
                if( map[i][j] == 2){
                    chicken.add(new int[]{j,i});
                }
            }
        }

        dfs(0,new ArrayList<>());
        System.out.println(minDistance);


    }

    public static void dfs(int start, List<int[]> list){
        if(list.size()==M){
            calculation(list);
            return;
        };

        for (int i = start; i < chicken.size(); i++) {
            list.add(chicken.get(i));
            dfs(i+1,list);
            list.remove(list.size()-1);
        }
    }

    private static void calculation(List<int[]> list) {

        int tempMin = 0;
        for (int[] h : home) {
            int min = Integer.MAX_VALUE;
            for (int[] l : list) {
                int dist = Math.abs(h[0] - l[0]) + Math.abs(h[1] - l[1]);
                min = Math.min(min,dist);
            }

            tempMin += min;
        }

        minDistance = Math.min(tempMin,minDistance);

    }
}
