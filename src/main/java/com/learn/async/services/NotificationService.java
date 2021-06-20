package com.learn.async.services;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class NotificationService {


    public void  sendTextMessage(String mobile){
        String threadName=Thread.currentThread().getName();
        sleep(3000);
        System.out.println("["+threadName + "]-"+"[Regullar]-["+ System.currentTimeMillis()  +"] - called 3rd party to send text message");
    }



    @Async
    public void sendAsyncTextMessage(String mobile){
        String threadName=Thread.currentThread().getName();
        sleep(3000);
        System.out.println("[" + threadName + "]-"+ "[Async]-["+ System.currentTimeMillis()  + "] - called 3rd party to send text message");
    }



    private void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
        }
    }
}
