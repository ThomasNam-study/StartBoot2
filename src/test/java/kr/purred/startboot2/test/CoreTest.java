package kr.purred.startboot2.test;

import kr.purred.startboot2.model.shop.model.CashierSimple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith (SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CoreTest
{
	@Autowired
	CashierSimple cashierSimple;

	@Test
	public void test ()
	{
		System.out.println ("Load Complete");

		System.out.println (cashierSimple);
	}
}
