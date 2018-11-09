package kr.purred.startboot2.model.shop;

import kr.purred.startboot2.model.shop.model.Battery;
import kr.purred.startboot2.model.shop.model.Disc;
import kr.purred.startboot2.model.shop.model.Product;

public class ProductCreator
{
	public static Product createInstance (String productId)
	{
		switch (productId)
		{
			case "aaa":
				return new Battery ("AAA", 2.5);

			case "cdrw":
				return new Disc ("CD-RW", 1.5);

			case "dvdrw":
				return new Disc ("DVD-RW", 3.0);
		}

		throw new IllegalArgumentException ("Unkonown product");
	}
}
