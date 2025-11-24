package problems.parkingLot.naiveSolution;

import problems.parkingLot.naiveSolution.model.Car;
import problems.parkingLot.naiveSolution.service.ParkingService;

import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // take input and generate output.....
        System.out.println("Create parking lot problem");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total parking space..");
        int n = sc.nextInt();

        System.out.println("Enter the commands");
        ParkingService ps = new ParkingService(n);
        ps.setup();

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
                    Car c = new Car(color, regNo);
                    ps.parkCar(c);

                }
                case "leave" -> {
                    int slot = Integer.parseInt(arr[1]);
                    Car c = ps.findCarBySlot(slot);
                    ps.unParkCar(c);

                }
                case "status" -> {
                }
                case "slots" -> {
                    String color = arr[2];
                    List<Integer> list = ps.findSlotsOfAllCarsByColor(color);
                    System.out.println(list);

                }
                case "slot" -> {
                    String reg_no = arr[2];
                    int slot = ps.findSlotByRegNo(reg_no);
                    System.out.println(slot);

                }
                case "car" -> {
                    int slot = Integer.parseInt(arr[2]);
                    Car c = ps.findCarBySlot(slot);
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
