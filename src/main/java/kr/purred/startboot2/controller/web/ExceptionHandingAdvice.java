package kr.purred.startboot2.controller.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandingAdvice
{
	@ExceptionHandler(RestException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String error404 ()
	{
		return "ERROR!!@!!!";
	}

	@ExceptionHandler
	public String handlerDefault (Exception e)
	{
		return "error";
	}


}
