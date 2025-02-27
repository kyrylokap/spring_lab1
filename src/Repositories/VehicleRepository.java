package Repositories;

import Vehicles.Car;
import Vehicles.Motorcycle;
import Vehicles.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepository implements IVehicleRepository{
    String path = "lab.csv";
    List<Vehicle>vehicles;
    public VehicleRepository(){
        vehicles = new ArrayList<>();
        try {
            load();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void load() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while (( line = br.readLine()) !=  null){
            String[] v = line.split(";");
            if(v[0].equals("0")){
                vehicles.add(new Car(Integer.parseInt(v[0]),v[1],v[2],v[3],v[4],Boolean.parseBoolean(v[5])));
            }else vehicles.add(new Motorcycle(Integer.parseInt(v[0]),v[1],v[2],v[3],v[4],Boolean.parseBoolean(v[5]),v[6]));
        }
        System.out.println("Finished adding to list!");
    }
    @Override
    public void rentVehicle(int index){
        boolean canRent = true;
        for(Vehicle vehicle:vehicles){
            if(vehicle.isRented()){
                canRent = false;
                System.out.println("You have rented car!");
                break;
            }
        }
        if(canRent && index >= 0){
            vehicles.get(index - 1).setRented(true);
            System.out.println(vehicles.get(index - 1).toString() + " rented");
        }
    }

    @Override
    public void returnVehicle(){
        vehicles.forEach(vehicle -> {
            if(vehicle.isRented()){
                vehicle.setRented(false);
                System.out.println("Vehicle :" + vehicle.toCsv() + " returned");
            }
        });
    }

    @Override
    public List<Vehicle> getVehicles(){
        return vehicles;
    }

    @Override
    public void save() throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
        vehicles.forEach(vehicle -> {
            try {
                bufferedWriter.write(vehicle.toCsv());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bufferedWriter.close();
    }
}
