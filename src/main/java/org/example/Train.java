package org.example;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class Train implements Serializable {
    private int id;
    private String destination;
    private int train_number;
    private LocalTime shipping_time;
    private int number_of_seats;
    public Train(int id, String destination, int train_number, LocalTime shipping_time, int number_of_seats) {
        this.id = id;
        this.destination = destination;
        this.train_number = train_number;
        this.shipping_time = shipping_time;
        this.number_of_seats = number_of_seats;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setTrain_number(int train_number) {
        this.train_number = train_number;
    }
    public void setShipping_time(LocalTime shipping_time) {
        this.shipping_time = shipping_time;
    }
    public void setNumber_of_seats(int number_of_seats) {
        this.number_of_seats = number_of_seats;
    }
    public int getId(){return id;}
    public String getDestination() {
        return destination;
    }
    public LocalTime getShipping_time() {
        return shipping_time;
    }
    public int getNumber_of_seats() {
        return number_of_seats;
    }
    public int getTrain_number(){return train_number;}

    public String toString() {
        return "Потяг :" +
                "  id = " + id +
                "  Пунк призначення = '" + destination + '\'' +
                "\t Номер потяга = '" + train_number + '\'' + "\tЧас відправки  = " + shipping_time +
                "  \tЧисло місця = '" + number_of_seats + '\'';
    }
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        Train train = (Train) a;
        return
                id == train.id &&
                        train_number == train.train_number &&
                        number_of_seats == train.number_of_seats &&
                        Objects.equals(destination, train.destination);
    }
}
