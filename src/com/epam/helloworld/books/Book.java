package com.epam.helloworld.books;

public class Book {
    public int ISBN;
    public String Name;
    public String Authors;
    public String Publisher;
    public String PublicationDate;
    public boolean Paperback;
    public Book(int ISBN, String Name, String Authors, String Publisher, String PublicationDate, boolean Paperback) {
        this.ISBN = ISBN;
        this.Name = Name;
        this.Authors = Authors;
        this.Publisher = Publisher;
        this.PublicationDate = PublicationDate;
        this.Paperback = Paperback;
    }
    public int getISBN() {
        return ISBN;
    }
    public void setISBN(int ISBN){
        this.ISBN = ISBN;
    }
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public String getAuthors(){
        return Authors;
    }
    public void setAuthors(String Authors){
        this.Authors = Authors;
    }
    public String getPublisher(){
        return Publisher;
    }
    public void setPublisher(String Publisher){
        this.Publisher = Publisher;
    }
    public String getPublicationDate(){
        return PublicationDate;
    }
    public void setPublicationDate(String PublicationDate){
        this.PublicationDate = PublicationDate;
    }
    public boolean getPaperback(){
        return Paperback;
    }
    public void setPaperback(boolean Paperback){
        this.Paperback = Paperback;
    }
    @Override
    public String toString() {
        return "ISBN = "  + ISBN + ", Name = " + Name + ", Authors = " + Authors + ", Publisher = " + Publisher + ", Publication Date = " + PublicationDate + ", Paperback = " + Paperback;
    }
}
