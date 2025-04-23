package com.mycompany.faren;

import java.util.Scanner;

//BAAP CLASS
class Franchise {
    String franchiseName;
    String owner;
    String location;
    int year;
    double income;
    double average;

    Franchise(String franchiseName, String owner, String location, int year, double income, double average) {
        this.franchiseName = franchiseName;
        this.owner = owner;
        this.location = location;
        this.year = year;
        this.income = income;
        this.average = average;
    }

    void display() {
        System.out.println("Franchise Name: " + franchiseName);
        System.out.println("Owner: " + owner);
        System.out.println("Location: " + location);
        System.out.println("Established Year: " + year);
        System.out.println("Income: " + income);
        System.out.println("Average Expense: " + average);
    }

    void calculateProfit() {
        double profit = income - (average * 12); // assuming average is monthly expense
        System.out.println("Annual Profit: " + profit);
    }
}

// DHA Franchise
class DHAFranchise extends Franchise {
    DHAFranchise(String owner, double income, double average) {
        super("DHA Franchise", owner, "DHA", 2015, income, average);
    }
}

// Johar Franchise
class JoharFranchise extends Franchise {
    boolean hasDriveThrough;

    JoharFranchise(String owner, double income, double average) {
        super("Johar Franchise", owner, "Johar", 2018, income, average);
        this.hasDriveThrough = true;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Drive-Through: " + (hasDriveThrough ? "Available" : "Not Available"));
    }
}

// Main Class
public class Farenchise {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input for DHA Franchise
        System.out.println("Enter DHA Franchise Owner Name:");
        String dhaOwner = input.nextLine();
        System.out.println("Enter DHA Franchise Income:");
        double dhaIncome = input.nextDouble();
        System.out.println("Enter DHA Franchise Monthly Average Expense:");
        double dhaAvg = input.nextDouble();
        input.nextLine(); // clear buffer

        // Input for Johar Franchise
        System.out.println("\nEnter Johar Franchise Owner Name:");
        String joharOwner = input.nextLine();
        System.out.println("Enter Johar Franchise Income:");
        double joharIncome = input.nextDouble();
        System.out.println("Enter Johar Franchise Monthly Average Expense:");
        double joharAvg = input.nextDouble();

        // Objects creation
        DHAFranchise dha = new DHAFranchise(dhaOwner, dhaIncome, dhaAvg);
        JoharFranchise johar = new JoharFranchise(joharOwner, joharIncome, joharAvg);

        // Displaying Info
        System.out.println("\n--- DHA Franchise Details ---");
        dha.display();
        dha.calculateProfit();

        System.out.println("\n--- Johar Franchise Details ---");
        johar.display();
        johar.calculateProfit();

        input.close();
    }
}
