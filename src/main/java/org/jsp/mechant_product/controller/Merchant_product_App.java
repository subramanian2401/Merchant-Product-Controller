package org.jsp.mechant_product.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.mechant_product.dao.Merchantdao;
import org.jsp.mechant_product.dao.Productdao;
import org.jsp.mechant_product.dto.Merchant;
import org.jsp.mechant_product.dto.Product;

public class Merchant_product_App {
	static Merchantdao mdao=new Merchantdao();
	static Productdao pdao=new Productdao();
	static Scanner in=new Scanner(System.in);
	static boolean flag=true;
	public static void main(String[] args) {


		while(flag) {
			System.out.println("Merchant Product Application");
			System.out.println("-------MENU--------");
			System.out.println("1) save \n"
					+ "2) Update \n"
					+ "3) Find Merchant by Id \n"
					+ "4) Find By Phone number And Password \n"
					+ "5) Find By Email ID And Password \n"
					+ "6) Save Product With Merchant ID \n"
					+ "7) Updating Product \n"
					+ "8) Find Products by Merchant id \n"
					+ "9) Fetch Products By Brand \n"
					+ "10 Fetch Products By Category \n"
					+ "11)Delete Product \n"
					+ "12)Filter Product by Cost \n"
					+ "13)Exit");
			System.out.println("Enter your Choice");
			int choice=in.nextInt();


			switch(choice) {
			case 1:
			{
				saveMerchant();
				break;
			}
			case 2:{
				updateMerchant();
				break;
			}
			case 3:{
				findmerchantbyid();
				break;
			}

			case 4:
			{
				findmerchantbyphone();
				break;
			}
			case 5:
			{
				verifybyemailandpassword();
				break;
			}
			case 6:{
				saveproduct();
				break;	
			}
			case 7:
			{
				updateproduct();
				break;
			}
			case 8:
			{
				fetchproductbymerchantid();
				break;
			}
			case 9:
			{
				findproductbybrand();
				break;
			}
			case 10:{
				findproductbycategory();
				break;
			}
			case 11:
			{
				delete();
				break;
			}
			case 12:{
				filterproductbycost();
				break;
			}
			case 13:{
				exit();
				break;
			}
			default:{
				System.err.println("INVALID OPTION");
			}
			}
		}
	}









































	//static Methods


	public static void saveMerchant() {
		Merchant m=new Merchant();
		System.out.println("Enter the Merchant name: ");
		m.setName(in.next());
		System.out.println("Enter the Phone number: ");
		m.setPhone(in.nextLong());
		System.out.println("Enter the Email ID: ");
		m.setEmail(in.next());
		System.out.println("Enter the password");
		m.setPassword(in.next());
		System.out.println("Enter the Merchant Gst number");
		m.setGst(in.next());
		m=mdao.savemerchat(m);
		if(m!=null) {
			System.out.println("Merchant saved with the Id: "+m.getId());
		}
		else {
			System.err.println("Merchant not saved");
		}


	}

	private static void updateMerchant() {
		Merchant m=new Merchant();
		System.out.println("Enter the Merchant Id to Update the Merchant:");
		int id=in.nextInt();
		System.out.println("Enter the Merchant name: ");
		m.setName(in.next());
		System.out.println("Enter the Phone number: ");
		m.setPhone(in.nextLong());
		System.out.println("Enter the Email ID: ");
		m.setEmail(in.next());
		System.out.println("Enter the password");
		m.setPassword(in.next());
		System.out.println("Enter the Merchant Gst number");
		m.setGst(in.next());
		m=mdao.updatemerchant(m,id);
		if(m!=null) {
			System.out.println("Merchant Updated with the Id: "+m.getId());
		}
		else {
			System.err.println("Merchant not saved");
		}		
	}


	private static void findmerchantbyid() {
		System.out.println("Find Merchant By ID: ");
		System.out.println("Enter the merchant id to fetch the Details:");
		int id=in.nextInt();
		Merchant m=mdao.findbyid(id);

		if(m!=null) {
			System.out.println("Merchant name: "+m.getName());
			System.out.println("Merchant Phone number: "+m.getPhone());
			System.out.println(" Email id: "+m.getEmail());
			System.out.println("Password: "+m.getPassword());
			System.out.println("GST_Number: "+m.getGst());
		}else {
			System.out.println("Invalid Id");
		}		
	}

	private static void findmerchantbyphone() {
		System.out.println("Enter the Merchant Phone number: ");
		long phone=in.nextLong();
		System.out.println("Enter the Merchant password:");
		String password=in.next();
		Merchant m=mdao.verifybyphoneandpassword(phone, password);
		if(m!=null) {
			System.out.println("Merchant name: "+m.getName());
			System.out.println("Merchant Phone number: "+m.getPhone());
			System.out.println(" Email id: "+m.getEmail());
			System.out.println("Password: "+m.getPassword());
			System.out.println("GST_Number: "+m.getGst());
		}		
	}

	private static void verifybyemailandpassword() {
		System.out.println("Enter the Merchant Email ID: ");
		String email=in.next();
		System.out.println("Enter the Merchant password:");
		String password=in.next();
		Merchant m=mdao.verifybyemailandpassword(email, password);
		if(m!=null) {
			System.out.println("Merchant name: "+m.getName());
			System.out.println("Merchant Phone number: "+m.getPhone());
			System.out.println(" Email id: "+m.getEmail());
			System.out.println("Password: "+m.getPassword());
			System.out.println("GST_Number: "+m.getGst());

		}		
	}

	private static void saveproduct() {
		System.out.println("Enter the Merchant ID to save the Products");
		int id=in.nextInt();
		Product p=new Product();
		System.out.println("Enter the Product name: ");
		p.setName(in.next());
		System.out.println("Enter the Brand: ");
		p.setBrand(in.next());
		System.out.println("Enter the Cost of the PRoduct");
		p.setCost(in.nextDouble());
		System.out.println("Enter the Category: ");
		p.setCategory(in.next());
		System.out.println("Enter the Description");
		p.setDescription(in.next());
		System.out.println("enter the Image URL");
		p.setImg_url(in.next());
		p=pdao.save(p, id);
		if(p!=null) {
			System.out.println("Product saved with the ID: "+p.getId());
		}else {
			System.err.println("Invalid Merchant ID");
		}

	}


	private static void updateproduct() {
		System.out.println("Updating Product");
		Product p=new Product();
		System.out.println("Enter the Product Id to Update ");
		int id=in.nextInt();
		System.out.println("Enter the Product name: ");
		p.setName(in.next());
		System.out.println("Enter the Brand: ");
		p.setBrand(in.next());
		System.out.println("Enter the Cost of the PRoduct");
		p.setCost(in.nextDouble());
		System.out.println("Enter the Category: ");
		p.setCategory(in.next());
		System.out.println("Enter the Description");
		p.setDescription(in.next());
		System.out.println("enter the Image URL");
		p.setImg_url(in.next());
		p=pdao.update(p, id);

		if(p!=null) {
			System.out.println("Product Updated with the Id: "+p.getId());
		}else {
			System.err.println("ID Not Found");
		}		
	}
	private static void fetchproductbymerchantid() {
		System.out.println("Enter the Merchant id to Fetch the Product");
		int id=in.nextInt();
		List<Product> l1=pdao.findproductsbymerchantID(id);
		if(l1.size()>0) {
			for(Product p:l1) {
				System.out.println("Name:"+p.getName());
				System.out.println("Brand"+p.getBrand());
				System.out.println("Category:"+p.getCategory());
				System.out.println("Cost: "+p.getCost());
				System.out.println("Description: "+p.getDescription());
				System.out.println("Image url: "+p.getImg_url());
				System.out.println("--------------------");
			}}else {
				System.err.println("Merchant Id Not Available");
			}		
	}

	private static void findproductbybrand() {
		System.out.println("Enter the brand to Fetch the Product Details");
		String brand=in.next();
		List<Product> l1=pdao.findproductbybrand(brand);
		if(l1.size()>0) {
			for(Product p:l1) {
				System.out.println("Name:"+p.getName());
				System.out.println("Brand: "+p.getBrand());
				System.out.println("Category:"+p.getCategory());
				System.out.println("Cost: "+p.getCost());
				System.out.println("Description: "+p.getDescription());
				System.out.println("Image url: "+p.getImg_url());
				System.out.println("--------------------");
			}}else {
				System.err.println("Brand Not Found");
			}		
	}
	public static void findproductbycategory() {
		System.out.println("Enter the Category to Fetch the Product Details");
		System.out.println("-----Accepting String-----");
		String category=in.next();
		List<Product> l1=pdao.findproductbycategory(category);
		if(l1.size()>0) {
			for(Product p:l1) {
				System.out.println("Name:"+p.getName());
				System.out.println("Brand: "+p.getBrand());
				System.out.println("Category:"+p.getCategory());
				System.out.println("Cost: "+p.getCost());
				System.out.println("Description: "+p.getDescription());
				System.out.println("Image url: "+p.getImg_url());
				System.out.println("--------------------");
			}}else {
				System.err.println("Brand Not Found");
			}		

	}
	public static void delete() {
		System.out.println("Enter the Product Id to Delete the Product");
		int id=in.nextInt();
		boolean p=pdao.delete(id);
		if(p) {
			System.out.println("Product Sucessfully Deleted");
		}else {
			System.out.println("Product Not Deleted");
		}


	}

	private static void filterproductbycost() {
		System.out.println("Enter the Minimum Cost: ");
		double min=in.nextDouble();
		System.out.println("Enter the Maximum Cost: ");
		double max=in.nextDouble();
		List<Product> l1=pdao.filterproductbycost(max, min);
		if(l1.size()>0) {
			for(Product p:l1) {
				System.out.println("Name:"+p.getName());
				System.out.println("Brand: "+p.getBrand());
				System.out.println("Category:"+p.getCategory());
				System.out.println("Cost: "+p.getCost());
				System.out.println("Description: "+p.getDescription());
				System.out.println("Image url: "+p.getImg_url());
				System.out.println("--------------------");
			}}else {
				System.err.println("No Products Available At That Price Range");
			}		
	}


	public static void exit() {
		System.err.println("Thank you Visit Again");
		flag=false;		
	}

}
