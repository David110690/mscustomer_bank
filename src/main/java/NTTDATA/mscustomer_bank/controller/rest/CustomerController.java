package NTTDATA.mscustomer_bank.controller.rest;

import NTTDATA.mscustomer_bank.service.ICustomerService;
import NTTDATA.mscustomer_bank.entity.Customer;
import NTTDATA.mscustomer_bank.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService iCustomerService;

    @GetMapping("/name/{name}")
    public Mono<Customer> findByName(@PathVariable String name){
        return iCustomerService.findByName(name);
    }

    @GetMapping("/number/{number}")
    public Mono<Customer> findByCustomerIdNumber(@PathVariable String number){
        return iCustomerService.findByCustomerIdNumber(number);
    }

    @PostMapping
    public Mono<Customer> save(@RequestBody Customer customer){
        return iCustomerService.save(customer);
    }
}
