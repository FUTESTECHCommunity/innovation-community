package club.futurer.community.configurer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/**
 * Created by ZYC on 2017/12/26.
 */
//@EnableAsync
//@Configuration
public class DefaultAsyncConfigurer implements org.springframework.scheduling.annotation.AsyncConfigurer{
    private static final Logger logger = LoggerFactory.getLogger(DefaultAsyncConfigurer.class.getName());

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(10);
//        executor.setWaitForTasksToCompleteOnShutdown();
        executor.setAwaitTerminationSeconds(60 * 15);
        executor.setThreadNamePrefix("Async-Executor");
        executor.initialize();
//        executor.setQueueCapacity(); 如果太多就可能会OOM
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncExceptionHandler();
    }

    /**
     * 自定义异常处理类
     */
    private static class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            logger.info("Exception message - " + throwable.getMessage());
            logger.info("Method name - " + method.getName());
            for (Object param : objects) {
                logger.info("Parameter value - " + param);
            }
        }
    }
}


