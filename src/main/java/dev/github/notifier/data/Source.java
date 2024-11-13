package dev.github.notifier.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Source {
    String type;
    String userId;
    String groupId;
}
