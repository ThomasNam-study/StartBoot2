package kr.purred.startboot2.controller.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AsyncConfiguration implements AsyncConfigurer
{
	@Override
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
		return new SimpleAsyncUncaughtExceptionHandler ();
	}

	/*@Bean
	public ThreadPoolTaskExecutor mvcTaskExecutor()
	{
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor ();

		taskExecutor.setThreadGroupName ("mvc-executor");

		return taskExecutor;
	}*/
}
