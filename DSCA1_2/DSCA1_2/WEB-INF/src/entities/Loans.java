package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "loans")
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
	@XmlElement
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	@XmlElement
	public double getLoan_amount() {
		return loan_amount;
	}

	public void setLoan_amount(double loan_amount) {
		this.loan_amount = loan_amount;
	}
	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	
}