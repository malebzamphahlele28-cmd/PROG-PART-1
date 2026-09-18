package com.mycompany.chatapp;

import java.util.Scanner;

public class ChatApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login login = new Login();

        System.out.println("=== REGISTRATION ===");
        System.out.print("First Name: ");
        String fn = sc.nextLine();
        System.out.print("Last Name: ");
        String ln = sc.nextLine();
        System.out.print("Username (e.g. kyl_1): ");
        String user = sc.nextLine();
        System.out.print("Password (e.g. Ch&sec@ke99!): ");
        String pass = sc.nextLine();
        System.out.print("Cell (+27... e.g. +27838968976): ");
        String cell = sc.nextLine();

        System.out.println(login.getUsernameStatus(user));
        System.out.println(login.getPasswordStatus(pass));
        System.out.println(login.getCellStatus(cell));

        String result = login.registerUser(user, pass, cell, fn, ln);
        System.out.println(result);

        if(result.equals("User registered successfully.")){
            System.out.println("\n=== LOGIN ===");
            System.out.print("Username: ");
            String u = sc.nextLine();
            System.out.print("Password: ");
            String p = sc.nextLine();
            System.out.println(login.returnLoginStatus(u, p));
        }
    }
}