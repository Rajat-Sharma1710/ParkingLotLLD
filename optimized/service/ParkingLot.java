package problems.parkingLot.optimized.service;

import problems.parkingLot.naiveSolution.model.ParkingSlot;
import problems.parkingLot.optimized.model.Ticket;
import problems.parkingLot.optimized.model.Slot;
import problems.parkingLot.optimized.model.Vehicle;

import java.util.List;

public interface ParkingLot {
    Ticket parkVehicle(Vehicle vehicle);

    void unParkVehicle(Vehicle vehicle);

    List<Integer> getSlotsByColor(String color);

    Slot getSlotByRegNo(String reg_no);
}
