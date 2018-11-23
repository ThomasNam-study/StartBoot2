package kr.purred.startboot2.model.reservation;

import kr.purred.startboot2.model.reservation.domain.Reservation;

import java.util.List;

public interface ReservationService
{
	List<Reservation> query (String courtName);

	List<Reservation> all ();

	void make (Reservation reservation) throws ReservationNotAvailableException;
}
