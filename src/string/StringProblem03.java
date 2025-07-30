package string;

public class StringProblem03 {

    public void solution(){

        String s = "try hello world";
        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (int i =0;i<s.length();i++){
            char c = s.charAt(i);

            if(c ==' '){
                sb.append(' ');
                index =0;
                continue;
            }

            if(index%2==0){
                 sb.append(Character.toUpperCase(c));
            } else if (index%2==1) {
                 sb.append(Character.toLowerCase(c));
            }

            index++;

        }
        String answer = sb.toString();


    }
}
