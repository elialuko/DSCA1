package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Deposits;
import entities.Loans;

public class DepositsDAO {

	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("ElijahsPU"); 	
	
	public DepositsDAO() {
		
	}
	
	public void persist(Deposits deposit) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(deposit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Deposits deposit) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(deposit));
		em.getTransaction().commit();
		em.close();
	}
	
	public Deposits merge(Deposits deposit) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Deposits updatedDeposit = em.merge(deposit);
		em.getTransaction().commit();
		em.close();
		return updatedDeposit;
	}
	
	public List<Deposits> getAllDeposits() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Deposits> depositsFromDB = new ArrayList<Deposits>();
		depositsFromDB = em.createNamedQuery("Deposits.findAll").getResultList();
		em.getTransaction().commit();
		em.close();
		return depositsFromDB;
	}
	
}
