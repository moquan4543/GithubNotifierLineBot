package dev.github.notifier.Controller;

import dev.github.notifier.data.Event;
import dev.github.notifier.data.EventPayload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LinebotController {
    @PostMapping("/callback")
    public static void handleCallback(@RequestBody EventPayload payload){
        for(Event event : payload.getEvents()){
            if("join".equals(event.getType())){

            }
        }

    }
}
