package kr.purred.startboot2.model.reser.imp;

import kr.purred.startboot2.model.reser.ReservationService;
import kr.purred.startboot2.model.reser.domain.Player;
import kr.purred.startboot2.model.reser.domain.Reservation;
import kr.purred.startboot2.model.reser.domain.SportType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImp implements ReservationService
{
	public static final SportType TENNIS = new SportType (1, "Tennis");
	public static final SportType SOCCER = new SportType (2, "Soccer");

	private final List<Reservation> reservations = new ArrayList<> ();

	public ReservationServiceImp ()
	{
		reservations.add (new Reservation ("Tennis #1", LocalDate.of (2008, 1, 14), 16, new Player ("Roger", "N/A"), TENNIS));
		reservations.add (new Reservation ("Tennis #2", LocalDate.of (2008, 1, 14), 20, new Player ("Roger", "N/A"), TENNIS));
	}

	@Override
	public List<Reservation> query (String courtName)
	{
		return reservations.stream ().filter ((r) -> r.getCourtName ().equals (courtName)).collect(Collectors.toList ());
	}
}
