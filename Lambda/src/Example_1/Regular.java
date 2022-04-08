package Example_1;

class car implements Vehical{
    @Override
    public String getVehicalBrand(String brand) {
        return brand;
    }
}
public class Regular {
    public static void main(String[] args){

        car car = new car();
        car.getVehicalBrand("BMW");


    }
}
