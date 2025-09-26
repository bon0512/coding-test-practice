package baekjoon.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_21610 {

    static int[][] grid;
    static boolean[][] isCloud;
    static int N, M;
    static int dir;
    static int street;

    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] numberFour = {2, 4, 6, 8};
    public static void main(String[] args) {

        System.out.println(-8 % 5);
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        grid = new int[N][N];

        isCloud = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 1; i++) {
            dir = sc.nextInt();
            street = sc.nextInt();
            int y1 = N - 1, x1 = 0;
            int y2 = N - 1, x2 = 1;
            int y3 = N - 2, x3 = 0;
            int y4 = N - 2, x4 = 1;
            int[] cols = new int[]{y1, y2, y3, y4};
            int[] rows = new int[]{x1, x2, x3, x4};


//            System.out.println("시작 좌표");
//            for (int j = 0; j < 4; j++) {
//                System.out.print("y : "+cols[j]+" ");
//                System.out.println("x : "+rows[j]);
//            };

            //1번
            for (int j = 0; j < cols.length; j++) {

                cols[j] = cols[j] + (dy[dir] * street);
                rows[j] = rows[j] + (dx[dir] * street);
            }

//            System.out.println("중간점검");
//
//            for (int j = 0; j < 4; j++) {
//                System.out.print("y : "+cols[j]+" ");
//                System.out.println("x : "+rows[j]);
//            }


            //2번
            for (int j = 0; j < cols.length; j++) {

                if (cols[j] < 0) {
                    cols[j] = N - Math.abs(cols[j] % 5);
                } else if (cols[j] >= N) {
                    cols[j] = cols[j] % N;
                }

                if (rows[j] < 0) {
                    rows[j] = N - Math.abs(rows[j] % 5);
                } else if (rows[j] >= N) {
                    rows[j] = rows[j] % N;
                }
            }



//            //System.out.println((i+1)+ "번째 실행 ");
            for (int j = 0; j < 4; j++) {
                System.out.print("y : "+cols[j]+" ");
                System.out.println("x : "+rows[j]);
            }


            //System.out.println("여기까지 완료");


//            for (int[] ints : grid) {
//                System.out.println(Arrays.toString(ints));
//            };



            // 구름 배열 설정

            for (int[] ints : grid) {
                System.out.println(Arrays.toString(ints));
            };

            System.out.println("좌표");

            for (int j = 0; j < 4; j++) {
                System.out.print("y : "+cols[j]+" ");
                System.out.println("x : "+rows[j]);
            }

            for (int j = 0; j < 4; j++) {
                isCloud[cols[j]][rows[j]]= true;
            }


            System.out.println("구름 상황");
            for (boolean[] booleans : isCloud) {
                System.out.println(Arrays.toString(booleans));
            };


            //2번 비가 내리는거임 이거 구름배열로 해야함
            for (int j = 0; j < cols.length; j++) {
                for (int k = 0; k < N; k++) {
                    if(isCloud[j][k]) grid[j][k]++;
                }
            }



            System.out.println();
            for (int[] ints : grid) {
                System.out.println(Arrays.toString(ints));
            };

            /*System.out.println("이동한 구름에서 처음으로 비내리기");
            for (int[] ints : grid) {
                System.out.println(Arrays.toString(ints));
            };*/

            System.out.println();





            for (int j = 0; j < 4; j++) {
                int tempY = cols[j];
                int tempX = rows[j];
                isCloud[tempY][tempX] = true;
            }

//            System.out.println("구름 상황");
//            for (boolean[] booleans : isCloud) {
//                System.out.println(Arrays.toString(booleans));
//            };

            //System.out.println();


            for (int j = 0; j < 4; j++) {

                int curY = cols[j];
                int curX = rows[j];

                //System.out.println("현재 진행 상황 :  좌표 Y : " +curY + " X : "+curX  + " "+grid[curY][curX]);

                for (int k = 2; k <= 8; k+=2) {

                    int ny = curY + dy[k];
                    int nx = curX + dx[k];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        //System.out.println("통과된 좌표 들 " +ny +" "+ nx +"현재값  "+grid[curY][curX] +" 좌표값 : "+grid[ny][nx]);
                        if(grid[ny][nx]>0) grid[curY][curX]++;
                    }

                }


                /*for (int[] ints : grid) {
                    System.out.println(Arrays.toString(ints));
                };*/

                System.out.println();


            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(grid[j][k]>=2){

                        if(isCloud[j][k]) continue;
                        else{
                            grid[j][k]-=2;
                        }
                    }
                }
            }

            for (int j = 0; j < 4; j++) {
                int tempY = cols[i];
                int tempX = rows[i];
                isCloud[tempY][tempX] = false;
            }

        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer+=grid[i][j];
            }
        }

        for (int[] ints : grid) {
            System.out.println(Arrays.toString(ints));
        };
        System.out.println(answer);

    }
}
