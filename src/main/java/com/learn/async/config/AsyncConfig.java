package com.learn.async.config;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;




@Configuration
public class AsyncConfig extends AsyncConfigurerSupport {


    private AsyncExceptionEandler asyncExceptionEandler;


    @Autowired
    public AsyncConfig(AsyncExceptionEandler asyncExceptionEandler) {
        this.asyncExceptionEandler = asyncExceptionEandler;
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("aSync-");
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(500);
        executor.initialize();
        return executor;
    }


    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return asyncExceptionEandler;
    }

}
