package problems.parkingLot.optimized.model;

import java.time.LocalDateTime;

public class Ticket {
    private final String ticketNo;

    private final int slotNo;
    private final Vehicle vehicle;

    public Ticket(String ticketNo, Vehicle vehicle, int slotNo) {
        this.ticketNo = ticketNo;
        this.vehicle = vehicle;
        this.slotNo = slotNo;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
