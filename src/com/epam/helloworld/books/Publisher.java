package com.epam.helloworld.books;

public class Publisher{
    public int id;
    public String publisherName;
    public String address;

    public Publisher(int id, String publisherName, String address) {
        this.id = id;
        this.publisherName = publisherName;
        this.address = address;
    }
    public int getID(){

        return id;
    }
    public void setID(int id){

        this.id = id;
    }
    public String getPublisherName(){
        return publisherName;
    }
    public void setPublisherName(String publishername){
        this.publisherName = publishername;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){

        this.address = address;
    }
    @Override
    public String toString() {
        return "ID = "  + id + ", Publisher Name = " + publisherName + ", Address = " + address;
    }
}
