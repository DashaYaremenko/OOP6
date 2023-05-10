package org.example;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class TrainFunctionProcess implements TrainFunction {
    @Override
    public void printSortShippingTime(TrainList trains, Scanner scanner) {
        System.out.println("Введіть пункт призначення: ");
        String destination=scanner.next();
        Train[] trains1 = trains.sortShippingTime(destination);
        for (Train train : trains1) {
            if (train.getDestination().equals(destination)){
                System.out.println(train);
            }
        }
    }
    @Override
    public void printDestinAndTime(TrainList trains, Scanner scanner) {
        System.out.println("Введіть пункт призначення: ");
        String destination=scanner.next();
        System.out.print("Введіть години відправлення: ");
        int b=scanner.nextInt();
        int n=scanner.nextInt();
        LocalTime time=LocalTime.of(b,n);
        trains.printTrainDestinAndTime(trains.getTrains(),destination,time);

    }
    @Override
    public void printDestinAndNumSeats(TrainList trains, Scanner scanner) {
        System.out.print("Введіть пункт призначення: ");
        String destination=scanner.next();
        System.out.print("Введіть загальне місце: ");
        int number_of_sets=scanner.nextInt();
        trains.printTrainDestinAndNumSeats(trains.getTrains(),destination,number_of_sets);
    }
    @Override
    public void printDestinAndCommonSeats(TrainList trains, Scanner scanner) {
        System.out.println("Введіть пункт призначення: ");
        String destination = scanner.next();
        Train[]trains2=trains.sortCommonSeats(destination);
        for (Train train:trains2){
            if(train.getDestination().equals(destination)){
                System.out.println(train);
            }
        }
    }
    @Override
    public void addTrain(TrainList trains, Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("Пункт призначення: ");
        scanner.nextLine();
        String destination = scanner.nextLine();
        System.out.print("Номер поїзду: ");
        int train_number = scanner.nextInt();
        System.out.print("Час відправки: ");
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        System.out.print("Число місць: ");
        int number_of_seats = scanner.nextInt();
        trains.addTrain(new Train(id, destination, train_number, LocalTime.of(hour, minute), number_of_seats));
    }
    @Override
    public void deleteTrainID(TrainList trains, Scanner scanner) {
        System.out.println("Введіть ID:");
        int id=scanner.nextInt();
        trains.deleteTrainID(id);
    }
    @Override
    public void printTrainList(TrainList trains) {
        System.out.println(trains.getSize());
        System.out.println(trains);
    }
    @Override
    public void createTrainArr(TrainList trains) {
        trains.addTrain(new Train(1,"Херсон",102, LocalTime.of(22,14), 22));
        trains.addTrain(new Train(2,"Херсон",102, LocalTime.of(18,48), 15));
        trains.addTrain(new Train(3,"Херсон",732, LocalTime.of(22,14), 10));
        trains.addTrain(new Train(4,"Маріуполь",846, LocalTime.of(10,30), 20));
        trains.addTrain(new Train(5,"Бердянськ",116, LocalTime.of(9,00), 13));
        trains.addTrain(new Train(6,"Миколаїв",121, LocalTime.of(20,35), 19));
        trains.addTrain(new Train(7,"Ялта",100, LocalTime.of(5,30), 25));
        trains.addTrain(new Train(8,"Енергодар",265, LocalTime.of(19,15), 56));
        trains.addTrain(new Train(9,"Херсон",325, LocalTime.of(16,45), 36));
        trains.addTrain(new Train(10,"Одеса",105,LocalTime.of(17,40),30));
        trains.addTrain(new Train(11,"Тернопіль",235,LocalTime.of(22,35),54));
    }
}