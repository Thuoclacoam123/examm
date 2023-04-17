package com.class1;
import java.util.Scanner;
public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Account account = new Account();
        account.input();
        System.out.print("send money(1) or withdraw money (2): ");
        int type = Integer.parseInt(scanner.nextLine());
        System.out.print("enter the amount: ");
        long amount = Integer.parseInt(scanner.nextLine());
        account.depositAndWithdraw(amount, type);
        System.out.println(account);
    }
}
