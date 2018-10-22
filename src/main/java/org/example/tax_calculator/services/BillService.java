package org.example.tax_calculator.services;

import org.example.tax_calculator.models.Bill;
import org.example.tax_calculator.models.BillCustom;

import java.util.Collection;

public interface BillService {
	
	//Get bills
	public Collection<BillCustom> getBills();
	
	//Get bill by id
	public BillCustom getBillById(Long id);
	
	//Add bill
	public String addBill(Bill bill);
	
	//Update bill
	public String updateBill(Long id, Bill bill);
	
	//Delete bill
	public String deleteBill(Long id);
}