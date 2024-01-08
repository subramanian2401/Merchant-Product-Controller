package org.jsp.mechant_product.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.mechant_product.dto.Merchant;

public class Merchantdao {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	public Merchant savemerchat(Merchant merchant) {
		EntityTransaction transaction=manager.getTransaction();
		manager.persist(merchant);
		transaction.begin();
		transaction.commit();
		return merchant;
		
	}
	
	public Merchant updatemerchant(Merchant merchant,int id) {
		Merchant update=manager.find(Merchant.class, id);
		
		if(update!=null) {
			update.setName(merchant.getName());
			update.setEmail(merchant.getEmail());
			update.setGst(merchant.getGst());
			update.setPhone(merchant.getPhone());
			update.setPassword(merchant.getPassword());
			EntityTransaction transaction =manager.getTransaction();
			manager.persist(update);
			transaction.begin();
			transaction.commit();
			return update;
		}
		return null;
	}
	
	public Merchant findbyid(int id) {
		Merchant m=manager.find(Merchant.class, id);
		return m;
	}
	
	public Merchant verifybyphoneandpassword(long phone,String password) {
		Query q=manager.createNamedQuery("findbyphoneandpassword");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (Merchant) q.getSingleResult();
			
		}catch(NoResultException e) {
			System.out.println("Invalid Phone or password");
			return null;
		}
	}
	
	public Merchant verifybyemailandpassword(String email,String password) {
		Query q=manager.createNamedQuery("findbyemailandpassword");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
		   return (Merchant) q.getSingleResult();
			
		}catch(NoResultException e) {
			System.out.println("Invalid Phone or password");
			return null;
		}
	}

}
