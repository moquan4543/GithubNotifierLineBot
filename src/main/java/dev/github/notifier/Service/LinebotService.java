package dev.github.notifier.Service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Service
public class LinebotService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String LINE_PUSH_API = "https://api.line.me/v2/bot/message/push";

    public void sendPushMessage(String userId, String messageText,String TOKEN) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(TOKEN);

        Map<String, Object> message1 = new HashMap<>();
        message1.put("type", "text");
        message1.put("text", messageText);

        List<Map<String, Object>> messages = new ArrayList<>();
        messages.add(message1);

        Map<String, Object> payload = new HashMap<>();
        payload.put("to", userId);
        payload.put("messages", messages);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(payload, headers);

        restTemplate.exchange(LINE_PUSH_API, HttpMethod.POST, request, String.class);
    }
}

