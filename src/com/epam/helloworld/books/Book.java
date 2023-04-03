package com.epam.helloworld.books;

public class Book {
    public int isbn;
    public String name;
    private Author authors;
    private Publisher publisher;
    public String publicationDate;
    public boolean paperback;
    public Book(int isbn, String name, Author authors, Publisher publisher, String publicationDate, boolean paperback) {
        this.isbn = isbn;
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.paperback = paperback;
    }
    public int getISBN() {

        return isbn;
    }
    public void setISBN(int isbn){

        this.isbn = isbn;
    }
    public String getName(){

        return name;
    }
    public void setName(String name){

        this.name = name;
    }
    public Author getAuthor(){
        return authors;
    }
    public Publisher getPublisher(){
        return publisher;
    }
    public String getPublicationDate(){

        return publicationDate;
    }
    public void setPublicationDate(String publicationDate){

        this.publicationDate = publicationDate;
    }
    public boolean getPaperback(){

        return paperback;
    }
    public void setPaperback(boolean Paperback){

        this.paperback = paperback;
    }
    @Override
    public String toString() {
        return "ISBN = "  + isbn + ", Name = " + name + ", Authors = " + authors + ", Publisher = " + publisher + ", Publication Date = " + publicationDate + ", Paperback = " + paperback;
    }


}
