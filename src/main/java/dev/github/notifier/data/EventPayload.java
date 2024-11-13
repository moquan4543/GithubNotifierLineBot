package dev.github.notifier.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
public class EventPayload {
    String destination;
    ArrayList<Event> events;
}
