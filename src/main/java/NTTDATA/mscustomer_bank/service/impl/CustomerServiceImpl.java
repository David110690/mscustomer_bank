package NTTDATA.mscustomer_bank.service.impl;

import NTTDATA.mscustomer_bank.repository.ICustomerRepository;
import NTTDATA.mscustomer_bank.entity.Customer;
import NTTDATA.mscustomer_bank.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerRepository repository;

    @Override
    public Mono<Customer> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Mono<Customer> findByCustomerIdNumber(String customerIdNumber) {
        return repository.findByCustomerIdNumber(customerIdNumber);
    }

    @Override
    public Mono<Customer> save(Customer customer) {
        return repository.save(customer);
    }
}
