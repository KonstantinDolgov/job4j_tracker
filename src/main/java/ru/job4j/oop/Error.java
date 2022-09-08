package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Есть ошибка: " + active);
        System.out.println("Индификатор ошибки: " + status);
        System.out.println("Информация об ошибке: " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        error1.printInfo();
        Error error2 = new Error(true, 1, "Критическая");
        error2.printInfo();
        Error error3 = new Error(false, 0, "Нет ошибок");
        error3.printInfo();
    }
}
