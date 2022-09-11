package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Garry Potter", 396);
        books[1] = new Book("Clean code", 341);
        books[2] = new Book("Thinking in Java", 887);
        books[3] = new Book("White Fang", 354);
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
            if ("Clean code".equals(book.getTitle())) {
                System.out.println(book.getTitle() + " " + book.getPages() + " pages");
            }
        }
    }
}
