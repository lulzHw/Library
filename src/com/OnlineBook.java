package com;

public class OnlineBook extends Book {
    private String site;
    private String nickname;

    public OnlineBook(String author, String title, String publisher, String date,
                      String numberOfPages, String site, String nickname) {
        super(author, title, publisher, date, numberOfPages);
        this.site = site;
        this.nickname = nickname;
    }

    public OnlineBook(Book book, String site, String nickname) {
        super(book.getAuthor(), book.getTitle(), book.getPublisher(), book.getDate(), book.getNumberOfPages());
        this.site = site;
        this.nickname = nickname;
    }

    public String getSite() {
        return site;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return super.toString() +
                "; Site: " + site +
                "; Nickname: " + nickname;
    }
}