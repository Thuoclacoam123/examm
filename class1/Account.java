package com.class1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
     String customerCode;
     String customerName;
     int accNumber;
     long amount;


    public void input() {
        Scanner scanner = new Scanner(System.in);
        boolean IscustomerCode = false;
        boolean IsaccNumber = false;
        while (!IscustomerCode) {
            System.out.print("Input customerCode: ");
            String customerCodeInput = scanner.nextLine();
            if (customerCodeInput.length() != 5) {
                System.out.println("Customer code must be 5 characters old");
                continue;
            }
            IscustomerCode = true;
            customerCode = customerCodeInput;
        }
        System.out.print("Input customerName: ");
        customerName = scanner.nextLine();
        while (!IsaccNumber) {
            System.out.print("Input accNumber: ");
            String accNumberInput = scanner.nextLine();
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(accNumberInput);
            if (!matcher.matches()) {
                System.out.println("AccNumber must be a number");
                continue;
            }
            if (accNumberInput.length() != 6) {
                System.out.println("AccNumber must be 6 digits");
                continue;
            }
            if (!accNumberInput.startsWith("100")) {
                System.out.println("AccNumber must start with 100");
                continue;
            }
            IsaccNumber = true;
            accNumber = Integer.parseInt(accNumberInput);
        }
    }
    public void depositAndWithdraw(long amount, int type) {
        if (type == 0) {
            if (amount < 0) {
                System.out.println("Amount is positive");
                return;
            } this.amount += amount;
            return;
        }
        if (amount > 0 && amount < this.amount) {
            this.amount -= amount;
            return;
        } System.out.println("Not enough money");
    }




    @Override
    public String toString() {
        return String.format("customerCode = %s customerName = %s accNumber = %d amount = %d", customerCode, customerName, accNumber, amount);
    }
}
