package kr.purred.startboot2.controller.config;

import kr.purred.startboot2.controller.converter.SportTypeConverter;
import kr.purred.startboot2.controller.web.MeasurementInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
@RequiredArgsConstructor
public class WebConfigConfiguration implements WebMvcConfigurer
{
	private final SportTypeConverter sportTypeConverter;

	@Override
	public void addInterceptors (InterceptorRegistry registry)
	{
		registry.addInterceptor (measurementInterceptor ());
		registry.addInterceptor (localeChangeInterceptor ());
	}

	@Override
	public void addFormatters (FormatterRegistry registry)
	{
		registry.addConverter (sportTypeConverter);
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor()
	{
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor ();

		localeChangeInterceptor.setParamName ("language");;

		return localeChangeInterceptor;
	}

	@Bean
	public LocaleResolver localeResolver ()
	{
		SessionLocaleResolver localeResolver = new SessionLocaleResolver ();

		localeResolver.setDefaultLocale (Locale.KOREAN);

		return localeResolver;
	}

	@Bean
	public MeasurementInterceptor measurementInterceptor ()
	{
		return new MeasurementInterceptor ();
	}

}
