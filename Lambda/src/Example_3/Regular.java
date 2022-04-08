package Example_3;

class Desk implements Square{
    public int calculate(int w){
        return w * w;
    }
}

public class Regular {
    public static void main(String[] args){

        Desk desk = new Desk();
        int d = desk.calculate(10);
        System.out.println(d);
    }
}
