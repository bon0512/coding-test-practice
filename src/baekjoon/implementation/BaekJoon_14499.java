package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 주사위 굴리기
 */
public class BaekJoon_14499 {

    // 동, 서, 북, 남 순서: 문제 요구대로 dx, dy 수정
    static int[] dx = {0, 0, 0, -1, 1}; // 행 이동
    static int[] dy = {0, 1, -1, 0, 0}; // 열 이동

    static int[][] map;
    static int[] dice = new int[7]; // 주사위 면: 1~6 사용
    static int N, M, x, y, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        x = Integer.parseInt(st.nextToken()); // 시작 행
        y = Integer.parseInt(st.nextToken()); // 시작 열
        k = Integer.parseInt(st.nextToken()); // 명령 수

        map = new int[N][M];

        // 지도 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령어 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int move = Integer.parseInt(st.nextToken());
            dir(move);
        }
    }

    public static void dir(int move) {
        int nx = x + dx[move];
        int ny = y + dy[move];

        // 범위 체크
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;

        x = nx;
        y = ny;

        roll(move);

        if (map[x][y] == 0) {
            map[x][y] = dice[6];
        } else {
            dice[6] = map[x][y];
            map[x][y] = 0;
        }

        System.out.println(dice[1]);
    }

    private static void roll(int move) {
        int[] temp = dice.clone();

        if (move == 1) { // 동쪽
            dice[1] = temp[4];
            dice[4] = temp[6];
            dice[6] = temp[3];
            dice[3] = temp[1];
        } else if (move == 2) { // 서쪽
            dice[1] = temp[3];
            dice[3] = temp[6];
            dice[6] = temp[4];
            dice[4] = temp[1];
        } else if (move == 3) { // 북쪽
            dice[1] = temp[5];
            dice[5] = temp[6];
            dice[6] = temp[2];
            dice[2] = temp[1];
        } else if (move == 4) { // 남쪽
            dice[1] = temp[2];
            dice[2] = temp[6];
            dice[6] = temp[5];
            dice[5] = temp[1];
        }
    }
}
