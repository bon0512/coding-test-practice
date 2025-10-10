package baekjoon.bfs;

import java.util.*;

public class BaekJoon_1897 {


    static Set<String> dic = new HashSet<>();
    static int d;
    static String word;
    static int len;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        d = sc.nextInt();
        sc.nextLine();
        word = sc.nextLine();

        for (int i = 0; i < d; i++) {

            dic.add(sc.nextLine());
        }

        System.out.println(dic);

        String answer = bfs();
        System.out.println(answer);
    }

    private static String bfs(){
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(word);
        visited.add(word);

        String lastWord=word;

        while(!queue.isEmpty()){
            String poll = queue.poll();
            lastWord = poll;

            for(char c ='a'; c <='z'; c++){
                for (int i = 0; i <= poll.length(); i++) {
                    StringBuilder sb = new StringBuilder(poll);
                    sb.insert(i,c);
                    String insert = sb.toString();

                    if(dic.contains(insert) && !visited.contains(insert)){
                        queue.add(insert);
                        visited.add(insert);
                        //System.out.println(insert);
                    }
                }
            }
        }

        return lastWord;
    }
}
