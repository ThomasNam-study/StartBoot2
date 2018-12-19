package kr.purred.startboot2.model.reservation;

import java.time.LocalDate;
import java.util.List;

import kr.purred.startboot2.model.reservation.domain.PeriodicReservation;
import kr.purred.startboot2.model.reservation.domain.Reservation;
import kr.purred.startboot2.model.reservation.domain.SportType;

public interface ReservationService
{
	List<Reservation> query (String courtName);

	List<Reservation> all ();

	void make (Reservation reservation) throws ReservationNotAvailableException;

	List<SportType> getAllSportTypes ();

	SportType getSportType (int sportTypeId);

	void makePeriodic (PeriodicReservation periodicReservation) throws ReservationNotAvailableException;

	List<Reservation> findByDate (LocalDate date);

	void testFunc();
}
