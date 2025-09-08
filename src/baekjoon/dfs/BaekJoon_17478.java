package baekjoon.dfs;

import java.util.Scanner;

public class BaekJoon_17478 {
    static String first ="\"재귀함수가 뭔가요?\"";
    static String second = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이 세상 모든 지식을 통달한 선인이 있었어.";
    static String third = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    static String fourth = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    static String fifth = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String last = "라고 답변하였지.";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxCount = sc.nextInt();

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recur(0,maxCount);

    }

    public static void recur(int count,int maxCount){
        if(count==maxCount){

            StringBuilder firstSb = new StringBuilder();
            for (int i = 0; i < count*4; i++) {
                firstSb.append("_");
            }
            firstSb.append(first);
            StringBuilder secondSb = new StringBuilder();
            for (int i = 0; i < count*4; i++) {
                secondSb.append("_");
            }
            secondSb.append(fifth);
            StringBuilder thirdSb = new StringBuilder();
            for (int i = 0; i < count * 4; i++) {
                thirdSb.append("_");
            }

            thirdSb.append(last);

            System.out.println(firstSb.toString());
            System.out.println(secondSb.toString());
            System.out.println(thirdSb.toString());
            return ;

        }

        StringBuilder firstSb = new StringBuilder();

        for (int i = 0; i < count*4; i++) {
            firstSb.append("_");
        }
        firstSb.append(first);

        StringBuilder secondSb = new StringBuilder();
        for (int i = 0; i < count*4; i++) {
            secondSb.append("_");
        }
        secondSb.append(second);

        StringBuilder thirdSb = new StringBuilder();
        for (int i = 0; i < count*4; i++) {
            thirdSb.append("_");
        }
        thirdSb.append(third);

        StringBuilder fourthSb = new StringBuilder();
        for (int i = 0; i < count*4; i++) {
            fourthSb.append("_");
        }
        fourthSb.append(fourth);

        System.out.println(firstSb.toString());
        System.out.println(secondSb.toString());
        System.out.println(thirdSb.toString());
        System.out.println(fourthSb.toString());


        recur(count+1,maxCount);

        StringBuilder lastSb = new StringBuilder();
        for (int i = 0; i < count * 4; i++) {
            lastSb.append("_");
        }
        lastSb.append(last);
        System.out.println(lastSb.toString());







    }
}
