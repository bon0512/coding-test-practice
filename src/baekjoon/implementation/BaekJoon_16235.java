package baekjoon.implementation;

import java.util.*;

public class BaekJoon_16235 {

    static int N, M, K;
    static int[][] A;
    static int[][] fee;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static Deque<Integer>[][] tree;
    static List<Integer>[][] tempTree;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        A = new int[N + 1][N + 1];
        fee = new int[N + 1][N + 1];
        tree = new ArrayDeque[N + 1][N + 1];
        tempTree = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                tree[i][j] = new ArrayDeque<>();
                tempTree[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                fee[i][j] = 5;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            int age = sc.nextInt();
            tempTree[y][x].add(age);
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                Collections.sort(tempTree[i][j]);

                for (int age : tempTree[i][j]) {
                    tree[i][j].add(age);
                }

            }

        }

        for (int i = 0; i < K; i++) {
            spring();
            fall();
            winter();
        }

        int count = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                count += tree[i][j].size();
            }
        }

        System.out.println(count);
    }

    private static void spring() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (tree[i][j].isEmpty()) continue;
                int dead = 0;
                int size = tree[i][j].size();
                for (int k = 0; k < size; k++) {
                    Integer treeAge = tree[i][j].poll();

                    if (fee[i][j] >= treeAge) {
                        fee[i][j] -= treeAge;
                        tree[i][j].add(treeAge + 1);
                    } else {
                        dead += (treeAge / 2);
                    }


                }
                fee[i][j] += dead;
            }
        }
    }


    private static void fall() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (tree[i][j].isEmpty()) continue;
                int size = tree[i][j].size();
                for (int k = 0; k < size; k++) {
                    Integer treeAge = tree[i][j].poll();

                    if (treeAge % 5 == 0) {
                        for (int l = 0; l < 8; l++) {
                            int ny = i + dy[l];
                            int nx = j + dx[l];

                            if (ny >= 1 && nx >= 1 && ny <= N && nx <= N) {
                                tree[ny][nx].addFirst(1);
                            }
                        }
                    }
                    tree[i][j].addLast(treeAge);
                }


            }
        }
    }

    private static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                fee[i][j] += A[i][j];
            }
        }
    }
}
