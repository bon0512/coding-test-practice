package baekjoon.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 * 단지 번호 붙이기
 */
public class BaekJoon_2667 {

    public static int N;
    public static int[][] map ;
    public static boolean[][] visited;
    public static int count ;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {

                map[i][j] = s.charAt(j) - '0';
            }
        }

        List<Integer> array = new ArrayList<>();

        for (int i = 0; i <N ; i++) {
            for (int j = 0; j < N; j++) {

                if(map[i][j]==1  && !visited[i][j]){
                    count = 0;
                    dfs(i,j);
                    array.add(count);
                }

            }
        }

        System.out.println(array.size());
        Collections.sort(array);
        for(Integer i : array){
            System.out.println(i);
        }
    }

    public static void dfs(int y , int x ){
        if(!visited[y][x]) {
            visited[y][x] = true;
            count++;
        }

        int[] dx = {0,0,-1,1};  // 상하 좌우
        int[] dy = {1,-1,0,0};


        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if( map[ny][nx] ==1 && !visited[ny][nx] ){
                    dfs(ny,nx);
                }
            }
        }


    }

}
