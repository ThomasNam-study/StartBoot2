package kr.purred.startboot2.model.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Disc extends Product
{
	private int capacity;

	public Disc (String name, double price)
	{
		super (name, price);
	}

	public Disc ()
	{
	}
}
