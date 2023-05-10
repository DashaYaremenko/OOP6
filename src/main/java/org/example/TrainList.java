package org.example;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;

public class TrainList {
    private int size=0;
    private Train[] trains=new Train[10];
    public Train[] getTrains(){return trains;}
    public int getSize() {return size;}
    public void setSize(int size) {this.size = size;}
    public void setTrainList(Train[] train1) {
        trains=train1;
        size=trains.length;
    }
    public void addTrain(Train train){
        ensureCapacity(size + 1);
        trains[size++] = train;
    }
    private void ensureCapacity(int newCapacity) {
        if (newCapacity <= trains.length) return;
        Train[] newArray = new Train[trains.length * 2];
        System.arraycopy(trains, 0, newArray, 0, trains.length);
        trains = newArray;
    }
    public void deleteTrainID(int id) {
        Train[] trains1 = new Train[trains.length - 1];
        int num = 0;
        for (int i = 0, k = 0; i < size; i++) {
            if (trains[i].getId() != id) {
                trains1[k] = trains[i];
                k++;
            } else num++;
        }
        size -= num;
        trains = Arrays.copyOf(trains1,trains.length);
    }
    public Train[] sortShippingTime(String destination){
        Train[] trains1 = Arrays.copyOf(trains, size);
        Arrays.sort(trains1, Comparator.comparing(Train::getShipping_time).thenComparing(Train::getTrain_number));
        return trains1;
    }
    public void printTrainDestinAndTime(Train[] trains, String destination1, LocalTime time) {
        for (Train train:trains){
            if(train==null)continue;
            if(train.getDestination().equals(destination1)){System.out.println(train);}
            if (train.getShipping_time().isAfter(time)){System.out.println(train);}
        }

    }
    public void printTrainDestinAndNumSeats(Train[] trains, String destination2, int numberofsets) {
        for (Train train:trains){
            if(train==null)continue;
            if (train.getDestination().equals(destination2)){System.out.println(train);}
            if (train.getNumber_of_seats()<= numberofsets){System.out.println(train);}
        }
    }
    public Train[] sortCommonSeats(String destination){
        Train[]trains2= Arrays.copyOf(trains,size);
        Arrays.sort(trains2,Comparator.comparing(Train::getNumber_of_seats));
        return trains2;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(trains[i]).append(",\n");
        }
        return sb.toString();
    }
}

