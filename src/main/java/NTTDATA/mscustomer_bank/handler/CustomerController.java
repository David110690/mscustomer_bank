package NTTDATA.mscustomer_bank.handler;

import NTTDATA.mscustomer_bank.documents.Customer;
import NTTDATA.mscustomer_bank.documents.CustomerType;
import NTTDATA.mscustomer_bank.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public Flux<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> findById(@PathVariable String id){
        return customerService.findById(id);
    }

    @PostMapping
    public Mono<Customer> save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

   /* @DeleteMapping("/{id}")
    public Mono<Void> delete(@RequestBody Customer customer){
        return customerService.delete(customer);
    }*/

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> eliminar(@PathVariable String id){
        return customerService.findById(id).flatMap(p ->{
            return customerService.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }

    /*@PutMapping("/{id}")
    public Mono<Customer> save(@RequestBody Customer customer, @PathVariable String id) {
        return customerService.save(customer);
    }*/

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Customer>> editarCustomer(@RequestBody Customer customer, @PathVariable String id){
        return customerService.findById(id).flatMap(p -> {
                    p.setName(customer.getName());
                    p.setLastname(customer.getLastname());
                    p.setDni(customer.getDni());
                    p.setEmail(customer.getEmail());
                    p.setPhone(customer.getPhone());
                    p.setAddress(customer.getAddress());
                    p.setCustomerType(customer.getCustomerType());
                    return customerService.save(p);
                }).map(p->ResponseEntity.created(URI.create("/api/customers".concat(p.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("customerType")
    public Flux<CustomerType> findAllCustomerType(){
        return customerService.findAllCustomerType();
    }

    @GetMapping("customerType/{id}")
    public Mono<CustomerType> findByIdCustomerType(@PathVariable String id){
        return customerService.findByIdCustomerType(id);
    }

    @PostMapping("customerType")
    public Mono<CustomerType> saveCustomerType(@RequestBody CustomerType customerType){
        return customerService.saveCustomerType(customerType);
    }

    @DeleteMapping("customerType/{id}")
    public Mono<ResponseEntity<Void>> eliminarCustomerType(@PathVariable String id){
        return customerService.findByIdCustomerType(id).flatMap(p ->{
            return customerService.deleteCustomerType(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }

    /*@PutMapping("customerType/{id}")
    public Mono<CustomerType> saveCustomerType(@RequestBody CustomerType customerType, @PathVariable String id) {
        return customerService.saveCustomerType(customerType);
    }*/

    @PutMapping("customerType/{id}")
    public Mono<ResponseEntity<CustomerType>> editar(@RequestBody CustomerType customerType, @PathVariable String id){
        return customerService.findByIdCustomerType(id).flatMap(p -> {
                    p.setType(customerType.getType());
                    return customerService.saveCustomerType(p);
                }).map(p->ResponseEntity.created(URI.create("/api/customers/customerType".concat(p.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
