package NTTDATA.mscustomer_bank.repository;

import NTTDATA.mscustomer_bank.entity.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
//import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ICustomerRepository extends ReactiveMongoRepository<Customer, String> {
    Mono<Customer> findByName(String name);
    Mono<Customer> findByCustomerIdNumber(String customerIdNumber);
}
