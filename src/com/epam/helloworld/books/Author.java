package com.epam.helloworld.books;

public class Author{
    public int ID;
    public String FirstName;
    public String LastName;
    public Author(int ID, String FirstName, String LastName) {
        this.ID = ID;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }
    public int getID(){
        return ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public String getFirstName(){
        return FirstName;
    }
    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }
    public String getLastName(){
        return LastName;
    }
    public void setLastName(String LastName){
        this.LastName = LastName;
    }
    @Override
    public String toString() {
        return "ID = " +
                "First Name = " + FirstName +
                ", Last Name = " + LastName;
    }

}
