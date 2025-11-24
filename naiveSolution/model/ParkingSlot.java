package problems.parkingLot.naiveSolution.model;

public class ParkingSlot {
    private int slotNo;

    private boolean slotOccupied;

    public ParkingSlot(int slotNo, boolean slotOccupied) {
        this.slotNo = slotNo;
        this.slotOccupied = slotOccupied;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public boolean isSlotOccupied() {
        return slotOccupied;
    }

    public void setSlotAvailable(boolean slotOccupied) {
        this.slotOccupied = slotOccupied;
    }
}
