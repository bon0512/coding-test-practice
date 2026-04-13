package baekjoon.implementation;

import java.util.*;

public class BaekJoon_17822 {
    static int N, M, T;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();

        arr = new int[N + 1][M];
        visited = new boolean[N + 1][M];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < T; i++) {
            int xi = sc.nextInt();
            int di = sc.nextInt();
            int ki = sc.nextInt();

            rotate(xi, di, ki);
            //0으로 바뀐거 체크
            boolean compare = compare();

            //0으로 바뀐게 없다면 평균 구해서 숫자 조정
            if(!compare){
                plusMinus();
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                answer += arr[i][j];
            }
        }
        System.out.println(answer);

    }

    private static void plusMinus() {
        int sum = 0;
        int count = 0;
        for (int i = 1; i <=N ; i++) {
            for (int j = 0; j <M ; j++) {
                if(arr[i][j]!=0){
                    sum+=arr[i][j];
                    count++;
                }
            }

        }
        if(count==0) return;
        double avg = (double) sum / count;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) continue;

                if (arr[i][j] > avg) arr[i][j]--;
                else if (arr[i][j] < avg) arr[i][j]++;
            }
        }
    }

    private static void rotate(int xi, int di, int ki) {
        //xi 배수 원판 회전 시키기
        //di 0인 경우 시계방향 1인경우 반시계방향
        //kj 칸수 회전
        ki = ki % M;
        for (int i = xi; i <= N; i += xi) {
            List<Integer> list = new ArrayList<>();
            for (int num : arr[i]) {
                list.add(num);
            }

            if (di == 0) {
                Collections.rotate(list, ki);
            } else {
                Collections.rotate(list, -ki);
            }

            for (int j = 0; j < M; j++) {
                arr[i][j] = list.get(j);
            }

        }
    }

    private static boolean compare() {
        visited = new boolean[N+1][M];
        boolean isZero = false;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && arr[i][j] != 0) {
                    //bfs 에서 true 반환하면 0으로 바뀐게 있다고 true
                    if(bfs(i, j)) isZero = true;
                }
            }
        }
        
        return isZero;
    }

    private static boolean bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> zero = new ArrayList<>();

        int number = arr[y][x];
        visited[y][x] = true;
        queue.add(new int[]{y, x});
        zero.add(new int[]{y,x});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curY = poll[0];
            int curX = poll[1];

            for (int i = 0; i < 4; i++) {
                int nY = curY + dy[i];
                int nX = curX + dx[i];

                if (i == 0 || i == 2) {
                    nX = (nX + M) % M;
                }

                if (nY >= 1 && nY <= N && nX >= 0 && nX < M) {
                    if (!visited[nY][nX] && arr[nY][nX]==number) {
                        visited[nY][nX] = true;
                        queue.add(new int[]{nY,nX});
                        zero.add(new int[]{nY,nX});
                    }
                }
            }
        }

        //같은 숫자가 2개 이상 없으면 그냥 패스 하고 있으면 0으로 바꿔준뒤 true 반환

        if(zero.size()>=2){
            for (int[] ints : zero) {
                arr[ints[0]][ints[1]] = 0;
            }
            return true;
        }
        // 없으면 false 반환
        return false;
    }
}
