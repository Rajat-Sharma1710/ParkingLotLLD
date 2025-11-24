package problems.parkingLot.optimized;

import problems.parkingLot.optimized.model.Car;
import problems.parkingLot.optimized.model.Ticket;
import problems.parkingLot.optimized.model.Vehicle;
import problems.parkingLot.optimized.service.ParkingService;
import problems.parkingLot.optimized.strategy.NearestAllocationStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Create parking lot problem");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total parking space..");
        int capacity = sc.nextInt();

        System.out.println("Enter the commands");
        // Strategy decided at runtime....
        ParkingService ps = new ParkingService(new NearestAllocationStrategy(capacity), capacity);

        while(true) {
            String str = sc.nextLine().trim();

            if(str.equals("exit")) {
                break;
            }
            String[] arr = str.split(" ");

            switch (arr[0]) {
                case "park" -> {
                    String regNo = arr[1];
                    String color = arr[2];
                    Vehicle vehicle = new Car(color, regNo);
                    Ticket ticket = ps.parkVehicle(vehicle);
                    if(ticket != null) {
                        System.out.println("Parked at slot: " + ticket.getSlotNo());
                        System.out.println("Ticket id: " + ticket.getTicketNo());
                    } else {
                        System.out.println("Parking space is full");
                    }
                }
                case "leave" -> {
                    int slotNo = Integer.parseInt(arr[1]);
                    Vehicle vehicle = ps.getVehicleBySlot(slotNo);
                    ps.unParkVehicle(vehicle);
                }
                case "status" -> {
                }
                case "slots" -> {
                    String color = arr[2];
                    List<Integer> list = ps.getSlotsByColor(color);
                    System.out.println(list);

                }
                case "slot" -> {
                    String reg_no = arr[2];
                    int slotNo = ps.getSlotByRegNo(reg_no).getSlotNo();
                    System.out.println(slotNo);

                }
                case "car" -> {
                    int slot = Integer.parseInt(arr[2]);
                    Vehicle c = ps.getVehicleBySlot(slot);
                    if(c != null) {
                        System.out.println(
                                "Here is the car with reg_no " + c.getRegNo() + " and color " + c.getColor());
                    }
                }
                default -> System.out.println("Please type some valid command !!");
            }
        }
    }
}
