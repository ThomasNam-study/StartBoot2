package kr.purred.startboot2.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.purred.startboot2.model.PropertyConfig;

@RunWith (SpringRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PropertyTest
{
	@Autowired PropertyConfig propertyConfig;

	@Test
	public void startTest ()
	{
		System.out.println (propertyConfig.getPropertyTest ());
	}
}
