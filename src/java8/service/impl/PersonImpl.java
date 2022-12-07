package java8.service.impl;

import java8.classes.Car;
import java8.classes.Person;
import java8.service.PersonService;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class PersonImpl implements PersonService {

    List<Person>people=new LinkedList<>();
    List<Car>cars1= new LinkedList<>();
    @Override
    public String createPerson(List<Person> people) {
        this.people.addAll(people);
        return "People are successfully created!";
    }

    @Override
    public String removePerson(String name, List<Person> people) {
        for (Person person : people) {
            if(person.getName().equals(name))
                this.people.remove(person);
        }
        return "Person is successfully removed!";
    }

    @Override
    public List<Person> getAll() {
        return this.people;
    }

    @Override
    public List<Person> findByName(String name, List<Person> people) {
        List<Person> results = new ArrayList<>();
        for (Person person : this.people) {
            if(person.getName().equals(name))
                results.add(person);
        }
        return results;
    }

    @Override
    public List<Person> findByCarName(String name, List<Person> people) {
        List<Person> carName = new ArrayList<>();
        for (Person person : this.people) {
            for (Car car : person.getCars()) {
                if (car.getName().equals(name))
                    carName.add(person);
            }
        }
        return carName;
    }
    @Override
    public String payCars(String name, List<Person> people, String carName, List<Car> cars) {
        for (Person person : people) {
            if(person.getName().contains(name)){
                for (Car car : cars) {
                    if (car.getName().contains(carName)){
                        int n = person.getMoney().subtract(car.getPrice()).intValue();
                        if (n >= 0){
                            if (person.getCars() == null){
                                person.setCars(List.of(car));
                                cars.removeAll(cars);
                                cars1.add(car);
                                cars.remove(car);
                                person.setMoney(person.getMoney().subtract(car.getPrice()));
                            }else {
                                person.setCars(cars1);
                                cars1.add(car);
                                cars.remove(car);
                                person.setMoney(person.getMoney().subtract(car.getPrice()));
                            }
                            return "successfully paid";
                        }else{
                            return "not enough money";
                        }
                    }
                }
            }
        }
        return "car was sell";
    }
    public static Comparator<Person> sortPersonDateOfBirth = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
        }
    };

    public static Comparator<Person> sortPersonName = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    public static Comparator<Person>sortGender = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getGender().name().compareTo(o2.getGender().name());
        }
    };
    @Override
    public List<Person> sortPersonDateOfBirth(List<Person> people) {
        people.sort(sortPersonDateOfBirth);
        return people;
    }

    @Override
    public List<Person> sortPersonName(List<Person> people) {
        people.sort(sortPersonName);
        return people;
    }

    @Override
    public List<Person> sortGender(List<Person> people) {
        people.sort(sortGender);
        return people;
    }

    @Override
    public int getAge(Person person) {
        return Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
    }
}
