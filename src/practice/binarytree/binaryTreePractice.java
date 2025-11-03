package practice.binarytree;

import java.util.Arrays;

public class binaryTreePractice {

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5, 6, 7};

        String[] result = new String[3];

        result[0] = preOrder(nodes, 0);
        result[1] = inOrder(nodes, 0);
        result[2] = postOrder(nodes, 0);

        System.out.println(Arrays.toString(result));

    }

    private static String preOrder(int[] nodes, int index) {
        if (index >= nodes.length) {
            return "";
        }

        return nodes[index] + " " + preOrder(nodes, index * 2 + 1) + preOrder(nodes, index * 2 + 2);

    }

    private static String inOrder(int[] nodes, int index) {

        if (index >= nodes.length) {
            return "";
        }

        return inOrder(nodes, index * 2 + 1) + nodes[index] + " " +
                inOrder(nodes, index * 2 + 2);
    }

    private static String postOrder(int[] nodes, int index) {

        if (index >= nodes.length) {
            return "";
        }

        return postOrder(nodes, index * 2 + 1) + postOrder(nodes, index * 2 + 2) +
                nodes[index] + " ";

    }

}
