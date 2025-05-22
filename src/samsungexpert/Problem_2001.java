package samsungexpert;

import java.util.Scanner;

public class Problem_2001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =1;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N =6 , M=3;
            //N = sc.nextInt();
            //M = sc.nextInt();
            int[][] array = new int[N][N];
            int max = 0;
            int result = 0;

            for(int i = 0; i <N;i++){
                for(int j = 0; j<N;j++){
                    array[i][j] = sc.nextInt();
                }
            }
            //누적합 풀이방법
            int[][] prefix=  new int[N+1][N+1];

            for(int i = 1; i <N+1;i++){
                for(int j = 1; j<N+1;j++){
                    prefix[i][j] = array[i-1][j-1] +prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1];
                }
            }

            for(int i =1;i<N+1;i++){
                for(int j=1; j<N+1;j++){

                }
            }


            //for 문 4개 풀이방법
            /*for(int i =0; i <=N-M;i++){
                for(int j = 0 ; j<=N-M;j++){
                    int tmp = 0;
                    for(int x = 0;x<M;x++){
                        for(int y = 0; y<M; y++){
                            tmp+=array[i+x][j+y];
                        }
                    }
                    max = Math.max(max,tmp);
                }
            }*/

            System.out.println("#"+test_case+" "+max);

        }
    }
}
