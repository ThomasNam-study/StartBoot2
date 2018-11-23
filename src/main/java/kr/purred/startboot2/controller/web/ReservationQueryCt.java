package kr.purred.startboot2.controller.web;

import kr.purred.startboot2.model.reservation.ReservationService;
import kr.purred.startboot2.model.reservation.domain.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/reservationQuery")
@RequiredArgsConstructor
public class ReservationQueryCt
{
	private final ReservationService reservationService;

	@GetMapping
	public void setupForm (Model model)
	{
		List<Reservation> reservationList = reservationService.all ();

		model.addAttribute ("list", reservationList);
	}

	@PostMapping
	public String submitForm (@RequestParam("courtName") String courtName, Model model)
	{
		List<Reservation> reservationList;

		if (courtName != null)
			reservationList = reservationService.query (courtName);
		else
			reservationList = reservationService.all ();

		model.addAttribute ("list", reservationList);

		return "reservationQuery";
	}
}
