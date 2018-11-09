package kr.purred.startboot2.model.calc.imp;

import kr.purred.startboot2.model.calc.MinCalculator;

public class MinCalculatorImp implements MinCalculator
{
	@Override
	public double min (double a, double b)
	{
		double result = (a < b) ? a : b;

		System.out.println ("min(" + a + ", " + b + ") = " + result);

		return result;
	}
}
