package kr.purred.startboot2.test;

import kr.purred.startboot2.model.calc.ArithmeticCalculator;
import kr.purred.startboot2.model.calc.Counter;
import kr.purred.startboot2.model.calc.MaxCalculator;
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

	@Autowired
	ArithmeticCalculator calculator;

	@Test
	public void test ()
	{
		System.out.println ("Load Complete");

		System.out.println (cashierSimple);
	}

	@Test
	public void aopTest1 ()
	{
		System.out.println (calculator.add (4, 5));
		System.out.println (calculator.sub (10, 5));

		System.out.println (((MaxCalculator) calculator).max (1, 5));

		Counter c = (Counter) calculator;

		System.out.println (c.getCount ());

	}


}
