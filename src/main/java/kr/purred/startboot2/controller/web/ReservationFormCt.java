package kr.purred.startboot2.controller.web;

import kr.purred.startboot2.model.reservation.ReservationNotAvailableException;
import kr.purred.startboot2.model.reservation.ReservationService;
import kr.purred.startboot2.model.reservation.ReservationValidator;
import kr.purred.startboot2.model.reservation.domain.Player;
import kr.purred.startboot2.model.reservation.domain.Reservation;
import kr.purred.startboot2.model.reservation.domain.SportType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
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

	private final ReservationValidator reservationValidator;

	@GetMapping
	public String setupForm (@RequestParam(value = "username", required = false) String username, Model model)
	{
		Reservation reservation = new Reservation ();

		reservation.setPlayer (new Player (username, null));

		model.addAttribute ("reservation", reservation);

		return "reservationForm";
	}

	@PostMapping
	public String submitForm (@ModelAttribute("reservation") @Validated Reservation reservation,
	                          BindingResult result, SessionStatus sessionStatus) throws ReservationNotAvailableException
	{
		if (result.hasErrors ())
			return "reservationForm";

		reservationService.make (reservation);

		sessionStatus.setComplete ();

		return "redirect:reservationSuccess";
	}

	@ModelAttribute("sportTypes")
	public List<SportType> populateSportTypes ()
	{
		return reservationService.getAllSportTypes ();
	}

	@InitBinder
	public void initBinder (WebDataBinder binder)
	{
		binder.setValidator (reservationValidator);
	}
}
