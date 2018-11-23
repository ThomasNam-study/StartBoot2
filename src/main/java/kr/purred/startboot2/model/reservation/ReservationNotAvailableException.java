package kr.purred.startboot2.model.reservation;

import lombok.Getter;

import java.util.Date;

@Getter
public class ReservationNotAvailableException extends Exception
{
	private String courtName;

	private Date date;

	private int hour;

	public ReservationNotAvailableException (String courtName, Date date, int hour)
	{
		this.courtName = courtName;
		this.date = date;
		this.hour = hour;
	}
}
