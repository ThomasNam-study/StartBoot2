package kr.purred.startboot2.model.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;


@PropertySource ("classpath:discount.properties")
public class ShopConfiguration
{
	@Value ("${summer.discount}")
	private Float discount;

	@PostConstruct
	void init ()
	{
		System.out.println (String.valueOf (discount));
	}
}
