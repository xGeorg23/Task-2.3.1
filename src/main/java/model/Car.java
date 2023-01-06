package model;

public class Car {
    long carId;
    String car;
    int series;

    public Car(long carId, String car, int series) {
        this.carId = carId;
        this.car = car;
        this.series = series;
    }

    @Override
    public String toString() {
        return carId + " " + car + " " + series;
    }
}
