package dev.github.notifier.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Commits {
    String message;
    String timestamp;
}
