package Rental;

import Car.CarManagementSystem;
import Car.ElectricCar;
import Person.Customer;
import Person.PersonManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RentalTest {

    @Test
    void testElapsedDays(){
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();
        PersonManager personManager = new PersonManager();
        Customer customer = new Customer(personManager);
        ElectricCar electricCar = new ElectricCar(carManagementSystem);
        ElectricRental rental1 = new ElectricRental(rentalManager, carManagementSystem, customer.getCustomerID(), electricCar);

        long days = rental1.calculateElapsedDays();

        assertEquals(365, days);
    }

    @Test
    void testSetOdometerAfter(){
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();
        PersonManager personManager = new PersonManager();
        Customer customer = new Customer(personManager);
        ElectricCar electricCar = new ElectricCar(carManagementSystem);
        ElectricRental rental1 = new ElectricRental(rentalManager, carManagementSystem, customer.getCustomerID(), electricCar);

        rental1.setOdometerAfter();
        long odometer = rental1.getOdometerAfter();
        assertEquals(291319, odometer);
    }


}