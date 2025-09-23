package baekjoon.implementation;

import java.util.Scanner;

public class BaekJoon_2875 {

    static int N,M,C;
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        C = sc.nextInt();
        int team;

        team = Math.min(N/2,M);
        if(team ==0){
            System.out.println(0);
            return ;
        }

        int remaining = (N+M) - (team*2 + team);
        if( remaining>= C){
            System.out.println(team);
        }else{
            while(remaining<C){
                team --;
                remaining+=3;
            }
            System.out.println(team);
        }

    }
}
