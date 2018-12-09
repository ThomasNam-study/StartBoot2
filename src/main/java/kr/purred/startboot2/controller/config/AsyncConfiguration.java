package kr.purred.startboot2.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncConfiguration //extends WebMvcConfigurationSupport
{
	/*@Override
	protected void configureAsyncSupport (AsyncSupportConfigurer configurer)
	{
		//super.configureAsyncSupport (configurer);

		configurer.setDefaultTimeout (5000);
		//configurer.setTaskExecutor (mvcTaskExecutor ());
	}*/

	@Bean
	public ThreadPoolTaskExecutor mvcTaskExecutor()
	{
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor ();

		taskExecutor.setThreadGroupName ("mvc-executor");

		return taskExecutor;
	}
}
