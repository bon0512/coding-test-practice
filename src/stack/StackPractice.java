package stack;
import java.util.*;

public class StackPractice {

    public static void main(String[] args) {


        Stack<Integer> stack = new Stack<>(); //스택 객체 생성
        stack.push(1);
        stack.push(2);
        stack.push(3);

        //스택이 비어있는지 확인하기
        System.out.println(stack.isEmpty()); //false 반환
        System.out.println(stack.pop()); //3
        System.out.println(stack.pop()); //2
        System.out.println(stack.pop()); //1
        System.out.println(stack.isEmpty()); //true


        stack.clear();
        System.out.println(stack.isEmpty());

        stack.push(6);
        stack.push(5);

        System.out.println("스택 피크 연습");
        //스택에 가장 최근에 푸시한 값(peek);
        System.out.println(stack.peek()); //5 꺼내지 않고 반환만 하는 peek
        System.out.println(stack.size()); //2


        System.out.println(stack.pop()); //5

        System.out.println(stack.size()); //1

        stack.push(7);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size()); //0

    }
}
