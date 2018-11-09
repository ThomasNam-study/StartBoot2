package kr.purred.startboot2.model.calc.imp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(0)
public class CalculatorLoggingAspect
{
	@Pointcut("execution(* kr.purred.startboot2.model.calc.ArithmeticCalculator.add(..))")
	private void addOperation() {}

	@Before ("addOperation()")
	public void logBefore ()
	{
		System.out.println ("before log");
	}

	@Before ("execution(* kr.purred.startboot2.model.calc.ArithmeticCalculator.*(..))")
	public void executeAll (JoinPoint joinPoint)
	{
		System.out.println ("The method " + joinPoint.getSignature ().getName () + "() begin with " + Arrays.toString (joinPoint.getArgs ()));
	}

	@After("execution(* kr.purred.startboot2.model.calc.ArithmeticCalculator.*(..))")
	public void executeAllAfter (JoinPoint joinPoint)
	{
		System.out.println ("The method " + joinPoint.getSignature ().getName () + " end");
	}

	@AfterReturning(pointcut = "execution(* kr.purred.startboot2.model.calc.ArithmeticCalculator.add(..))",
		returning = "result")
	public void executeAllAfterReturning (JoinPoint joinPoint, Object result)
	{
		System.out.println ("The method " + joinPoint.getSignature ().getName () + " return " + result);
	}

	@Around("execution(* kr.purred.startboot2.model.calc.ArithmeticCalculator.sub(..))")
	public Object aroundSub (ProceedingJoinPoint joinPoint) throws Throwable
	{
		System.out.println ("The method sub start");

		try
		{
			Object result = joinPoint.proceed ();

			return result;
		}
		catch (IllegalArgumentException e)
		{
			throw e;
		}
	}
}
