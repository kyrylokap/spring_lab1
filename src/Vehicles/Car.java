package Vehicles;

public class Car extends Vehicle{

    public Car(int id,String brand,String model,String year,String price, boolean rented) {
        this.rented = rented;
        this.year = year;
        this.model = model;
        this.price = price;
        this.id = id;
        this.brand = brand;
    }

    @Override
    public String toString()  {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", price='" + price + '\'' +
                ", rented=" + rented +
                '}';
    }

    @Override
    public String toCsv(){
        return id + ";" + brand + ";" + model + ";" + year + ";" + price + ";" + rented +"\n";
    }
}
