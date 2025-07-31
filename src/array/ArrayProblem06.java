package array;

import java.util.Scanner;

public class ArrayProblem06 {
    static int topIndex = -1;
    static int[] stack = new int[7777];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            String cmd = parts[0];

            if (cmd.equals("push")) {
                int value = Integer.parseInt(parts[1]);
                push(value);
            } else if (cmd.equals("pop")) {
                System.out.println(pop());
            } else if (cmd.equals("size")) {
                System.out.println(size());
            } else if (cmd.equals("empty")) {
                System.out.println(empty());
            } else if (cmd.equals("top")) {
                System.out.println(top());
            }
        }
    }

    private static void push(int value) {
        stack[++topIndex] = value;
    }

    private static int pop() {
        if (topIndex == -1) return -1;
        return stack[topIndex--];
    }

    private static int size() {
        return topIndex + 1;
    }

    private static int empty() {
        if(topIndex == -1) return 1;
        return 0;
    }

    private static int top() {
        if(topIndex==-1){
            return -1;
        }
        return stack[topIndex];
    }
}
