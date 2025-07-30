package string;

public class StringProblem01 {
    public static void main(String[] args) {
        long n = 12345;
        
        String sb = Long.toString(n);
        
        String reversed = new StringBuilder(sb).reverse().toString();
        char[] charArray = reversed.toCharArray();

        int [] result = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {

            result[i] = charArray[i] - '0';
        }

    }
}
