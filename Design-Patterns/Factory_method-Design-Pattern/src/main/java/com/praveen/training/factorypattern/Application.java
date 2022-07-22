package com.praveen.training.factorypattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String args[]) throws IOException {
        PlanFactory planFactory = new PlanFactory();
        System.out.print("Bill Numbers: "
                +"\n"+"Enter 1 : for Domestic Plan"
                +"\n"+"Enter 2 : for Commercial Plan"
                +"\n"+"Enter 3 : for Institutional Plan"
                +"\n"+"Enter plan number of the bill: ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String planName=br.readLine();
        System.out.print("Enter the number of units for bill will be calculated: ");
        int units = Integer.parseInt(br.readLine());

        Plan p = planFactory.getPlan(planName);

        System.out.print("Bill amount for "+units+" units is: ");
        p.getRate();
        p.calculateBill(units);
    }

}

