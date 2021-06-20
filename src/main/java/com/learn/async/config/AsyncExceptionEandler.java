package com.learn.async.config;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.util.Arrays;




@Component
public class AsyncExceptionEandler implements AsyncUncaughtExceptionHandler {


    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... args) {
        System.out.println("MethodName="+method + "Args="+ Arrays.toString(args)
        + "ErrorMessage="+ex.getMessage()
        );
    }
}
