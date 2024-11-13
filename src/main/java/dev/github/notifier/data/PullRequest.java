package dev.github.notifier.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PullRequest {
    String url;
    String title;
    String body;
}
