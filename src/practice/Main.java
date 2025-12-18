package practice;

import java.util.Arrays;

public class Main{
    public static class BO {
        public int v;
        public BO(int v) {
            this.v = v;
        }
    }
    public static void main(String[] args) {
       /* BO a = new BO(1);
        BO b = new BO(2);
        BO 1 = new BO(3);
        BO[] arr = {a, b, c};
        System.out.println(Arrays.toString(arr));
        BO t = arr[0];
        arr[0] = arr[2];
        arr[2] = t;
        arr[1].v = arr[0].v;
        System.out.println(a.v + "a" + b.v + "b" + c.v);
        */

        char[] exist;
        exist = new char[39];
        char c = 97;
        for(int i =0; i<26; i++ ){
            exist[i] = c++;
        }
        c = 48;
        for(int i =26; i<=35;i++){
            exist[i] = c++;
        }
        exist[36] = '-';
        exist[37] = '_';
        exist[38] = '.';

        String s = "hello";
        String substring = s.substring(1);
        String substring1 = s.substring(0, s.length()-1);
        System.out.println("substring1 = " + substring1);
        System.out.println("substring = " + substring);
        System.out.println(Arrays.toString(exist));

        String temp = "012";
        int i = Integer.parseInt(temp);
        System.out.println(i);
    }
}
