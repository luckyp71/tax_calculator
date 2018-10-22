package org.example.tax_calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Collection;

import org.example.tax_calculator.models.Bill;
import org.example.tax_calculator.models.BillCustom;
import org.example.tax_calculator.controlers.BillController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillControllerTest {

	@Autowired
	BillController billController;
	
	@Test
	public void testGetBills() {
		String expectedResult = "00";
		
		ResponseEntity<Collection<BillCustom>> bills = billController.getBills();
		String actualResult = bills.getHeaders().get("response-code").get(0);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testGetBillById() {
		String expectedResult = "00";
		
		//Assume you haven't inserted any data yet into your db, so that we must insert the data first before test the getBillById method,
		// otherwise the response-code value will be 01 (data not found) 
		billController.addBill(new Bill("Chiki", "1", (long) 2000));
		
		ResponseEntity<BillCustom> bill = billController.getBillById((long) 1);
		String actualResult = bill.getHeaders().get("response-code").get(0);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testAddBill() {
		String expectedResult = "00";
		
		ResponseEntity<String> response = billController.addBill(new Bill("Chiki", "1", (long) 3000));
		String actualResult = response.getHeaders().get("response-code").get(0);
		
		assertEquals(expectedResult, actualResult);
	}
	
	
	
	@Test
	public void testUpdateBill() {
		String expectedResult = "00";
		
		ResponseEntity<String> response = billController.updateBill((long) 2, new Bill("Chiki", "1", (long) 5000));
		String actualResult = response.getHeaders().get("response-code").get(0);
		
		assertEquals(expectedResult, actualResult);
	}
	
// Uncomment the method below to test deleteBill method
//	@Test
//	public void testDeleteBill() {
//		String expectedResult = "00";
//		
//		ResponseEntity<String> response = billController.deleteBill((long) 2);
//		String actualResult = response.getHeaders().get("response-code").get(0);
//		
//		assertEquals(expectedResult, actualResult);
//	}
	
}
