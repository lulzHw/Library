package com;

public class Book {
    private String author;
    private String title;
    private String publisher;
    private String date;
    private String numberOfPages;

    public Book(String author, String title, String publisher, String date, String numberOfPages) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        if (date.indexOf('.') == -1) {
            this.date = "00.00." + date;
        } else if (date.indexOf('.') == date.lastIndexOf('.')) {
            this.date = "00." + date;
        } else {
            this.date = date;
        }
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDate() {
        return date;
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return "Автор: " + author +
                "; Название: " + title +
                "; Издательство: " + publisher +
                "; Дата: " + date +
                "; Количество страниц: " + numberOfPages;
    }
}