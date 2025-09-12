package baekjoon.implementation;

import java.util.*;

public class BaekJoon_16637 {

    static int N;
    static List<Integer> nums = new ArrayList<>();
    static List<Character> ops = new ArrayList<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                nums.add(c - '0');
            } else {
                ops.add(c);
            }
        }


        dfs(0, nums.get(0));
        System.out.println(max);


    }

    // index: 연산자 인덱스, current: 현재 계산된 값
    public static void dfs(int index, int current) {
        if (index == ops.size()) {
            max = Math.max(max, current);
            return;
        }

        // 1. 괄호 안 치고 다음 연산자부터 계산
        int res = calc(current, nums.get(index + 1), ops.get(index));
        dfs(index + 1, res);

        // 2. 괄호 치는 경우 (현재 연산자와 다음 연산자 묶음)
        if (index + 1 < ops.size()) {
            int temp = calc(nums.get(index + 1), nums.get(index + 2), ops.get(index + 1));
            int res2 = calc(current, temp, ops.get(index));
            dfs(index + 2, res2);
        }
    }

    private static int calc(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default: throw new IllegalArgumentException("Invalid op: " + op);
        }
    }


}
