package kr.purred.startboot2.controller.converter;

import kr.purred.startboot2.model.reservation.ReservationService;
import kr.purred.startboot2.model.reservation.domain.SportType;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SportTypeConverter implements Converter<String, SportType>
{
	private final ReservationService reservationService;

	@Override
	public SportType convert (String source)
	{
		int sportTypeId = Integer.parseInt (source);

		SportType sportType = reservationService.getSportType (sportTypeId);

		return sportType;
	}
}
