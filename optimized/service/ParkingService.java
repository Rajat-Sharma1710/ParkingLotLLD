package problems.parkingLot.optimized.service;

import problems.parkingLot.optimized.model.Slot;
import problems.parkingLot.optimized.model.Ticket;
import problems.parkingLot.optimized.model.Vehicle;
import problems.parkingLot.optimized.strategy.SlotAllocationStrategy;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

// You have to think how would you return Slot by slotNumber..
public class ParkingService implements ParkingLot{

    List<Slot> slots;
    Map<String, List<Integer>> colorToSlotsMap;

    Map<String, Integer> regToSlotMap;

    private final SlotAllocationStrategy slotAllocationStrategy;

    public ParkingService(SlotAllocationStrategy slotAllocationStrategy, int capacity) {
        slots = new ArrayList<>();
        for(int i = 1; i <= capacity; i++) {
            slots.add(new Slot(i));
        }
        colorToSlotsMap = new HashMap<>();
        regToSlotMap = new HashMap<>();
        this.slotAllocationStrategy = slotAllocationStrategy;
    }

    @Override
    public Ticket parkVehicle(Vehicle vehicle) {
        int slotNo = slotAllocationStrategy.getNearestAvailableSlot();
        if(slotNo == -1) {
            System.out.println("Parking space is full as of now!");
            return null;
        }

        if(colorToSlotsMap.containsKey(vehicle.getColor())) {
            List<Integer> list = colorToSlotsMap.get(vehicle.getColor());
            list.add(slotNo);
        }

        if(!regToSlotMap.containsKey(vehicle.getRegNo())) {
            regToSlotMap.put(vehicle.getRegNo(), slotNo);
        }
        Slot slot = slots.get(slotNo - 1);
        slot.assignVehicle(vehicle);
        String ticketNo = "Ticket->" + System.currentTimeMillis();
        return new Ticket(ticketNo, vehicle, slotNo);
    }

    @Override
    public void unParkVehicle(Vehicle vehicle) {
        String regNo = vehicle.getRegNo();
        if(regToSlotMap.containsKey(regNo)) {
            int slotNo = regToSlotMap.get(regNo);
            Slot slot = slots.get(slotNo - 1);
            slot.unassignVehicle();

            if(colorToSlotsMap.containsKey(vehicle.getColor())) {
                List<Integer> list = colorToSlotsMap.get(vehicle.getColor());
                // should remove slotNo by value by Index....
                list.remove(Integer.valueOf(slotNo));
            }

            regToSlotMap.remove(regNo);
        } else {
            System.out.println("Vehicle is not there in the parking!");
        }
    }

    @Override
    public Slot getSlotByRegNo(String reg_no) {
        int slotNo = regToSlotMap.get(reg_no);
        return slots.get(slotNo - 1);
    }

    @Override
    public List<Integer> getSlotsByColor(String color) {
        if(!colorToSlotsMap.containsKey(color)) {
            System.out.println(color + " color vehicle is not present in the parking.");
            return null;
        } else {
            return colorToSlotsMap.get(color);
        }
    }

    public Vehicle getVehicleBySlot(int slotNumber) {
        if (slotNumber < 1 || slotNumber > slots.size()) return null;
        return slots.get(slotNumber - 1).getVehicle();
    }

}
