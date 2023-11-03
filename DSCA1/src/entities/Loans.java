package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loans {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String desc;
	private double loan_amount;
	
	public Loans(String desc, double loan_amount) {
		this.desc = desc;
		this.loan_amount = loan_amount;
	}

	public Loans() {
		
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getLoan_amount() {
		return loan_amount;
	}

	public void setLoan_amount(double loan_amount) {
		this.loan_amount = loan_amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
