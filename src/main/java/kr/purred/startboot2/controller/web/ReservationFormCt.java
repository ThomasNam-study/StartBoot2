package kr.purred.startboot2.controller.web;

import kr.purred.startboot2.model.reservation.ReservationNotAvailableException;
import kr.purred.startboot2.model.reservation.ReservationService;
import kr.purred.startboot2.model.reservation.domain.Player;
import kr.purred.startboot2.model.reservation.domain.Reservation;
import kr.purred.startboot2.model.reservation.domain.SportType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@RequestMapping("/reservationForm")
@SessionAttributes("reservation")
@RequiredArgsConstructor
public class ReservationFormCt
{
	private final ReservationService reservationService;

	@GetMapping
	public String setupForm (@RequestParam(value = "username", required = false) String username, Model model)
	{
		Reservation reservation = new Reservation ();

		reservation.setPlayer (new Player (username, null));

		model.addAttribute ("reservation", reservation);

		return "reservationForm";
	}

	@PostMapping
	public String submitForm (@ModelAttribute("reservation") Reservation reservation, BindingResult result, SessionStatus sessionStatus) throws ReservationNotAvailableException
	{
		reservationService.make (reservation);

		return "redirect:reservationSuccess";
	}

	@ModelAttribute("sportTyeps")
	public List<SportType> populateSportTypes ()
	{
		return reservationService.getAllSportTypes ();
	}
}
