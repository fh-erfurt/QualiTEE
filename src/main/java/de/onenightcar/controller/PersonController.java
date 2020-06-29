package de.onenightcar.controller;

import de.onenightcar.model.person.PaymentMethod;
import de.onenightcar.repositories.personRepository.*;
import de.onenightcar.repositories.rentalRepository.ElectricRentalRepository;
import de.onenightcar.repositories.rentalRepository.FuelRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/person") // This means URL's start with /person (after Application path)
public class PersonController {
    @Autowired      // This means to get the bean called paymentMethodRepository
                    // Which is auto-generated by Spring, we will use it to handle the data

    private final PaymentMethodRepository paymentMethodRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final PersonAddressRepository personAddressRepository;
    private final AdminRepository adminRepository;
    private final FuelRentalRepository fuelRentalRepository;
    private final ElectricRentalRepository electricRentalRepository;

    public PersonController(PaymentMethodRepository paymentMethodRepository, CustomerRepository customerRepository, EmployeeRepository employeeRepository, PersonAddressRepository personAddressRepository, AdminRepository adminRepository, FuelRentalRepository fuelRentalRepository, ElectricRentalRepository electricRentalRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.personAddressRepository = personAddressRepository;
        this.adminRepository = adminRepository;
        this.fuelRentalRepository = fuelRentalRepository;
        this.electricRentalRepository = electricRentalRepository;
    }

    @PostMapping(path="/paymentMethod") // Map ONLY POST Requests
    public @ResponseBody String addNewPaymentMethod (@RequestParam String cardNumber, @RequestParam String ccv) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        PaymentMethod pm = new PaymentMethod();
        pm.setCardNumber(cardNumber);
        pm.setCCV(ccv);
        paymentMethodRepository.save(pm);
        return "Saved";
    }

    @GetMapping(path = "/paymentMethods")
    public String getPaymentMethods(Model model) {

        model.addAttribute("paymentMethods", paymentMethodRepository.findAll());

        return "person/paymentMethods";
    }

    @GetMapping(path = "/customers")
    public String getAllCustomers(Model model) {

        model.addAttribute("customers", customerRepository.findAll());

        return "person/customers";
    }

    @RequestMapping(path = "/customer/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getCustomerWithID(Model model, @PathVariable("id") Long id) {

        model.addAttribute("customer", customerRepository.getById(id));
        model.addAttribute("fuelRentals", fuelRentalRepository.getAllByCustomer(customerRepository.getById(id)));
        model.addAttribute("electricRentals", electricRentalRepository.getAllByCustomer(customerRepository.getById(id)));

        return "person/singleCustomer";
    }

}
