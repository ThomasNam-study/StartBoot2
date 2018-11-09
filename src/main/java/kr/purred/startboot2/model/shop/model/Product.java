package kr.purred.startboot2.model.shop.model;

import lombok.Data;

@Data
public class Product
{
	private String name;

	private double price;

	public Product (String name, double price)
	{
		this.name = name;
		this.price = price;
	}

	public Product ()
	{
	}
}
