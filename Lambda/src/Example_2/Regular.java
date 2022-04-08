package Example_2;


public class Regular {
    public static void main(String[] args){

        int width = 10;

        Drawable draw = new Drawable() {
            @Override
            public void draw() {
                System.out.println("Width : " +width); }
        };
        draw.draw();
    }
}