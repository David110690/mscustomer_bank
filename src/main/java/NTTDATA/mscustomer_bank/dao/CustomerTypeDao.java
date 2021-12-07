package NTTDATA.mscustomer_bank.dao;

import NTTDATA.mscustomer_bank.documents.CustomerType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CustomerTypeDao extends ReactiveMongoRepository<CustomerType, String> {
}
