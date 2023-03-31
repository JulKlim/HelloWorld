package com.epam.helloworld.books;

public class Publisher{
    public int ID;
    public String PublisherName;
    public String Address;

    public Publisher(int ID, String PublisherName, String Address) {
        this.ID = ID;
        this.PublisherName = PublisherName;
        this.Address = Address;
    }
    public int getID(){
        return ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public String getPublisherName(){
        return PublisherName;
    }
    public void setPublisherName(String PublisherName){
        this.PublisherName = PublisherName;
    }
    public String getAddress(){
        return Address;
    }
    public void setAddress(String Address){
        this.Address = Address;
    }
    @Override
    public String toString() {
        return "ID = "  + ID + ", Publisher Name = " + PublisherName + ", Address = " + Address;
    }
}
