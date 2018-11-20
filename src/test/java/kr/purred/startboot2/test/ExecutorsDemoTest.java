package kr.purred.startboot2.test;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemoTest
{
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

	@Test
	public void executeTest () throws ExecutionException, InterruptedException
	{
		Runnable task = new DemonstrationRunnable ();

		ExecutorService cachedThreadPoolExecutorService = Executors.newCachedThreadPool ();

		if (cachedThreadPoolExecutorService.submit (task).get () == null)
		{
			System.out.printf ("Thread has succeeded at %s\n", new Date ());
		}
	}
}
