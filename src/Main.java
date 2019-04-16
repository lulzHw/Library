import com.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        librarian();
    }

    private static void librarian() {
        Library library = initializeLibrary();
        DateFormat dateFormat = null;
        String author = null;
        String title = null;
        String publisher = null;
        String date = null;
        String numberOfPages = null;
        Scanner scanner = new Scanner(System.in);
        printMenu();
        System.out.print("Введите номер операции: ");
        int userChoice = scanner.nextInt();
        while (true) {
            switch (userChoice) {
                case 0:
                    System.out.println("Работа завершена.");
                    return;
                case 1:
                    library.print();
                    break;
                case 2:
                    System.out.println("Введите книгу:");
                    author = scanner.next();
                    title = scanner.next();
                    publisher = scanner.next();
                    date = scanner.next();
                    numberOfPages = scanner.next();
                    library.add(new Book(author, title, publisher, date, numberOfPages));
                    break;
                case 3:
                    System.out.print("Введите автора: ");
                    author = scanner.next();
                    library.searchByAuthor(author);
                    break;
                case 4:
                    System.out.print("Введите слово: ");
                    scanner.nextLine();
                    title = scanner.nextLine();
                    library.searchByTitleKeyword(title);
                    break;
                case 5:
                    System.out.print("Введите формат даты (DMY/MY/Y): ");
                    dateFormat = DateFormat.valueOf(scanner.next());
                    library.printDates(dateFormat);
                    break;
                case 6:
                    System.out.print("Введите две даты для подсчёта их разности: ");
                    String firstDate = scanner.next();
                    String secondDate = scanner.next();
                    library.subtractDates(firstDate, secondDate);
                    break;
                case 7:
                    System.out.print("Введите две даты для их сравнения: ");
                    String firstD = scanner.next();
                    String secondD = scanner.next();
                    library.compareDates(firstD, secondD);
                    break;
                case 8:
                    System.out.print("Введите дату для поиска книги: ");
                    String searchDate = scanner.next();
                    library.searchByDate(searchDate);
                    break;
                case 9:
                    System.out.print("Введите промежуток времени: ");
                    String x = scanner.next();
                    String y = scanner.next();
                    library.searchByRange(x, y);
                    break;
                case 10:
                    System.out.println("Введите автора первой книги:");
                    scanner.nextLine();
                    String firstAuthor = scanner.nextLine();
                    System.out.println("Введите автора второй книги:");
                    String secondAuthor = scanner.nextLine();
                    Book firstBook = library.getBookByTitle(firstAuthor);
                    Book secondBook = library.getBookByTitle(secondAuthor);
                    library.compareBooks(firstBook, secondBook);
                    break;
                default:
                    System.out.println("Неподдерживаемая операция, повторите ввод: ");
                    break;
            }
            System.out.print("Введите номер операции: ");
            userChoice = scanner.nextInt();
        }
    }

    private static Library initializeLibrary() {
        Library library = new Library();
        Book wap = new Book("Толстой", "Война и мир", "Exmo", "14.03.1867", "1274");
        Book cap = new Book("Достоевский", "Преступление и наказание", "AST", "05.07.1866", "574");
        Book mam = new Book("Булгаков", "Мастер и Маргарита", "Azbuka", "24.10.1966", "480");
        Book hoot = new Book("Лермонтов", "Герой нашего времени", "AST", "19.05.1840", "167");
        library.add(wap);
        library.add(cap);
        library.add(mam);
        library.add(hoot);
        return library;
    }

    private static void printMenu() {
        System.out.println( "0: выход\n" +
                            "1: вывести книги\n" +
                            "2: записать книгу\n" +
                            "3: поиск по автору\n" +
                            "4: поиск по любому слову названия книги или сочетанию слов\n" +
                            "5: вывод дат\n" +
                            "6: вычитание двух дат\n" +
                            "7: сравнение двух дат\n" +
                            "8: поиск книги по дате\n" +
                            "9: поиск по промежутку времени\n" +
                            "10: сравнение, какая книга была написана раньше");
    }
}