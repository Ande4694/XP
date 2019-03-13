package com.example.xp.Model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class Booking {
    public Date getConvert() {
        return convert;
    }

    public void setConvert(Date convert) {
        this.convert = convert;
    }

    private int id;
    private String title;
    private String fullName;
    private boolean pay;
    private LocalDate playingDate;
    private Date convert;

    public Booking(int id, String title, String fullName, boolean pay, LocalDate playingDate) {
        this.id = id;
        this.title = title;
        this.fullName = fullName;
        this.pay = pay;
        this.playingDate = playingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPlayingDate() {
        return playingDate;
    }

    public void setPlayingDate(LocalDate playingDate) {
        this.playingDate = playingDate;
    }

    public Booking(boolean pay, String fullName) {
        this.pay = pay;
        this.fullName = fullName;
    }

    public Booking() {
    }

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "pay=" + pay +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
