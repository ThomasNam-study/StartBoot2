package kr.purred.startboot2.model.reservation.domain;

import lombok.Data;

import java.util.Date;

@Data
public class PeriodicReservation
{
	private String countName;

	private Date fromDate;

	private Date toDate;

	private int period;

	private int hour;

	private Player player;
}
