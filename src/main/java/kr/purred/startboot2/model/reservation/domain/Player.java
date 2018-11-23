package kr.purred.startboot2.model.reservation.domain;

import lombok.Data;

@Data
public class Player
{
	private String name;

	private String phone;

	public Player ()
	{
	}

	public Player (String name, String phone)
	{
		this.name = name;
		this.phone = phone;
	}
}
