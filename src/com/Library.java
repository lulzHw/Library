package com;

import java.util.List;
import java.util.ArrayList;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void print() {
        System.out.println("All books:");
        for (var book : books) {
            System.out.println("\t" + book);
        }
    }

    public void add(Book book) {
        books.add(book);
    }

    public void searchByAuthor(String author) {
        List<Book> authorBooks = new ArrayList<>();
        for (var currentBook : books) {
            if (currentBook.getAuthor().equalsIgnoreCase(author)) {
                authorBooks.add(currentBook);
            }
        }
        if (!authorBooks.isEmpty()) {
            System.out.println("Search by author " + author + ":");
            for (var book : authorBooks) {
                System.out.println("\t" + book);
            }
        } else {
            System.out.println("No artworks by this author.");
        }
    }

    public void searchByTitleKeyword(String keyword) {
        List<Book> titles = new ArrayList<>();
        for (var currentBook : books) {
            if (currentBook.getTitle().contains(keyword)) {
                titles.add(currentBook);
            }
        }
        if (!titles.isEmpty()) {
            System.out.println("All artworks with \"" + keyword +"\":");
            for (var book : titles) {
                System.out.println("\t" + book);
            }
        } else {
            System.out.println("No artworks with this title.");
        }
    }

    public void printDates(DateFormat format) {
        System.out.println("All books in date format " + format);
        for (var book : books) {
            String date = getFormattedDate(format, book.getDate());
            System.out.println("\tArtwork \"" + book.getTitle() + "\" was released in " + date);
        }
    }

    public void subtractDates(String firstDate, String secondDate) {
        System.out.println("The difference between the first and second date = "
                + Math.abs(calculateDifference(firstDate, secondDate)) + " days.");
    }

    public void compareDates(String firstDate, String secondDate) {
        int difference = calculateDifference(firstDate, secondDate);
        if (difference == 0) {
            System.out.println("Dates are equal.");
        } else if (difference > 0) {
            System.out.println("The first date " + firstDate + " is greater " + secondDate);
        } else {
            System.out.println("The second date " + secondDate + " is greater " + firstDate);
        }
    }

    public void compareBooks(Book firstBook, Book secondBook) {
        int difference = calculateDifference(firstBook.getDate(), secondBook.getDate());
        if (difference == 0) {
            System.out.println("Books released in one day.");
        } else if (difference < 0) {
            System.out.println("\"" + firstBook.getTitle() + "\" was released earlier \"" + secondBook.getTitle() + "\".");
        } else {
            System.out.println("\"" + firstBook.getTitle() + "\" was released later \"" + secondBook.getTitle() + "\".");
        }
    }

    public void searchByDate(String date) {
        List<Book> dates = new ArrayList<>();
        for (var book : books) {
            if (book.getDate().contains(date)) {
                dates.add(book);
            }
        }
        if (!dates.isEmpty()) {
            System.out.println("All books with date " + date + ":");
            for (var book : dates) {
                System.out.println("\t" + book);
            }
        } else {
            System.out.println("There is no book with this date.");
        }
    }

    public void searchByRange(String firstDate, String secondDate) {
        List<Book> range = new ArrayList<>();
        for (var book : books) {
            String bookDate = book.getDate();
            if (calculateDifference(firstDate, bookDate) <= 0 && calculateDifference(secondDate, bookDate) >= 0) {
                range.add(book);
            }
        }
        if (!range.isEmpty()) {
            System.out.println("All books in range " + firstDate + " and " + secondDate + ":");
            for (var book : range) {
                System.out.println("\t" + book);
            }
        } else {
            System.out.println("There is no book in this range.");
        }
    }

    public Book getBookByTitle(String title) {
        for (var book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    private String getFormattedDate(DateFormat format, String date) {
        switch (format) {
            case Y:
                return date.substring(date.lastIndexOf('.') + 1);
            case MY:
                return date.substring(date.indexOf('.') + 1);
            case DMY:
                return date;
        }
        return null;
    }

    private int calculateDifference(String firstDate, String secondDate) {
        return calculateDate(firstDate) - calculateDate(secondDate);
    }

    private int calculateDate(String date) {
        int d = Integer.valueOf(date.substring(0, date.indexOf('.')));
        int m = Integer.valueOf(date.substring(date.indexOf('.') + 1, date.lastIndexOf('.')));
        int y = Integer.valueOf(date.substring(date.lastIndexOf('.') + 1));
        return d + m * 30 + y * 365;
    }
}