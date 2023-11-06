package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Loans;

public class LoansDAO {

	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("ElijahsPU");
	
	public LoansDAO() {
		
	}
	
	
	public void persist(Loans loans) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(loans);
		em.getTransaction().commit();
		em.close();
		}
	
	public void remove(Loans loans) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(loans));
		em.getTransaction().commit();
		em.close();
	}
	
	public Loans merge(Loans loans) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Loans updatedLoan = em.merge(loans);
		em.getTransaction().commit();
		em.close();
		return updatedLoan;
	}
	
	public List<Loans> getAllLoans() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Loans> loansFromDB = new ArrayList<Loans>();
		loansFromDB = em.createNamedQuery("Loans.findAll").getResultList();
		em.getTransaction().commit();
		em.close();
		return loansFromDB;
	}
	
	
}
