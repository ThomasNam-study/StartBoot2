package kr.purred.startboot2.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import lombok.Getter;

@Component
@Getter
public class PropertyConfig
{
	@Value ("${property.test.name}")
	private String propertyTestName;

	@Value ("${propertyTest}")
	private String propertyTest;

	@Value ("${propertyTest}")
	private String[] propertyTestArray;

	/**
	 * 키의 값이 없을떄 바인딩된다.
	 */
	@Value ("${noKey:default value}")
	private String noKey;

	@Value ("#{'${propertyTest}'.split(',')}")
	private List<String> propertyTestList;

	@PostConstruct
	void init ()
	{
		System.out.println ("프로퍼티 테스트 시작");
		System.out.println (propertyTest);
		System.out.println (propertyTestName);
		System.out.println (noKey);

		Arrays.stream (propertyTestArray).forEach (System.out::println);

		System.out.println (propertyTestList);
	}
}
