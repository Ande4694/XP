package com.example.xp.Model;

public class Order {

    private String movieName;
    private String buyerName;
    private boolean pay = false;
    private int seats;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Order(String movieName, String buyerName, boolean pay, int seats) {
        this.movieName = movieName;
        this.buyerName = buyerName;
        this.pay = pay;
        this.seats = seats;
    }

    public Order() {
    }
}
