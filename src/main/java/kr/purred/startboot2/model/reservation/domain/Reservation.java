package kr.purred.startboot2.model.reservation.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Reservation
{
	private String courtName;

	private Date date;

	private int hour;

	private Player player;

	private SportType sportType;

	public Reservation ()
	{
	}

	public Reservation (String courtName, Date date, int hour, Player player, SportType sportType)
	{
		this.courtName = courtName;
		this.date = date;
		this.hour = hour;
		this.player = player;
		this.sportType = sportType;
	}
}
