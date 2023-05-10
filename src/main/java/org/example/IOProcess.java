package org.example;

import java.io.*;

public class IOProcess implements IO {
    @Override
    public void writeObject(TrainList trains) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("trains.dat"))) {
            oos.writeObject(trains.getTrains());
            System.out.println("Запис файлу успішний");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Train[] readObject(TrainList trains) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("trains.dat"))) {
            Train[] pr = (Train[]) ois.readObject();
            System.out.println("Вітаю! Файл прочитано");
            return pr;
        } catch (IOException e) {
            System.out.println("О ні! Помилка читання файлу");
        } catch (ClassNotFoundException e) {
            System.out.println("Нажаль файл не знайдено");
        }
        return new Train[0];
    }

}
