package com.learn.async.controllers;
import com.learn.async.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class NotificationController {

    private NotificationService notificationService;
    private Boolean flip=false;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String mobile){
        String threadName=Thread.currentThread().getName();
        notificationService.sendTextMessage(mobile);
        flip=!flip;
        if(flip) {
            return "[" + threadName + "]" + " - GREAT";
        }else{
            return "[" + threadName + "]" + " - OK";
        }
    }


    @GetMapping("/async")
    public String sendAsyncMessage(@RequestParam String mobile){
        String threadName=Thread.currentThread().getName();
        notificationService.sendAsyncTextMessage(mobile);
        flip=!flip;
        if(flip) {
            return "[" + threadName + "]" +  " - OK - ASYNC";
        }else{
            return "[" + threadName + "]" +  " - GREAT - ASYNC";
        }
    }


}
