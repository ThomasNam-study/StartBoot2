package kr.purred.startboot2.controller.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping ("/rest")
public class RestServerTestCt
{
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
}
