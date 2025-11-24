package problems.parkingLot.optimized.model;

public class Slot {
    private final int slotNo;

    private Vehicle vehicle;

    public Slot(int slotNo, Vehicle vehicle) {
        this.slotNo = slotNo;
        this.vehicle = vehicle;
    }

    public Slot(int slotNo) {
        this.slotNo = slotNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isSlotOccupied() {
        return this.vehicle != null;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void unassignVehicle() {
        this.vehicle = null;
    }

}
