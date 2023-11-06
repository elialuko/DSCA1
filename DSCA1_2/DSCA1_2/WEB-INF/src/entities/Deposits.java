package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "deposits")
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
	@XmlElement
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@XmlElement
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@XmlElement
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
