package dev.github.notifier.Controller;

import dev.github.notifier.Service.LinebotService;
import dev.github.notifier.data.PullRequestPayload;
import dev.github.notifier.data.PushPayload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static dev.github.notifier.ParseRequestBody.parsePullRequest;
import static dev.github.notifier.ParseRequestBody.parsePush;

@RestController
@RequestMapping("/webhook")
public class GithubWebhookController {
    LinebotService service = new LinebotService();
    String userId = "Ud589511f293ab77bba370171ffcbddd2";

    @Value("${line.bot.channel.access.token}")
    private String TOKEN;

    @PostMapping("/push")
    public void handlePush(@RequestBody PushPayload payload) {
        String message = parsePush(payload);
        service.sendPushMessage(userId,message,TOKEN);
    }
    @PostMapping("/pull_request")
    public void handlePullRequest(@RequestBody PullRequestPayload payload){
        String message = parsePullRequest(payload);
        service.sendPushMessage(userId,message,TOKEN);
    }
}
