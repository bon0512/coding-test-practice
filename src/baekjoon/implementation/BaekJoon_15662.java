package baekjoon.implementation;

import java.util.Scanner;

public class BaekJoon_15662 {

    static String[] list;
    static int[] dirList;
    static int T, K, num, dir;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        list = new String[K];
        int count =0;

        sc.nextLine();

        for (int i = 0; i < K; i++) {
            list[i] = sc.nextLine();
        }
        T = sc.nextInt();

        while (T-- > 0) {
            dirList = new int[K];
            num = sc.nextInt() -1;
            dir = sc.nextInt();
            dirList[num] = dir;
            checkDir(num);
            rotate();
        }
        for (int i = 0; i < K; i++) {
            if(list[i].charAt(0)=='1') {
                count++;
            }
        }

        System.out.println(count);

//        //시계방향
//        String s = "01234567";
//        s = s.charAt(7) + s.substring(0, 7);
//        System.out.println(s);
//
//
//        //반시계방향
//        String a = "01234567";
//        a = a.substring(1, 8) + a.charAt(0);
//        System.out.println(a);


    }

    private static void rotate() {

        for (int i = 0; i < K; i++) {
            if(dirList[i]==-1){
                String temp = list[i];
                temp = temp.substring(1, 8) + temp.charAt(0);
                list[i] = temp;

            }else if(dirList[i]==1){
                String temp = list[i];
                temp = temp.charAt(7) + temp.substring(0,7);
                list[i] = temp;
            }
        }

    }

    private static void checkDir(int num) {

        //오른쪽 체크
        for (int i = num; i < K-1; i++) {
            if (dirList[i] != 0) {
                if (list[i].charAt(2) == list[i+1].charAt(6)) {
                    dirList[i+1] = 0;
                }else{
                    dirList[i+1] = dirList[i] * -1;
                }
            }else{
                dirList[i] = 0;
            }

        }

        for (int i = num; i >0 ; i--) {

            if (dirList[i] != 0) {
                if (list[i -1].charAt(2) == list[i].charAt(6)) {
                    dirList[i-1] = 0;
                }else{
                    dirList[i - 1] = dirList[i] * -1;
                }
            }else{
                dirList[i] = 0;
            }
        }
    }






}
