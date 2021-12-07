package NTTDATA.mscustomer_bank.services;

import NTTDATA.mscustomer_bank.documents.Customer;
import NTTDATA.mscustomer_bank.documents.CustomerType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    public Flux<Customer> findAll();
    public Mono<Customer> findById(String id);
    public Mono<Customer> save(Customer customer);
    public Mono<Void> delete(Customer customer);
    public Flux<CustomerType> findAllCustomerType();
    public Mono<CustomerType> findByIdCustomerType(String id);
    public Mono<CustomerType> saveCustomerType(CustomerType customerType);
    public Mono<Void> deleteCustomerType(CustomerType customerType);

}
