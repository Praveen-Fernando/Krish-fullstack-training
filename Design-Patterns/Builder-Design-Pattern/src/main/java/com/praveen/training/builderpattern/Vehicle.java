package com.praveen.training.builderpattern;

public class Vehicle {
    private final String insurance;
    private final boolean manual;
    private final String roadAssistance;
    private final String dropLocation;

    public Vehicle (Builder builder){
        this.insurance = builder.insurance;
        this.manual = builder.manual;
        this.roadAssistance = builder.roadAssistance;
        this.dropLocation = builder.dropLocation;
    }

    static class Builder{
        private String insurance;
        private boolean manual;
        private String roadAssistance;
        private String dropLocation;

        public Vehicle build(){
            return new Vehicle(this);
        }

        public Builder(String insurance){
            this.insurance = insurance;
        }

        public Builder manual(Boolean manual){
            this.manual = manual;
            return this;
        }

        public Builder roadAssistance(String roadAssistance){
            this.roadAssistance = roadAssistance;
            return this;
        }

        public Builder dropLocation(String dropLocation){
            this.dropLocation = dropLocation;
            return this;
        }

    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "insurance='" + insurance + '\'' +
                ", manual=" + manual +
                ", roadAssistance='" + roadAssistance + '\'' +
                ", dropLocation='" + dropLocation + '\'' +
                '}';
    }
}
