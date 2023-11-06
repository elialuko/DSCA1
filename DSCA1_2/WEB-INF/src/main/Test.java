package main;

import java.util.ArrayList;
import java.util.List;

import dao.CustomerDOA;
import dao.LoansDAO;
import dao.DepositsDAO;
import entities.Customer;
import entities.Loans;
import entities.Deposits;

public class Test {
	
	
	public Test() {
		CustomerDOA cDAO = new CustomerDOA();
		LoansDAO lDAO = new LoansDAO();
		DepositsDAO dDAO = new DepositsDAO();
		//Add Customer
		Customer customer = new Customer("Elijah", "5555", "123 Rd", 100000000);
		cDAO.persist(customer);
		//AddDepostis
		Deposits deposits = new Deposits("10th", 1000);
		dDAO.persist(deposits);
		//Add Loans
		Loans loans = new Loans("Desc", 100);
		lDAO.persist(loans);
		
		ArrayList<Customer> customers = (ArrayList<Customer>) cDAO.getAllCustomers();
		for(Customer c : customers) {
			System.out.println("Customer name is "+c.getName());
			System.out.println("Customers address is "+ c.getAddress());
			System.out.println("Customers balance is "+ c.getAnn_sal());
		}
		
	}
	
	public static void main(String[] args) {
		new Test();
	}

}
