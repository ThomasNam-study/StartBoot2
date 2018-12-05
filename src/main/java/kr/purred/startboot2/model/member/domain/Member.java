package kr.purred.startboot2.model.member.domain;

import lombok.Data;

@Data
public class Member
{
	private String id;

	private String name;

	private String phone;

	private String email;

	public Member ()
	{
	}

	public Member (String id, String name, String phone, String email)
	{
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
}
