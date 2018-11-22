package kr.purred.startboot2.controller.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandingAdvice
{
	@ExceptionHandler
	public String handlerDefault (Exception e)
	{
		return "error";
	}
}
