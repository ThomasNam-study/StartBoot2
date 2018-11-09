package kr.purred.startboot2.model.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Battery extends Product
{
	private boolean rechargeable;

	public Battery (String name, double price)
	{
		super (name, price);
	}

	public Battery ()
	{
	}
}
