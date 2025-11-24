package problems.parkingLot.naiveSolution.model;

import problems.parkingLot.optimized.model.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    private final String ticketNo;

    private final int slotNo;
    private final Vehicle vehicle;
    private final LocalDateTime issuedDateTime;

    public Ticket(String ticketNo, Vehicle vehicle, int slotNo, LocalDateTime issuedDateTime) {
        this.ticketNo = ticketNo;
        this.vehicle = vehicle;
        this.slotNo = slotNo;
        this.issuedDateTime = LocalDateTime.now();
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

    public LocalDateTime getIssuedDateTime() {
        return issuedDateTime;
    }
}
