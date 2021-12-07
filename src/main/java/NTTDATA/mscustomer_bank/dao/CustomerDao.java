package NTTDATA.mscustomer_bank.dao;

import NTTDATA.mscustomer_bank.documents.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CustomerDao extends ReactiveMongoRepository<Customer, String>{

}
