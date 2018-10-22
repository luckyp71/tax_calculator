package org.example.tax_calculator.services_impl;

import java.util.Collection;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.tax_calculator.models.Bill;
import org.example.tax_calculator.models.BillCustom;
import org.example.tax_calculator.repository.BillRepo;
import org.example.tax_calculator.services.BillService;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepo billRepo;

	public Double getTax(double rate, Long price) {
		return rate * price;
	}

	public Double getAmount(Long price, double tax) {
		return price + tax;
	}

	@Override
	public Collection<BillCustom> getBills() {
		Collection<Bill> bills = billRepo.findAll();
		Collection<BillCustom> billsCustom = new ArrayList<>();
		double tax = 0;
		for (Bill b : bills) {
			switch (b.getTax_code()) {
			case "1":
				tax = getTax(0.1, b.getPrice());
				billsCustom.add(new BillCustom(b.getName(), b.getTax_code(), b.getPrice(), "Food & Beverage", "Yes",
						tax, getAmount(b.getPrice(), tax)));
				break;
			case "2":
				tax = 10 + (getTax(0.02, b.getPrice()));
				billsCustom.add(new BillCustom(b.getName(), b.getTax_code(), b.getPrice(), "Tobacco", "No", tax,
						getAmount(b.getPrice(), tax)));
				break;
			case "3":
				if (b.getPrice() < 100) {
					tax = 0;
					billsCustom.add(new BillCustom(b.getName(), b.getTax_code(), b.getPrice(), "Entertainment", "No",
							tax, getAmount(b.getPrice(), tax)));
				} else {
					long price = b.getPrice() - 100;
					tax = getTax(0.01, price);
					billsCustom.add(new BillCustom(b.getName(), b.getTax_code(), b.getPrice(), "Entertainment", "No",
							tax, getAmount(b.getPrice(), tax)));
				}
				break;
			}
		}
		
		System.out.println(billsCustom);

		return billsCustom;
	}

	@Override
	public BillCustom getBillById(Long id) {
		
		Bill b = billRepo.findOne(id);
		BillCustom billCustom = null;
		double tax = 0;
		if (b != null) {
			switch (b.getTax_code()) {
			case "1":	
				tax = getTax(0.1, b.getPrice());
				billCustom = new BillCustom(b.getName(), b.getTax_code(), b.getPrice(), "Food & Beverage", "Yes", tax,
						getAmount(b.getPrice(), tax));
				break;
			case "2":
				tax = 10 + (getTax(0.02, b.getPrice()));
				billCustom = new BillCustom(b.getName(), b.getTax_code(), b.getPrice(), "Tobacco", "No", tax,
						getAmount(b.getPrice(), tax));
				break;
			case "3":
				if (b.getPrice() < 100) {
					tax = 0;
					billCustom = new BillCustom(b.getName(), b.getTax_code(), b.getPrice(), "Entertainment", "No", tax,
							getAmount(b.getPrice(), tax));
				} else {
					long price = b.getPrice() - 100;
					tax = getTax(0.01, price);
					billCustom = new BillCustom(b.getName(), b.getTax_code(), b.getPrice(), "Entertainment", "No", tax,
							getAmount(b.getPrice(), tax));
				}
				break;
			}
		} 	
		return billCustom;
	}

	@Override
	public String addBill(Bill bill) {
		String response = "";

		billRepo.save(bill);
		response = "success";

		return response;
	}

	@Override
	public String updateBill(Long id, Bill bill) {
		Bill billRep = billRepo.findOne(id);
		String response = "";
		if (billRep != null) {
			billRep.setName(bill.getName());
			billRep.setPrice(bill.getPrice());
			billRep.setTax_code(bill.getTax_code());
			billRepo.save(billRep);
			response = "success";
		} else {
			response = "error";
		}
		return response;
	}

	@Override
	public String deleteBill(Long id) {
		Bill bill = billRepo.findOne(id);
		String response = "";
		if (bill != null) {
			billRepo.delete(bill);
			response = "success";
		} else {
			response = "error";
		}
		return response;
	}
}
