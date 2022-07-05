package com.belhard.multithreading;

import beans.Car;
import beans.Parking;

public class Main {

    public static void main(String[] args) {
        Parking parking = new Parking();
        Thread threadIn = new Thread(() -> {
           while (true) {
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               Car car = new Car();
               parking.carEntry(car);
           }
        });
        Thread threadOut = new Thread(() -> {
           while (true) {
               parking.carExit();
           }
        });
        threadIn.start();
        threadOut.start();
    }
}
