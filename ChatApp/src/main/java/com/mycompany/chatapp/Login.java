package com.mycompany.chatapp;

public class Login {
    private String savedUsername;
    private String savedPassword;
    private String Malebo;
    private String Mphahlele;

    public Boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public Boolean checkPasswordComplexity(String password) {
        boolean length = password.length() >= 8;
        boolean capital = !password.equals(password.toLowerCase());
        boolean number = password.matches(".*\\d.*");
        boolean special = password.matches(".*[^a-zA-Z0-9].*");
        return length && capital && number && special;
    }

    public Boolean checkCellPhoneNumber(String cellNumber) {
        String regex = "^\\+\\d{1,3}\\d{1,10}$";
        return cellNumber.matches(regex) && cellNumber.length() <= 13;
    }

    public String registerUser(String username, String password, String cell, String fName, String lName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cell)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        this.savedUsername = username;
        this.savedPassword = password;
        this.Malebo = fName;
               
        this.Mphahlele = lName;
        return "User registered successfully.";
    }

    public Boolean loginUser(String username, String password) {
        if (savedUsername == null) return false;
        return username.equals(savedUsername) && password.equals(savedPassword);
    }

    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + Malebo + " " + Mphahlele + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    public String getUsernameStatus(String username) {
        if (checkUserName(username)) return "Username successfully captured.";
        else return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
    }
    public String getPasswordStatus(String password) {
        if (checkPasswordComplexity(password)) return "Password successfully captured.";
        else return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }
    public String getCellStatus(String cell) {
        if (checkCellPhoneNumber(cell)) return "Cell number successfully captured.";
        else return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
    }
}