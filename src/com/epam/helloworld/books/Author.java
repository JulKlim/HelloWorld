package com.epam.helloworld.books;

public class Author{
    public int id;
    public String firstName;
    public String lastName;
    public Author(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String LastName){
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "ID = " + id + ", First Name = " + firstName + ", Last Name = " + lastName;
    }

}
