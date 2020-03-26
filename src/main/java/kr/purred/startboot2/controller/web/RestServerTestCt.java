package kr.purred.startboot2.controller.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping ("/rest")
public class RestServerTestCt
{
	private int cnt = 0;

	@RequestMapping(value = "test")
	public String testPage (HttpServletRequest request)
	{
		Enumeration<String> parameterNames = request.getParameterNames ();

		while (parameterNames.hasMoreElements ())
		{
			String params = parameterNames.nextElement ();
			String value = request.getParameter (params);

			System.out.println ("param - " + params + ", " + value);
		}

		return "OK";
	}

	@RequestMapping(value = "test2")
	public String testPage2 (HttpServletRequest request) throws RestException
	{
		cnt++;

		if (cnt < 2)
			throw new RestException ();

		Enumeration<String> parameterNames = request.getParameterNames ();

		while (parameterNames.hasMoreElements ())
		{
			String params = parameterNames.nextElement ();
			String value = request.getParameter (params);

			System.out.println ("param - " + params + ", " + value);
		}

		return "OK";
	}
}
