import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        double distanceRun = Math.random() * 200;
        double distanceSwim = Math.random() * 0;
        Cat cat = new Cat(distanceRun, distanceSwim);

        distanceRun = Math.random() * 500;
        distanceSwim = Math.random() * 10;
        Animal dog = new Dog(distanceRun, distanceSwim);



        System.out.println("Введите дистанцию для бега:");
        double distance = scanner.nextDouble();


        System.out.println("Кошка может пробежать:" + cat.getAnimalDistanceRun());
        System.out.println("Собака может пробежать:" + dog.getAnimalDistanceRun());

        System.out.println("Введите дистанцию для плавания:");
        distance = scanner.nextDouble();


        System.out.println("Кошка может проплыть: " + cat.getGetAnimalDistanceSwim());
        System.out.println("Собака может проплыть: " + dog.getGetAnimalDistanceSwim());







        }


}
