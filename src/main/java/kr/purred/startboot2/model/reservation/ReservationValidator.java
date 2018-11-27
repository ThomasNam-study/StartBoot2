package kr.purred.startboot2.model.reservation;

import kr.purred.startboot2.model.reservation.domain.Reservation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

@Component
public class ReservationValidator implements Validator
{
	@Override
	public boolean supports (Class<?> clazz)
	{
		return Reservation.class.isAssignableFrom (clazz);
	}

	@Override
	public void validate (Object target, Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace (errors, "courtName", "required.courtName", "Court name is required.");
		ValidationUtils.rejectIfEmpty (errors, "date", "required.date", "Date is required.");
		ValidationUtils.rejectIfEmpty (errors, "hour", "required.hour", "hour is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace (errors, "player.name", "required.playerName", "Player name is required.");
		ValidationUtils.rejectIfEmpty (errors, "sportType", "required.sportType", "SportType is required.");

		Reservation reservation = (Reservation) target;

		LocalDate date = new java.sql.Date (reservation.getDate ().getTime ()).toLocalDate ();

		int hour = reservation.getHour ();

		if (date.getDayOfWeek () == DayOfWeek.SUNDAY)
		{
			if (hour < 8 || hour > 22)
				errors.reject ("Invalid.holidayHour", "Invalid holiday hour.");
		}
		else if (hour < 9 || hour > 21)
			errors.reject ("Invalid.weekdayHour", "Invalid weekday hour.");
	}
}
