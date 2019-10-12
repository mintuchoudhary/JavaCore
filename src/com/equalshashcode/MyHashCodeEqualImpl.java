package com.equalshashcode;

import java.util.HashMap;

/*
 * output:
 * 
 * In hashcode
 * In hashcode
 * In hashcode
 * In hashcode
 * {item: Muskmelon  price: 120=80, item: Watermelon  price: 80=80, item: Stawberry  price: 120=120, item: PineApple  price: 50=50}
 * In hashcode
 * In equals
 * 80
 * */
public class MyHashCodeEqualImpl {
	public static void main(String args[]) {
		HashMap<Product, String> hm = new HashMap<Product, String>();
		hm.put(new Product("PineApple",50), "50");
		hm.put(new Product("Watermelon",80), "80");
		hm.put(new Product("Stawbery",120), "120");
		hm.put(new Product("Muskmelon",120), "90");
		System.out.println(hm);
		Product searchProduct = new Product("Watermelon",80);
		System.out.println(hm.get(searchProduct));
	}
}

class Product {
	private String item;
	private int price;

	public Product(String item, int price) {
		this.item = item;
		this.price = price;
	}

	@Override
	public int hashCode() {
		System.out.println("In hashcode");
		int hashcode = 0;
		hashcode = price * 20;
		hashcode += item.hashCode();
	//Simplest way: To use all variables and create a sum of all hashcode e.g return price+item.hashCode();
		return hashcode;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("In equals");
		if (obj instanceof Product) {
			Product prodObj = (Product) obj;
			return (prodObj.item.equals(this.item) && prodObj.price == this.price);
		} else {
			return false;
		}

	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String toString() {
		return "item: " + item + "  price: " + price;
	}
}
