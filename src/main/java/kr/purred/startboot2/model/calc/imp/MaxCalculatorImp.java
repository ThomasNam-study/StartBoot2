package kr.purred.startboot2.model.calc.imp;

import kr.purred.startboot2.model.calc.MaxCalculator;

public class MaxCalculatorImp implements MaxCalculator
{
	@Override
	public double max (double a, double b)
	{
		double result = (a >= b) ? a : b;

		System.out.println ("max(" + a + ", " + b + ") = " + result);

		return result;
	}
}
