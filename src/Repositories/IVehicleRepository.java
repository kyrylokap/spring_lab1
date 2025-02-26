package Repositories;

import Vehicles.Vehicle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IVehicleRepository {
    public void rentVehicle(int index) throws IOException;
    public void returnVehicle() throws IOException;
    public List<Vehicle> getVehicles();
    public void save() throws IOException;
    public void load() throws IOException;
}
