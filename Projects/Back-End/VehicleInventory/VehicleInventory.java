

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Program to calculate the average weekly tax withholding amount based on
 * weekly income
 *
 * @author Bella Scholtes
 *
 */

public class Automobile {

    public Automobile() {
        // no code needed here
    }

    public static void main(String[] args) {
    }

    String make;
    String model;
    String color;
    int year;
    int mileage;

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return this.mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Automobile [make=" + this.make + ", model=" + this.model
                + ", color=" + this.color + ", year=" + this.year + ", mileage="
                + this.mileage + "]";
    }
}

class AutomobileInventory {
    static ArrayList<Automobile> vehicleList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter vehicle make:");
        String make = scnr.nextLine();

        System.out.println("Enter vehicle model:");
        String model = scnr.nextLine();

        System.out.println("Enter vehicle color:");
        String color = scnr.nextLine();

        System.out.println("Enter vehicle year:");
        int year = scnr.nextInt();

        System.out.println("Enter vehicle mileage");
        int mileage = scnr.nextInt();
        scnr.close();

        System.out.println("Option List");
        System.out.println("Press 1 to add vehicle: ");
        System.out.println("Press 2 to remove vehicle: ");
        System.out.println("Press 3 to update vehicle: ");
        System.out.println("Press 4 to list vehicle information: ");

        System.out.print("Enter option: ");
        int option = scnr.nextInt();
        if (option == 1) {
            addVehicle(make, model, color, year, mileage);
        } else if (option == 2) {
            removeVehicle(make, model, color, year, mileage);
        } else if (option == 3) {
            updateVehicle(make, model, color, year, mileage);
        } else if (option == 4) {
            //listVehicleInfo(make, model, color, year, mileage);
        } else {
            System.out.println("Invalid number entered.");
        }
        System.out.print("Would you like to print the information to a file? "
                + "Enter Y or N: ");
        String answer = scnr.nextLine();
        if (answer == "Y") {
            printFile();

        } else if (answer == "N") {
            System.out.println("File will not be printed.");
            return;
        } else {
            System.out.println("Invalid input.");
        }

    }

    public static void addVehicle(String make, String model, String color,
            int year, int mileage) {

        Scanner scnr = new Scanner(System.in);
        Automobile automobile = new Automobile();

        automobile.setMake(make);
        automobile.setModel(model);
        automobile.setColor(color);
        automobile.setYear(year);
        automobile.setMileage(mileage);

        vehicleList.add(automobile);
        System.out.println("Vehicle Successfully Added.");
        //listVehicleInfo(make, model, color, year, mileage);
        scnr.close();

    }

    public static void removeVehicle(String make, String model, String color,
            int year, int mileage) {

        Scanner scnr = new Scanner(System.in);

        ListIterator<Automobile> iterator = vehicleList.listIterator();
        boolean flag = false;
        while (iterator.hasNext() && flag == false) {
            Automobile car = iterator.next();
            if (car.getMake().equalsIgnoreCase(make)
                    && car.getModel().equalsIgnoreCase(model)
                    && car.getColor().equalsIgnoreCase(color)
                    && car.getYear() == year && car.getMileage() == mileage) { // Line Showing Error
                iterator.remove();
                flag = true;
            }
        }
        if (flag == true) {
            System.out.println("Vehicle Successfully Removed");
        } else {
            System.out.println("No matching vehicle found.");
        }
        scnr.close();

    }

    public static void updateVehicle(String make, String model, String color,
            int year, int mileage) {

        Scanner scnr = new Scanner(System.in);

        ListIterator<Automobile> iterator = vehicleList.listIterator();
        boolean flag = false;
        while (iterator.hasNext() && flag == false) {
            Automobile car = iterator.next();
            if (car.getMake().equalsIgnoreCase(make)
                    && car.getModel().equalsIgnoreCase(model)
                    && car.getColor().equalsIgnoreCase(color)
                    && car.getYear() == year && car.getMileage() == mileage) { // Line Showing Error
                System.out.print("Enter the new make of vehicle: ");
                make = scnr.nextLine();
                System.out.print("Enter the new model of vehicle: ");
                model = scnr.nextLine();
                System.out.print("Enter the new color of vehicle: ");
                color = scnr.nextLine();
                System.out.print("Enter the new year of vehicle: ");
                year = scnr.nextInt();
                System.out.print("Enter the new mileage of vehicle: ");
                mileage = scnr.nextInt();
                car.setMake(make);
                car.setModel(model);
                car.setColor(color);
                car.setYear(year);
                car.setMileage(mileage);
                flag = true;
            }
        }
        if (flag == true) {
            System.out.println("Vehicle Successfully Updated");
        } else {
            System.out.println("No matching vehicle found.");
        }
        scnr.close();

    }

    public static void printFile() {
        try {
            FileWriter fw = new FileWriter("VehicleInventory.txt");
            BufferedWriter printer = new BufferedWriter(fw);
            printer.write("Vehicle Inventory");
            System.out.println("--Make----Model----Color----Year----Mileage--");
            java.util.Iterator<Automobile> next = vehicleList.iterator();
            while (next.hasNext()) {
                printer.write(next.next().toString() + "/n");
            }
            printer.close();
            System.out.println("VehicleInventory file created successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }

    }

    public static String[] listVehicleInfo(String make, String model,
            String color, int year, int mileage) {
        String[] str = new String[5];
        str[0] = make;
        str[1] = model;
        str[2] = color;
        str[3] = Integer.toString(year);
        str[4] = Integer.toString(mileage);

        return str;
    }
}
