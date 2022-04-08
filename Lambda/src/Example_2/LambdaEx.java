package Example_2;

public class LambdaEx {
    public static void main(String[] args){

        int width = 10;

        Drawable draw = () -> System.out.println("Width : " +width);
        draw.draw();
    }
}