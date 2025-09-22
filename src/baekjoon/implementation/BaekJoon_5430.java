package baekjoon.implementation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BaekJoon_5430 {

    static int T;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {

            String op = sc.nextLine();
            int num = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();

            boolean error = false;
            boolean reversed = false;

            Deque<Integer> deque = new ArrayDeque<>();

            if (num > 0) {
                s = s.replace("[", "").replace("]", "");
                String[] split = s.split(",");
                for (String value : split) {
                    deque.add(Integer.parseInt(value));
                }
            }

            for (int j = 0; j < op.length(); j++) {
                char c = op.charAt(j);

                if (c == 'R') {
                    reversed = !reversed;
                } else if (c == 'D') {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (!reversed) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if (error) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if (!deque.isEmpty()) {
                    if (!reversed) {
                        while (deque.size() > 1) {
                            sb.append(deque.pollFirst()).append(",");
                        }
                        sb.append(deque.pollFirst());
                    } else {
                        while (deque.size() > 1) {
                            sb.append(deque.pollLast()).append(",");
                        }
                        sb.append(deque.pollLast());
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }

    }
}
