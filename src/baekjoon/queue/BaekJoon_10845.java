package baekjoon.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon_10845 {

    public static void main(String[] args) {


        Queue<Integer> queue = new LinkedList<>();

        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int last =0;
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();

            if(s.equals("pop")){
                if(queue.isEmpty()){ System.out.println(-1);}
                else{
                    System.out.println(queue.poll());
                }
            }else if(s.equals("size")){
                System.out.println(queue.size());
            }else if(s.equals("empty")){
                if (queue.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }else if(s.equals("front")){
                if(queue.isEmpty()) System.out.println(-1);
                else System.out.println(queue.peek());
            }else if(s.equals("back")){
                if(queue.isEmpty()) System.out.println(-1);
                else System.out.println(last);
            }else{
                String[] s1 = s.split(" ");
                int i1 = Integer.parseInt(s1[1]);
                queue.add(i1);
                last = i1;

            }



        }




    }
}
