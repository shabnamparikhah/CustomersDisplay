package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface CustomersRepository extends CrudRepository<Customer,Long>{
    /*Customer findById(Long id);*/
    ArrayList<Customer> findByLastName(String lastName);

}
