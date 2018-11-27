package kr.purred.startboot2.model.reservation;

import kr.purred.startboot2.model.reservation.domain.Reservation;
import kr.purred.startboot2.model.reservation.domain.SportType;

import java.util.List;

public interface ReservationService
{
	List<Reservation> query (String courtName);

	List<Reservation> all ();

	void make (Reservation reservation) throws ReservationNotAvailableException;

	List<SportType> getAllSportTypes ();

	SportType getSportType (int sportTypeId);
}
