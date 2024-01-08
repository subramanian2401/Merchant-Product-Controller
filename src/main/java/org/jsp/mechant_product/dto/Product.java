package org.jsp.mechant_product.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries(value= {
		@NamedQuery(name="findproductbybrand",query="select p from Product p where p.brand=?1"),
		@NamedQuery(name="findproductbycategory",query="select p from Product p where p.category=?1"),
		@NamedQuery(name="filterproductbycost",query="select p from Product p where p.cost between ?1 and ?2")
})
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String brand;
	@Column(nullable=false)
	private String category;
	@Column(nullable=false)
	private String description;
	@Column(nullable=false)
	private double cost;
	@Column(nullable=false)
	private String img_url;
	@ManyToOne
	@JoinColumn(name="merchant_id")
	private Merchant merchant;
	
	
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
}
