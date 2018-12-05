package kr.purred.startboot2.controller.web;

import kr.purred.startboot2.model.reservation.PeriodicReservationValidator;
import kr.purred.startboot2.model.reservation.ReservationNotAvailableException;
import kr.purred.startboot2.model.reservation.ReservationService;
import kr.purred.startboot2.model.reservation.domain.PeriodicReservation;
import kr.purred.startboot2.model.reservation.domain.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.util.WebUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/periodicReservationForm")
@SessionAttributes("reservation")
@RequiredArgsConstructor
public class PeriodicReservationFormCt
{
	private final Map<Integer, String> pageForms = new HashMap<> (3);

	private final ReservationService reservationService;

	private final PeriodicReservationValidator periodicReservationValidator;

	@PostConstruct
	void init ()
	{
		pageForms.put (0, "reservationCourtForm");
		pageForms.put (1, "reservationTimeForm");
		pageForms.put (2, "reservationPlayerForm");
	}

	@GetMapping
	public String setupForm (Model model)
	{
		PeriodicReservation reservation = new PeriodicReservation ();

		reservation.setPlayer (new Player ());

		model.addAttribute ("reservation", reservation);

		return "reservationCourtForm";
	}

	@PostMapping(params = {"_cancel"})
	public String cancelForm (@RequestParam("_page") int currentPage)
	{
		return pageForms.get (currentPage);
	}

	@PostMapping(params = {"_finish"})
	public String finishForm (
			@Validated @ModelAttribute("reservation") PeriodicReservation reservation,
			BindingResult result, SessionStatus status,
			@RequestParam("_page") int currentPage) throws ReservationNotAvailableException
	{
		if (!result.hasErrors ())
		{
			reservationService.makePeriodic (reservation);
			status.setComplete ();

			return "redirect:reservationSuccess";
		}
		else
			return pageForms.get (currentPage);
	}

	@PostMapping
	public String submitForm (
			HttpServletRequest request,
			@ModelAttribute("reservation") PeriodicReservation reservation,
			BindingResult result, SessionStatus status,
			@RequestParam("_page") int currentPage) throws ReservationNotAvailableException
	{
		int targetPage = getTargetPage (request, "_target", currentPage);

		if (targetPage < currentPage)
			return pageForms.get (targetPage);

		validateCurrentPage (reservation, result, currentPage);

		if (!result.hasErrors ())
		{
			return pageForms.get (targetPage);
		}
		else
			return pageForms.get (currentPage);
	}

	@ModelAttribute("periods")
	public Map<Integer, String> periods ()
	{
		Map<Integer, String> periods = new HashMap<> ();

		periods.put (1, "Daily");
		periods.put (7, "Weekly");

		return periods;
	}

	private int getTargetPage (HttpServletRequest request, String paramPrefix, int currentPage)
	{
		Enumeration<String> paramNames = request.getParameterNames ();

		while (paramNames.hasMoreElements ())
		{
			String paramName = paramNames.nextElement ();

			if (paramName.startsWith (paramPrefix))
			{
				for (int i = 0; i < WebUtils.SUBMIT_IMAGE_SUFFIXES.length; i++)
				{
					String suffix = WebUtils.SUBMIT_IMAGE_SUFFIXES[i];

					if (paramName.endsWith (suffix))
						paramName = paramName.substring (0, paramName.length () - suffix.length ());
				}

				return Integer.parseInt (paramName.substring (paramPrefix.length ()));
			}
		}

		return currentPage;
	}

	@InitBinder
	public void initBinder (WebDataBinder binder)
	{
		binder.setValidator (periodicReservationValidator);
	}

	private void validateCurrentPage (PeriodicReservation reservation, BindingResult result, int curerntPage)
	{
		switch (curerntPage)
		{
			case 0 :
				periodicReservationValidator.validateCourt (reservation, result);
				break;

			case 1:
				periodicReservationValidator.validateTime (reservation, result);
				break;

			case 2:
				periodicReservationValidator.validatePlayer (reservation, result);
				break;
		}
	}
}
