package kr.purred.startboot2.model.executor;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DemonstrationRunnable implements Runnable {
	@Override
	public void run ()
	{
		try
		{
			Thread.sleep (1000);

		}
		catch (InterruptedException e)
		{
			e.printStackTrace ();
		}

		System.out.println (Thread.currentThread ().getName ());
		System.out.printf ("Hello at %s \n", new Date ());
	}
}
