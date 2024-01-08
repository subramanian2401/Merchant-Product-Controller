package org.jsp.mechant_product.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@NamedQueries(value= {
		@NamedQuery(name="findbyphoneandpassword",query="select m from Merchant m where m.phone=?1 and m.password=?2"),
		@NamedQuery(name="findbyemailandpassword",query="select m from Merchant m where m.email=?1 and m.password=?2"),
        @NamedQuery(name="findproductsbymerchantID",query="select m.product from Merchant m where m.id=?1")
})

@Entity
public class Merchant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(unique=true,nullable=false)
	private long phone;
	@Column(unique=true,nullable=false)
	private String email;
	@Column(nullable=false)
	private String gst;
	@Column(nullable=false)
	private String password;
	@OneToMany(mappedBy = "merchant")
	private List<Product> product;
	
	
	public int getId() {
		return id;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
