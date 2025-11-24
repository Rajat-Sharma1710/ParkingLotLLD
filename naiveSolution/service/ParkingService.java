package problems.parkingLot.naiveSolution.service;

import problems.parkingLot.naiveSolution.model.Car;
import problems.parkingLot.naiveSolution.model.ParkingSlot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Objects;
import java.util.ArrayList;

public class ParkingService {

    public int totalSlots;

    PriorityQueue<Integer> pq;

    Map<Car, ParkingSlot> map;

    public ParkingService(int totalSlots) {
        this.totalSlots = totalSlots;
        map = new HashMap<>();
        pq = new PriorityQueue<>();
    }

    public void setup() {
        for(int i = 1; i <= totalSlots; i++) pq.add(i);
    }

    public void parkCar(Car car) {
        if(pq.isEmpty()) {
            System.out.println("Sorry, parking lot is full!");
        } else {
            int availableSlot = pq.poll();
            ParkingSlot slot = new ParkingSlot(availableSlot, true);
            totalSlots--;
            map.put(car, slot);
        }
    }

    public void unParkCar(Car car) {
        if(!map.containsKey(car)) {
            System.out.println("The car is not there in parking !!");
        } else {
            ParkingSlot slot = map.get(car);
            slot.setSlotAvailable(false);

            map.remove(car);
            totalSlots++;
            pq.add(slot.getSlotNo());
        }
    }

    public Car findCarBySlot(int slotNo) {
        if(pq.contains(slotNo)) {
            System.out.println("The given slot is having no car parked !!");
        } else {
            for(Map.Entry<Car, ParkingSlot> entry: map.entrySet()) {
                if(entry.getValue().getSlotNo() == slotNo) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    public int findSlotByRegNo(String reg_no) {
        for(Map.Entry<Car, ParkingSlot> entry: map.entrySet()) {
            if(Objects.equals(entry.getKey().getRegNo(), reg_no)) {
                return entry.getValue().getSlotNo();
            }
        }
        return -1;
    }

    public List<String> findRegOfAllCarsByColor(String color) {
        List<String> res = new ArrayList<>();
        for(Car car: map.keySet()) {
            if(car.getColor().equalsIgnoreCase(color)) {
                res.add(car.getRegNo());
            }
        }
        return res;
    }

    public List<Integer> findSlotsOfAllCarsByColor(String color) {
        List<Integer> res = new ArrayList<>();

        for(Map.Entry<Car, ParkingSlot> entry: map.entrySet()) {
            if(Objects.equals(entry.getKey().getColor().toLowerCase(), color.toLowerCase())) {
                res.add(entry.getValue().getSlotNo());
            }
        }
        return res;
    }
}
