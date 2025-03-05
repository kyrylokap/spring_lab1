import Repositories.VehicleRepositoryImpl;
import Vehicles.Car;
import Vehicles.Motorcycle;
import Vehicles.Vehicle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main{
    public static void main(String[] args) throws RuntimeException, IOException, CloneNotSupportedException {

        //Car car = new Car(1,"BMW","E60","2006","6000",false);
        //Motorcycle motorcycle = new Motorcycle(1,"BMW","E60","2006","6000",false,"B");
        //System.out.println(motorcycle.toString());

        VehicleRepositoryImpl vehicleRepositoryImpl = new VehicleRepositoryImpl();

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1.Rent vehicle");
            System.out.println("2.Return vehicle");
            System.out.println("3.Show vehicles");
            int choose = scanner.nextInt();
            if(choose == 1){
                System.out.println("Enter index: ");
                int index = scanner.nextInt();
                vehicleRepositoryImpl.rentVehicle(index);
            }if(choose == 2){
                vehicleRepositoryImpl.returnVehicle();
            }if(choose == 3){
                AtomicInteger ai = new AtomicInteger(1);
                vehicleRepositoryImpl.getVehicles().forEach(vehicle -> {
                    System.out.println(ai.getAndIncrement() + " " +vehicle.toString());
                });
            }
            vehicleRepositoryImpl.save();
        }

    }
}