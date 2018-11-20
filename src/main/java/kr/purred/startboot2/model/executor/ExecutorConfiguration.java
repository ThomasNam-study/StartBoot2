package kr.purred.startboot2.model.executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.support.TaskExecutorAdapter;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;
import org.springframework.scheduling.concurrent.ScheduledExecutorTask;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executors;

@Configuration
public class ExecutorConfiguration
{
	@Bean
	public TaskExecutorAdapter taskExecutorAdapter()
	{
		return new TaskExecutorAdapter (Executors.newCachedThreadPool ());
	}

	@Bean
	public SimpleAsyncTaskExecutor simpleAsyncTaskExecutor ()
	{
		return new SimpleAsyncTaskExecutor ();
	}

	@Bean
	public SyncTaskExecutor syncTaskExecutor ()
	{
		return new SyncTaskExecutor ();
	}

	@Bean
	public ScheduledExecutorTask scheduledExecutorTask(Runnable runnable)
	{
		ScheduledExecutorTask task = new ScheduledExecutorTask ();

		task.setPeriod (1000);
		task.setRunnable (runnable);

		return task;
	}

	@Bean
	public ScheduledExecutorFactoryBean scheduledExecutorFactoryBean (ScheduledExecutorTask scheduledExecutorTask)
	{
		ScheduledExecutorFactoryBean factoryBean = new ScheduledExecutorFactoryBean ();

		factoryBean.setScheduledExecutorTasks (scheduledExecutorTask);

		return factoryBean;
	}

	@Bean
	public ThreadPoolTaskExecutor threadPoolTaskExecutor ()
	{
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor ();

		taskExecutor.setCorePoolSize (50);
		taskExecutor.setMaxPoolSize (100);
		taskExecutor.setAllowCoreThreadTimeOut (true);
		taskExecutor.setWaitForTasksToCompleteOnShutdown (true);

		return taskExecutor;
	}
}
