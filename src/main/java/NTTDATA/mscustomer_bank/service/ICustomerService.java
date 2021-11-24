package NTTDATA.mscustomer_bank.service;

import NTTDATA.mscustomer_bank.entity.Customer;
import reactor.core.publisher.Mono;

public interface ICustomerService {
    Mono<Customer> findByName(String name);
    Mono<Customer> findByCustomerIdNumber(String customerIdNumber);
    Mono<Customer> save(Customer customer);
}
