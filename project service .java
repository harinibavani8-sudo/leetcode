import java.util.*;

interface Serviceable {
    void serviceVehicle();
}

abstract class Vehicle implements Serviceable {
    protected String vehicleNo;
    protected String ownerName;
    protected String vehicleType;
    protected double serviceCost;
    protected String status;

    public Vehicle(String vehicleNo, String ownerName, String vehicleType, double serviceCost) {
        this.vehicleNo = vehicleNo;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.serviceCost = serviceCost;
        this.status = "Pending";
    }

    public abstract void displayDetails();

    public void completeService() {
        status = "Completed";
    }

    public String getStatus() {
        return status;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public double getServiceCost() {
        return serviceCost;
    }
}

class Car extends Vehicle {
    public Car(String vehicleNo, String ownerName, double serviceCost) {
        super(vehicleNo, ownerName, "Car", serviceCost);
    }

    @Override
    public void serviceVehicle() {
        System.out.println("Performing engine check, oil change and wheel alignment for Car " + vehicleNo);
        completeService();
    }

    @Override
    public void displayDetails() {
        System.out.println("Car -> No: " + vehicleNo + " | Owner: " + ownerName +
                " | Cost: Rs." + serviceCost + " | Status: " + status);
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNo, String ownerName, double serviceCost) {
        super(vehicleNo, ownerName, "Bike", serviceCost);
    }

    @Override
    public void serviceVehicle() {
        System.out.println("Performing chain lubrication and brake check for Bike " + vehicleNo);
        completeService();
    }

    @Override
    public void displayDetails() {
        System.out.println("Bike -> No: " + vehicleNo + " | Owner: " + ownerName +
                " | Cost: Rs." + serviceCost + " | Status: " + status);
    }
}

class Truck extends Vehicle {
    public Truck(String vehicleNo, String ownerName, double serviceCost) {
        super(vehicleNo, ownerName, "Truck", serviceCost);
    }

    @Override
    public void serviceVehicle() {
        System.out.println("Performing tyre rotation and load axle inspection for Truck " + vehicleNo);
        completeService();
    }

    @Override
    public void displayDetails() {
        System.out.println("Truck -> No: " + vehicleNo + " | Owner: " + ownerName +
                " | Cost: Rs." + serviceCost + " | Status: " + status);
    }
}

class ServiceCenter {
    private ArrayList<Vehicle> vehicleList = new ArrayList<>();

    public void registerVehicle(Vehicle v) {
        vehicleList.add(v);
        System.out.println("Vehicle " + v.getVehicleNo() + " registered successfully.\n");
    }

    public void serviceAllVehicles() {
        System.out.println("----- Servicing All Registered Vehicles -----");
        for (Vehicle v : vehicleList) {
            v.serviceVehicle();
        }
        System.out.println();
    }

    public void showAllVehicles() {
        System.out.println("----- Service Center Report -----");
        for (Vehicle v : vehicleList) {
            v.displayDetails();
        }
    }

    public double totalRevenue() {
        double total = 0;
        for (Vehicle v : vehicleList) {
            if (v.getStatus().equals("Completed")) {
                total += v.getServiceCost();
            }
        }
        return total;
    }
}

public class SmartVehicleService {
    public static void main(String[] args) {
        ServiceCenter center = new ServiceCenter();

        Vehicle car1 = new Car("TN01AB1234", "Arun", 1500.0);
        Vehicle bike1 = new Bike("TN02CD5678", "Priya", 400.0);
        Vehicle truck1 = new Truck("TN03EF9012", "Suresh", 3500.0);

        center.registerVehicle(car1);
        center.registerVehicle(bike1);
        center.registerVehicle(truck1);

        center.serviceAllVehicles();
        center.showAllVehicles();

        System.out.println("\nTotal Revenue Collected: Rs." + center.totalRevenue());
    }
}
   
