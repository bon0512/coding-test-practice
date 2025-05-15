package lambda;

public class ButtonExample {

    public static void main(String[] args) {

        Button buttonOk = new Button();

        buttonOk.setClickListener(()->{
            System.out.println("Ok 버튼을 클릭하였습니다.");
        });

        buttonOk.click();

        Button btnCancel = new Button();
        btnCancel.setClickListener(()->{
            System.out.println("Cancel 버튼을 클릭했습니다.");
        });

        btnCancel.click();


    }
}
