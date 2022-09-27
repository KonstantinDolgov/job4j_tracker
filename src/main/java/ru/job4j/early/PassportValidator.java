package ru.job4j.early;

public class PassportValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password don't entered");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Length of password is wrong");
        }
        if (password.equals(password.toLowerCase())) {
            throw new IllegalArgumentException("Must have an uppercase word");
        }
        if (password.equals(password.toUpperCase())) {
            throw new IllegalArgumentException("Must have an lowercase word");
        }
        char[] passArray = password.toCharArray();
        int digits = 0;
        int specials = 0;
        for (char symbol : passArray) {
            if (Character.isDigit(symbol)) {
                digits++;
            }
            if (!Character.isDigit(symbol) && !Character.isLetter(symbol)) {
                specials++;
            }
        }
        if (digits == 0) {
            throw new IllegalArgumentException("Must have an digit");
        }
        if (specials == 0) {
            throw new IllegalArgumentException("Must have an special symbol");
        }
        String[] substrings = {"qwerty", "12345", "password", "admin", "user"};
        for (String word : substrings) {
            if (password.toLowerCase().contains(word)) {
                throw new IllegalArgumentException("Don't use standard words");
            }
        }
        return "Password created";
    }
}