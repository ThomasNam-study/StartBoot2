package kr.purred.startboot2.model.calc.imp;

import kr.purred.startboot2.model.calc.Counter;

public class CounterImp implements Counter
{
	private int count;

	@Override
	public void increase ()
	{
		count++;
	}

	@Override
	public int getCount ()
	{
		return count;
	}
}
