package org.jsp.mechant_product.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.mechant_product.dto.Merchant;
import org.jsp.mechant_product.dto.Product;

public class Productdao {
	
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	
	public Product save(Product product,int id) {
		Merchant m=manager.find(Merchant.class, id);
		if(m!=null) {
			EntityTransaction transaction=manager.getTransaction();
			m.getProduct().add(product);
			product.setMerchant(m);
			manager.persist(product);
			transaction.begin();
			transaction.commit();
			return product;
			}
		return null;
		
	}
	
	public Product update(Product product,int id) {
		Product p=manager.find(Product.class, id);
		if(p!=null) {
			EntityTransaction transaction=manager.getTransaction();
			p.setBrand(product.getBrand());
			p.setName(product.getName());
			p.setCategory(product.getCategory());
			p.setDescription(product.getDescription());
			p.setCost(product.getCost());
			p.setImg_url(product.getImg_url());
			manager.persist(p);
			transaction.begin();
			transaction.commit();
			return p;
			
		}
		
		return null;
		
	}
	@SuppressWarnings("unchecked")
	public List<Product> findproductsbymerchantID(int id) {
		Query q=manager.createNamedQuery("findproductsbymerchantID");
		q.setParameter(1, id);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findproductbybrand(String brand){
		Query q=manager.createNamedQuery("findproductbybrand");
		q.setParameter(1,brand);
		return q.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> filterproductbycost(double max,double min){
		Query q=manager.createNamedQuery("filterproductbycost");
		q.setParameter(1,min);
		q.setParameter(2, max);
		return q.getResultList();
	}
	
	public boolean delete(int id) {
		EntityTransaction transaction=manager.getTransaction();
		Product p=manager.find(Product.class, id);
		manager.remove(p);
		transaction.begin();
		transaction.commit();
		if(p!=null) {
			return true;
		}else {
			return false;
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<Product> findproductbycategory(String category) {
		Query q=manager.createNamedQuery("findproductbycategory");
		q.setParameter(1,category);
		return q.getResultList();
	}


}
