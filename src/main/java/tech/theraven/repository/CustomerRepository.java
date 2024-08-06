package tech.theraven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.theraven.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
