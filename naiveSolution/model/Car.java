package problems.parkingLot.naiveSolution.model;

public class Car {
    private final String color;

    private final String regNo;

    public Car(String color, String regNo) {
        this.color = color;
        this.regNo = regNo;
    }

    public String getColor() {
        return color;
    }

    public String getRegNo() {
        return regNo;
    }
}
