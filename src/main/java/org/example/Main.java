package org.example;
import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable {

    public static void main(String[] args) {
        new Main().run();
        }
    private void run() {
        TrainList trains= new TrainList();
        IO io= new IOProcess();
        TrainFunction function= new TrainFunctionProcess();
        Scanner scanner=new Scanner(System.in);
        boolean status=true;
        option();
        while (status){
            int o=scanner.nextInt();
            switch (o){
                case 0 -> function.createTrainArr(trains);
                case 1 -> function.printTrainList(trains);
                case 2 -> function.printSortShippingTime(trains,scanner);
                case 3 -> function.printDestinAndTime(trains,scanner);
                case 4 -> function.printDestinAndNumSeats(trains,scanner);
                case 5 -> function.printDestinAndCommonSeats(trains,scanner);
                case 6 -> function.addTrain(trains,scanner);
                case 7 -> function.deleteTrainID(trains,scanner);
                case 8 -> io.writeObject(trains);
                case 9 -> io.readObject(trains);
                case 10 -> status=false;
            }
        }
    }

    private void option() {
        System.out.println("""
                0-Створити список потягів.
                1-Вивести весь список потягів.
                2-Список потягів, які прямують до заданого пункту призначення в порядку зростання часу
                  відправки, якщо час однаковий – за зростанням номеру потягів.
                3-Список потягів, які прямують до заданого пункту призначення та відправляються після
                  заданої години.
                4-Список потягів, які відправляються до заданого пункту призначення та мають загальні
                  місця.
                5-Список потягів, які відправляються до заданого пункту призначення в порядку зростання
                  кількості всіх місць.
                6-Додати новий потяг.
                7-Видалити потяг через id.
                8-Зберегти.
                9-Прочитати файл.
                10-Завершити програму;
                """);

    }
}
