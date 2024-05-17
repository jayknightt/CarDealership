package com.Pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static Dealership dealership = new Dealership();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            char choice = scanner.next().charAt(0);
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 'A':
                    viewAllVehicles();
                    break;
                case 'P':
                    searchByPriceRange(scanner);
                    break;
                case 'M':
                    searchByMakeModelYearColorMileage(scanner);
                    break;
                case 'T':
                    searchByType(scanner);
                    break;
                case 'N':
                    addVehicle(scanner);
                    break;
                case 'X':
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("=== Dealership Menu ===");
        System.out.println("A. View All Vehicles");
        System.out.println("P. Search by Price Range");
        System.out.println("M. Search by Make/Model/Year/Color/Mileage Range");
        System.out.println("T. Search by Type");
        System.out.println("N. Add a New Vehicle");
        System.out.println("X. Exit");
        System.out.print("Choose an option: ");
    }

    private static void viewAllVehicles() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private static void searchByPriceRange(Scanner scanner) {
        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();

        List<Vehicle> vehicles = dealership.findByPriceRange(minPrice, maxPrice);
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private static void searchByMakeModelYearColorMileage(Scanner scanner) {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter minimum mileage: ");
        int minMileage = scanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int maxMileage = scanner.nextInt();

        List<Vehicle> vehicles = dealership.findByMakeModelYearColorMileage(make, model, year, color, minMileage, maxMileage);
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private static void searchByType(Scanner scanner) {
        System.out.print("Enter type: ");
        String type = scanner.nextLine();

        List<Vehicle> vehicles = dealership.findByType(type);
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private static void addVehicle(Scanner scanner) {
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter mileage: ");
        int mileage = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter type: ");
        String type = scanner.nextLine();

        Vehicle vehicle = new Vehicle(price, make, model, year, color, mileage, type);
        dealership.addVehicle(vehicle);

        System.out.println("Vehicle added successfully.");
    }

    private static void saveVehicleToFile(Vehicle vehicle) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DealershipFileManager.txt", true))) {
            writer.write(vehicle.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while writing the vehicle to the file.");
            e.printStackTrace();
        }
    }
}

}