package kr.purred.startboot2.model.calc.imp;

import kr.purred.startboot2.model.calc.ArithmeticCalculator;
import kr.purred.startboot2.model.calc.LoggingRequired;
import org.springframework.stereotype.Component;

@Component
public class ArithmeticCalculatorImp implements ArithmeticCalculator
{
	@LoggingRequired
	@Override
	public double add (double a, double b)
	{
		double r = a + b;

		System.out.println (a + " + " + b + " = " + r);

		return r;
	}

	@Override
	public double sub (double a, double b)
	{
		double r = a - b;

		System.out.println (a + " - " + b + " = " + r);

		return r;
	}

	@Override
	public double div (double a, double b)
	{
		double r = a / b;

		System.out.println (a + " / " + b + " = " + r);

		return r;
	}

	@Override
	public double mul (double a, double b)
	{
		double r = a * b;

		System.out.println (a + " * " + b + " = " + r);

		return r;
	}
}
