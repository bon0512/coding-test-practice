package programmers.dp;

import java.util.Arrays;

/**
 *
 * dp
 *
 */
public class 등굣길 {
    class Solution {
        int[][] mem = new int[101][101];
        public int solution(int m, int n, int[][] puddles) {
            int answer = 0;

            int[][] arr = new int[n][m];

            for(int[] temp : mem){
                Arrays.fill(temp,-1);
            }

            for(int[] temp : puddles){
                arr[temp[1]-1][temp[0]-1] = -1;
            }

            answer = recur(0,0,arr);

            return answer ;

        }


        public int recur(int x, int y, int[][] arr){
            if(x>=arr[0].length || y>=arr.length) return 0;
            if(arr[y][x] == -1) return 0;

            if(mem[y][x]!=-1) return mem[y][x] ;

            if(x==arr[0].length-1 && y == arr.length-1) return 1;

            int total  = (recur(x+1,y,arr) +recur(x,y+1,arr)) % 1000000007;
            return mem[y][x] = total ;
        }

    }
}
