package org.example.tax_calculator.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import java.io.Serializable;

@Entity
@Table(name="bill")
public class Bill implements Serializable {

private static final long serialVersionUID = 1L;
	
	@SequenceGenerator(name="billSequence", allocationSize=1, initialValue =1, sequenceName="bill_sequence")
	
	@Id
	@GeneratedValue(generator="billSequence")
	private long id;
	private String name;
	private String tax_code;
	private Long price;
	
	@Column(name="id")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="tax_code")
	public String getTax_code() {
		return tax_code;
	}
	
	public void setTax_code(String tax_code) {
		this.tax_code = tax_code;
	}
	
	@Column(name="price")
	public Long getPrice() {
		return price;
	}
	
	public void setPrice(Long price) {
		this.price = price;
	}	
}
