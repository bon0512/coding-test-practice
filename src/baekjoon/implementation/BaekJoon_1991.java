package baekjoon.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class BaekJoon_1991 {

    static class Node{

        String data;
        Node leftChild;
        Node rightChild;
        Node parent;

        public Node(String data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        @Override
        public boolean equals(Object object) {
            if (object == null || getClass() != object.getClass()) return false;
            Node node = (Node) object;
            return Objects.equals(data, node.data);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(data);
        }
    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        Map<String,Node> map = new HashMap<>();

        Node root =new Node("A");
        map.put("A",root);

        int N = sc.nextInt();
        sc.nextLine();
        Node parent = null;
        for (int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");
            String parentStr = input[0];
            String leftStr = input[1];
            String rightStr = input[2];



            if(!map.containsKey(parentStr)){
                map.put(parentStr, new Node(parentStr));
            }

            if(!leftStr.equals(".")){
                map.putIfAbsent(leftStr,new Node(leftStr));
                Node node = map.get(parentStr);
                node.leftChild = map.get(leftStr);
            }

            if(!rightStr.equals(".")){
                map.putIfAbsent(rightStr,new Node(rightStr));
                Node node = map.get(parentStr);
                node.rightChild = map.get(rightStr);
            }

        }

        preOrder(map.get("A"));
        System.out.println();
        inOrder(map.get("A"));
        System.out.println();
        postOrder(map.get("A"));



    }

    private static void preOrder(Node node) {
        if(node == null){
            return;
        }
        System.out.print(node.data);
        preOrder(node.leftChild);

        preOrder(node.rightChild);

    }
    private static void inOrder(Node node) {
        if(node == null){
            return;
        }
        inOrder(node.leftChild);
        System.out.print(node.data);
        inOrder(node.rightChild);

    }
    private static void postOrder(Node node) {
        if(node == null){
            return;
        }
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.print(node.data);


    }
}
