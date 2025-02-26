import Repositories.VehicleRepository;
import Vehicles.Car;
import Vehicles.Motorcycle;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RuntimeException, IOException {
        //Car car = new Car(1,"BMW","E60","2006","6000",false);
        //Motorcycle motorcycle = new Motorcycle(1,"BMW","E60","2006","6000",false,"B");
        //System.out.println(motorcycle.toString());
        VehicleRepository vehicleRepository = new VehicleRepository();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1.Rent vehicle");
            System.out.println("2.Return vehicle");
            System.out.println("3.Show vehicles");
            int choose = scanner.nextInt();
            if(choose == 1){
                System.out.println("Enter index: ");
                int index = scanner.nextInt();
                vehicleRepository.rentVehicle(index);
            }if(choose == 2){
                vehicleRepository.returnVehicle();
            }if(choose == 3){
                vehicleRepository.getVehicles().forEach(vehicle -> {
                    System.out.println(vehicle.toString());
                });
            }
            vehicleRepository.save();
        }

    }
}