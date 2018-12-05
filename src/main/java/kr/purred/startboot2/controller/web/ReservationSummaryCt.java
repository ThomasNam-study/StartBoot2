package kr.purred.startboot2.controller.web;

import kr.purred.startboot2.model.reservation.ReservationService;
import kr.purred.startboot2.model.reservation.domain.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservationSummary")
@RequiredArgsConstructor
public class ReservationSummaryCt
{
	private final ReservationService reservationService;

	@GetMapping
	public String generateSummary (@RequestParam("date") String selectedDate, Model model) throws Exception
	{
		List<Reservation> reservationList = new ArrayList<> ();

		try
		{
			Date summaryDate = new SimpleDateFormat ("yyyy-MM-dd").parse (selectedDate);

			reservationList = reservationService.findByDate (new java.sql.Date (summaryDate.getTime ()).toLocalDate ());
		}
		catch (ParseException ex)
		{
			StringWriter sw = new StringWriter ();
			PrintWriter pw = new PrintWriter (sw);

			ex.printStackTrace (pw);

			throw new Exception ("Invalid date format for reservation");
		}

		model.addAttribute ("reservations", reservationList);

		return "reservationSummary";
	}
}
