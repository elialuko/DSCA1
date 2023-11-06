package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Deposits {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	
	public String date;
	public double amount;
	
	
	public Deposits(String date, double amount) {
		this.date = date;
		this.amount = amount;
	}
	public Deposits() {
		
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
