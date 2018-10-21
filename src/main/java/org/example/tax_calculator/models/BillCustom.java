package org.example.tax_calculator.models;

public class BillCustom {

	private String name;
	private String tax_code;
	private Long price;
	private String type;
	private String refundable;
	private Double tax;
	private Double amount;
	
	public BillCustom() {}
	
	public BillCustom(String name, String tax_code, Long price, String type, String refundable, Double tax, Double amount) {
		this.name = name;
		this.tax_code = tax_code;
		this.price = price; 
		this.type = type;
		this.refundable = refundable;
		this.tax = tax;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTax_code() {
		return tax_code;
	}
	
	public void setTax_code(String tax_code) {
		this.tax_code = tax_code;
	}
	
	public Long getPrice() {
		return price;
	}
	
	public void setPrice(Long price) {
		this.price = price;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getRefundable() {
		return refundable;
	}
	
	public void setRefundable(String refundable) {
		this.refundable = refundable;
	}
	
	public Double getTax() {
		return tax;
	}
	
	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
