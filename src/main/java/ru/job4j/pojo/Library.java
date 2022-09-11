package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book garryPotter = new Book("Garry Potter", 396);
        Book cleanCode = new Book("Clean code", 341);
        Book thinkingInJava = new Book("Thinking in Java", 887);
        Book whiteFang = new Book("White Fang", 354);
        Book[] books = new Book[4];
        books[0] = garryPotter;
        books[1] = cleanCode;
        books[2] = thinkingInJava;
        books[3] = whiteFang;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getTitle() + " " + bk.getPages() + " pages");
        }
        Book temp = new Book("", 0);
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getTitle() + " " + bk.getPages() + " pages");
        }
        for (Book book : books) {
            if (book.getTitle().equals("Clean code")) {
                System.out.println(book.getTitle() + " " + book.getPages() + " pages");
            }
        }
    }
}
