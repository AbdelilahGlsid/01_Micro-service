package abdelilah.bouhkka.bank_account_service.repositories;

import abdelilah.bouhkka.bank_account_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long > {
}
