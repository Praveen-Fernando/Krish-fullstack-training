package com.praveen.training.factorypattern;

public class PlanFactory {

    public Plan getPlan(String planType){
        if(planType == null){
            return null;
        }
        if(planType == "1") {
            return new DomesticPlan();
        }
        else if(planType == "2"){
            return new CommercialPlan();
        }
        else if(planType == "3") {
            return new InstitutionalPlan();
        }
        return null;
    }
}
