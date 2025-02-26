package Vehicles;

public class Motorcycle extends Vehicle{

    String category;
    public Motorcycle(int id,String brand,String model,String year,String price, boolean rented,String category){
        this.rented = rented;
        this.year = year;
        this.model = model;
        this.price = price;
        this.id = id;
        this.brand = brand;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", price='" + price + '\'' +
                ", rented=" + rented +
                ",category=" + category +
                '}';
    }

    @Override
    public String toCsv() {
        return id + ";" + brand + ";" + model + ";" + year + ";" + price + ";" + rented + ";" +category + "\n";
    }
}
