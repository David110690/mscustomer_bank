package NTTDATA.mscustomer_bank.services;

import NTTDATA.mscustomer_bank.dao.CustomerDao;
import NTTDATA.mscustomer_bank.dao.CustomerTypeDao;
import NTTDATA.mscustomer_bank.documents.Customer;
import NTTDATA.mscustomer_bank.documents.CustomerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao dao;

    @Autowired
    private CustomerTypeDao customerTypeDao;

    @Override
    public Flux<Customer> findAll() {
        return dao.findAll();
    }

    @Override
    public Mono<Customer> findById(String id) {
        return dao.findById(id);
    }

    @Override
    public Mono<Customer> save(Customer customer) {
        return dao.save(customer);
    }

    @Override
    public Mono<Void> delete(Customer customer) {
        return dao.delete(customer);
    }

    @Override
    public Flux<CustomerType> findAllCustomerType() {
        return customerTypeDao.findAll();
    }

    @Override
    public Mono<CustomerType> findByIdCustomerType(String id) {
        return customerTypeDao.findById(id);
    }

    @Override
    public Mono<CustomerType> saveCustomerType(CustomerType customerType) {
        return customerTypeDao.save(customerType);
    }

    @Override
    public Mono<Void> deleteCustomerType(CustomerType customerType) {
        return customerTypeDao.delete(customerType);
    }
}
