package baekjoon.graph;

import java.util.*;

public class BaekJoon_13023 {

    static List<Integer>[] list ;
    static int N,M;
    static boolean[] visited;
    public static void main(String[] args) {


        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        list = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            if(dfs(i,0)){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);

        /*int i = 0;
        for (List<Integer> integers : list) {
            System.out.println(i+": "+ integers);
            i++;
        };*/

    }

    private static boolean dfs(int start,int depth) {
        if(depth==4) return true;

        visited[start] = true;

        for(Integer friends : list[start]){
            if(!visited[friends]){
                visited[friends] = true;
                if(dfs(friends,depth+1)) return true;
            }
        }

        visited[start] = false;

        return false;
    }
}
