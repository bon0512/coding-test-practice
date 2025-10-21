package practice;

interface F{
    int app(int n) throws Exception;
}
public class Main {
    public static  int run(F f){
        try{
            return f.app(3);
        } catch (Exception e){
            return 7;
        }
    }


    public static void main(String[] args) {
        F f = (x)->{
            if(x>2){
                throw new Exception();
            }else{
                return x*2;
            }
        };

        System.out.println(run(f) + run(n->n+9));
        
    }
}
