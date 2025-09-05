package practice.string;

public class StringProblem02 {
    public static void main(String[] args) {
        StringBuilder temp = new StringBuilder();

        String s ="";
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                c = (char) ((c - 'a' + n) % 26 + 'a');
            } else if (c >= 'A' && c <= 'Z') {
                c = (char) ((c - 'A' + n) % 26 + 'A');
            }

            temp.append(c);
        }

        //return temp.toString();
    }
}
