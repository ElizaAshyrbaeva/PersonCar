import java8.classes.Car;
import java8.classes.Person;
import java8.enams.Colour;
import java8.enams.Country;
import java8.enams.Gender;
import java8.service.impl.CarImpl;
import java8.service.impl.PersonImpl;

import java.io.StringReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Lexus", "Lexus", new BigDecimal(10000), Year.of(2022), Colour.BLACK, Country.GERMANY);
        Car car1 = new Car("Camry", "Toyota", new BigDecimal(15000), Year.of(2020), Colour.WHITE, Country.KOREA);
        Car car2 = new Car("Audi", "Audi", new BigDecimal(50000), Year.of(2018), Colour.RED, Country.ARMENIA);
        ArrayList<Car> cars = new ArrayList<>(Arrays.asList(car, car1, car2));

        Person person = new Person("Eliza", LocalDate.of(2004, 1, 30), Gender.FEMALE, new BigDecimal(10000000), "+996225171735", List.of(car1));
        Person person1 = new Person("Alibek", LocalDate.of(2002, 3, 2), Gender.MALE, new BigDecimal(1200000000), "+9962251717350", List.of());
        Person person2 = new Person("Nuriza", LocalDate.of(2003, 2, 6), Gender.FEMALE, new BigDecimal(13000000), "+996226172734", List.of());
        List<Person> persons = new ArrayList<>(Arrays.asList(person, person1, person2));
        System.out.println("""
                   1. Create People
                   2. Get All People
                   3. Remove person
                   4. Find by name
                   5. Find by car name
                   6. Pay Car
                   7. Sort By DateOfBirth
                   8. Sort by name
                   9. Sort by Gender
                   10. Show person age
                   11. Create Car
                   12. Remove Car
                   13. Get All
                   14. Find By name
                   15. Find by country
                """);
        PersonImpl persons1 = new PersonImpl();
        CarImpl cars1 = new CarImpl();
        while (true) {
            int number = new Scanner(System.in).nextInt();
            switch (number) {
                case 1 -> System.out.println(persons1.createPerson(persons));
                case 2 -> System.out.println(persons1.getAll());
                case 3 -> {
                    System.out.println("Write the person name : ");
                    System.out.println(persons1.removePerson(new Scanner(System.in).nextLine(), persons));
                }
                case 4 -> {
                    System.out.println("Write the person name :");
                    System.out.println(persons1.findByName(new Scanner(System.in).nextLine(), persons));
                }
                case 5 -> {
                    System.out.print("Write the person's car name : ");
                    System.out.println(persons1.findByCarName(new Scanner(System.in).nextLine(), persons));
                }
                case 6 -> {
                    System.out.print("Write the person name : ");
                    String pmName= new  Scanner(System.in).nextLine();
                    System.out.println("Write the car name :");
                    String carName= new Scanner(System.in).nextLine();
                    System.out.println(persons1.payCars(pmName, persons, carName, cars1.getAll()));
                }
                case 7 -> System.out.println(persons1.sortPersonDateOfBirth(persons));
                case 8 -> System.out.println(persons1.sortPersonName(persons));
                case 9 -> System.out.println(persons1.sortGender(persons));
                case 10 -> {
                    System.out.print("Write the person name : ");
                    String name = new Scanner(System.in).nextLine();
                    for (Person person3 : persons)
                        if (person3.getName().equals(name))
                            System.out.println(person3.getName() +
                                    " is " + persons1.getAge(person) + " years old.");
                }
                case 11 -> System.out.println(cars1.createCar(cars));
                case 12 -> {
                    System.out.println("Write the car name : ");
                    System.out.println(cars1.removeCar(new Scanner(System.in).nextLine(), cars));
                }
                case 13 -> System.out.println(cars1.getAll());
                case 14 -> {
                    System.out.println("Write the car name :");
                    System.out.println(cars1.findByName(new Scanner(System.in).nextLine(), cars));
                }
                case 15 -> {
                    System.out.println("Write  the country : ");
                    System.out.println(cars1.findByCountry(new Scanner(System.in).nextLine(), cars));
                }
                default -> System.err.println("The End");
            }
        }
    }
}