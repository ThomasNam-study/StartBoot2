package kr.purred.startboot2.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class AsyncConfiguration extends WebMvcConfigurationSupport // implements AsyncConfigurer
{
	// private final Logger log = LoggerFactory.getLogger(AsyncConfiguration.class);

	@Override
	protected void configureAsyncSupport (AsyncSupportConfigurer configurer)
	{
		// super.configureAsyncSupport (configurer);

		configurer.setDefaultTimeout (5000);
		configurer.setTaskExecutor (mvcTaskExecutor ());
	}

	/*@Override
	@Bean(name = "taskExecutor")
	public Executor getAsyncExecutor() {
		// log.debug("Creating Async Task Executor");

		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("mvc-executor-");
		executor.initialize();

		return executor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return (Throwable ex, Method method, Object... params) -> {
			System.err.println (ex);
			System.err.println (method);
		};
	}*/

	@Bean
	public ThreadPoolTaskExecutor mvcTaskExecutor()
	{
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor ();

		taskExecutor.setThreadGroupName ("mvc-executor");

		return taskExecutor;
	}
}
