package kr.purred.startboot2.model.reservation.domain;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class Reservation
{
	@NotNull
	@Size(min = 4)
	private String courtName;

	@NotNull
	private Date date;

	@Min(9)
	@Max(21)
	private int hour;

	@Valid
	private Player player;

	@NotNull
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
