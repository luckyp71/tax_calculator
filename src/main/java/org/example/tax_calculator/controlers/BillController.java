package org.example.tax_calculator.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;

import org.example.tax_calculator.models.Bill;
import org.example.tax_calculator.models.BillCustom;
import org.example.tax_calculator.services_impl.BillServiceImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/bills")
public class BillController {

	@Autowired
	BillServiceImpl billService;

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<BillCustom>> getBills() {
		HttpHeaders headers = new HttpHeaders();
		Collection<BillCustom> bills = billService.getBills();
		headers.add("response-code", "00");
		headers.add("response-desc", "Success");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bills);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BillCustom> getBillById(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		BillCustom bill = billService.getBillById(id);
		if (bill != null) {
			headers.add("response-code", "00");
			headers.add("response-desc", "Success");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bill);
		}
		headers.add("response-code", "01");
		headers.add("response-desc", "Data not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(bill);
	}

	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addBill(@RequestBody Bill bill) {
		HttpHeaders headers = new HttpHeaders();
		String response = billService.addBill(bill);
		if (response.equals("success")) {
			headers.add("response-code", "00");
			headers.add("response-desc", "Success");
			return ResponseEntity.status(HttpStatus.OK).headers(headers)
					.body("{\"Message\":\"Bill inserted successfully\"}");
		}
		headers.add("response-code", "02");
		headers.add("response-desc", "Data already exists");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers)
				.body("{\"Message\":\"Bill with given id is already exists\"}");
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateBill(@PathVariable Long id, @RequestBody Bill bill) {
		HttpHeaders headers = new HttpHeaders();
		String response = billService.updateBill(id, bill);
		if (response.equals("success")) {
			headers.add("response-code", "00");
			headers.add("response-desc", "Success");
			return ResponseEntity.status(HttpStatus.OK).headers(headers)
					.body("{\"Message\":\"Bill updated successfully\"}");
		}
		headers.add("response-code", "01");
		headers.add("response-desc", "Data not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers)
				.body("{\"Message\":\"Bill with given id is not found\"}");
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteBill(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		String response = billService.deleteBill(id);
		if (response.equals("success")) {
			headers.add("response-code", "00");
			headers.add("response-desc", "Success");
			return ResponseEntity.status(HttpStatus.OK).headers(headers)
					.body("{\"Message\":\"Bill deleted successfully\"}");
		}
		headers.add("response-code", "01");
		headers.add("response-desc", "Data not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers)
				.body("{\"Message\":\"Bill with given id is not found\"}");
	}
}
