package java8.service.impl;

import java8.classes.Car;
import java8.classes.Person;
import java8.service.CarService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarImpl implements CarService {

    List<Car>cars= new ArrayList<>();
    @Override
    public String createCar(List<Car> cars) {
        this.cars=cars;
      return "Cars are successfully created!" ;
    }

    @Override
    public String removeCar(String name, List<Car> cars) {
        for (Car car : cars) {
            if(car.getName().contains(name)){
                this.cars.remove(car);
            }
        }
        return "Successful removed";
    }

    @Override
    public List<Car> getAll() {
        return this.cars;
    }

    @Override
    public List<Car> findByName(String name, List<Car> cars) {
        List<Car>cars1= new LinkedList<>();
            for (Car car : this.cars) {
                if(car.getName().equals(name)){
                    cars.add(car);
                }
            }
        return cars;
    }

    @Override
    public List<Car> findByCountry(String name, List<Car> cars) {
        List<Car>cars1=new LinkedList<>();
        for (Car car : cars) {
            if(car.getName().equals(name)){
            cars1.add(car);

            }
        }return cars;


    }

}
