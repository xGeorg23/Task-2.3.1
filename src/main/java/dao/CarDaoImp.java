package dao;

import model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class CarDaoImp implements CarDao {

    @Override
    public ArrayList<Car> getCar(){
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Car 1" , 111));
        cars.add(new Car(2, "Car 2" , 222));
        cars.add(new Car(3, "Car 3" , 333));
        cars.add(new Car(4, "Car 4" , 444));
        cars.add(new Car(5, "Car 5" , 555));
        cars.add(new Car(6, "Car 6" , 666));
        return cars;
    }
}
