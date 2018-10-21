package org.example.tax_calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import org.example.tax_calculator.models.Bill;

@Repository
public interface BillRepo extends JpaRepository<Bill, Long>{
	
}
