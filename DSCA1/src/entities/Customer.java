package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name, number, address;
	private double ann_sal;

	
	public Customer( String name, String number, String address, double ann_sal) {
		this.name = name;
		this.number = number;
		this.address = address;
		this.ann_sal = ann_sal;
	}

	public Customer() {
		
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAnn_sal() {
		return ann_sal;
	}

	public void setAnn_sal(double ann_sal) {
		this.ann_sal = ann_sal;
	}
	
	
}
