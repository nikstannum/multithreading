package beans;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Parking {
    final int numberOfParkingSpaces = 50;
    int numberOfOccupiedParkingSpaces;
    Map<Integer, Car> cars = new Hashtable<>(50);
    private Lock lock = new ReentrantLock();

    public void carEntry(Car car) {
        lock.lock();
        if ((numberOfParkingSpaces - numberOfOccupiedParkingSpaces) < 1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((numberOfParkingSpaces - numberOfOccupiedParkingSpaces) < 1)
                System.out.println("The car didn't wait -- " + car);
        } else {
            numberOfOccupiedParkingSpaces++;
            int numberOfSpace = new Random().nextInt(numberOfParkingSpaces) + 1;
            while (cars.get(numberOfSpace) != null) {
                numberOfSpace = new Random().nextInt(numberOfParkingSpaces) + 1;
            }
            cars.put(numberOfSpace, car);
            System.out.println("Car entered ---> " + car + " number of space = " + numberOfSpace);
            lock.unlock();
        }
    }

    public void carExit() {
        int numberOfSpace = new Random().nextInt(numberOfParkingSpaces) + 1;
        Car car = cars.remove(numberOfSpace);
        if (car != null) {
            long waitingInParking = (long) ((Math.random() * 2500) + 500);
            try {
                Thread.sleep(waitingInParking);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            numberOfOccupiedParkingSpaces--;
            System.out.println("Car exited <--- " + car + ", from number of space = " + numberOfSpace + ", time " +
                    "waiting " +
                    "in parking = " + waitingInParking);
        }
    }
}
