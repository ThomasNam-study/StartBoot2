package kr.purred.startboot2.model.shop;

import kr.purred.startboot2.model.shop.model.CashierSimple;
import kr.purred.startboot2.model.shop.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;


@Configuration
@PropertySource ("classpath:discount.properties")
public class ShopConfiguration
{
	@Value ("${summer.discount}")
	private Float discount;

	@Value ("classpath:banner.txt")
	// @Value ("classpath:com/purred/test/shop/banner.txt")
	private Resource banner;

	@Bean
	public Product aaa ()
	{
		return ProductCreator.createInstance ("aaa");
	}

	@Bean
	public Product cdrw ()
	{
		return ProductCreator.createInstance ("cdrw");
	}

	@Bean
	public Product dvdrw ()
	{
		return ProductCreator.createInstance ("dvdrw");
	}

	@PostConstruct
	void init ()
	{

		System.out.println (String.valueOf (discount));
		System.out.println (banner.getFilename ());

		try
		{
			Resource r = new UrlResource ("http://naver.com");

			Resource prop = new ClassPathResource ("discount.properties");

			Properties properties = PropertiesLoaderUtils.loadProperties (prop);

			System.out.println (properties.getProperty ("summer.discount"));
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace ();
		}
		catch (IOException e)
		{
			e.printStackTrace ();
		}
	}

	@Bean(initMethod = "openFile", destroyMethod = "closeFile")
	public CashierSimple cashierSimple ()
	{
		CashierSimple c = new CashierSimple ();

		return c;
	}
}
