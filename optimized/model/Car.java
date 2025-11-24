package problems.parkingLot.optimized.model;

public class Car implements Vehicle{
    private final String color;

    private final String regNo;

    private String ownerName;

    public Car(String color, String regNo) {
        this.color = color;
        this.regNo = regNo;
    }
    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getRegNo() {
        return regNo;
    }

    @Override
    public String getOwnerName() {
        return null;
    }
}
