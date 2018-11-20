package kr.purred.startboot2.model.reser;

import kr.purred.startboot2.model.reser.domain.Reservation;

import java.util.List;

public interface ReservationService
{
	List<Reservation> query (String courtName);
}
