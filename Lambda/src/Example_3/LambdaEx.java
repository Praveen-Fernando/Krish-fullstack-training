package Example_3;

public class LambdaEx {
    public static void main(String[] args){

        Square s = w -> w * w;
        System.out.println(s.calculate(10));
    }
}
