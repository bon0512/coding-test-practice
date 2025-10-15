package baekjoon.graph;

import java.util.*;

public class BaekJoon_16947 {

    static int N;
    static List<Integer>[] graph;

    static boolean[] visited;
    static boolean[] cycle;
    static int[] dis;

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        cycle = new boolean[N+1];
        dis = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <N+1 ; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }


        for (int i = 1; i <N+1; i++) {
            Arrays.fill(visited,false);
            if(Loop(i,-1,i)) break;
        }

        //System.out.println(Arrays.toString(visited));

        bfs();

        for (int i = 1; i <N+1 ; i++) {
            System.out.print(dis[i]+" ");
        }


    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visitedBfs = new boolean[N+1];

        for (int i = 0; i < visited.length; i++) {
            if(visited[i]){
                queue.add(i);
                visitedBfs[i] =true;
                dis[i]= 0;
            }
        }

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next : graph[current]){
                if(!visitedBfs[next]){
                    queue.add(next);
                    visitedBfs[next] =true;
                    dis[next] = dis[current]+1;
                }
            }

        }


    }

    static private boolean Loop(int current,int parent,int start){
        visited[current] = true;

        for(Integer next : graph[current]){

            if(!visited[next]){
                if(Loop(next,current,start)){
                    return true;
                }
            }else if( visited[next] && next!=parent&& next == start ){

                return true;
            }

        }
        visited[current] = false;

        return false;

    }
}
