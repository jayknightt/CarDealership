package com.Pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private final List<Vehicle> vehicles;

    public Dealership() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicles);
    }

    public List<Vehicle> findByPriceRange(double minPrice, double maxPrice) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> findByMakeModelYearColorMileage(String make, String model, int year, String color, int minMileage, int maxMileage) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMake().equalsIgnoreCase(make) &&
                    vehicle.getModel().equalsIgnoreCase(model) &&
                    vehicle.getYear() == year &&
                    vehicle.getColor().equalsIgnoreCase(color) &&
                    vehicle.getMileage() >= minMileage &&
                    vehicle.getMileage() <= maxMileage) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> findByType(String type) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equalsIgnoreCase(type)) {
                result.add(vehicle);
            }
        }
        return result;
    }
}
