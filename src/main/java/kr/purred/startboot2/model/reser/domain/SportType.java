package kr.purred.startboot2.model.reser.domain;

import lombok.Data;

@Data
public class SportType
{
	private int id;

	private String name;

	public SportType (int id, String name)
	{
		this.id = id;
		this.name = name;
	}
}
